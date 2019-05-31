<?php
session_start();
/*  This function is used to validate the data and strip slashes from the data if its there */
function validateAndStripSlash($testVar)
{
	if(!empty($testVar))
	{
		$testvar = stripslashes($testVar);
	}
	else
	{
		$testVar = NULL;
	}
	return $testVar;
}

/*  This function is used to validate the data*/
function validate($testVar1)
{
	if(!empty($testVar1))
	{
		return $testVar1;
	}
	else
	{
		$testVar1 = NULL;
	}
	return $testVar1;
}

/*  This function will check if the data is set*/
function validateIsSet($testVar2)
{
	if(isset($testVar2))
	{
		return $testVar2;
	}
	else
	{
		$testVar2 = NULL;
	}
	return $testVar2;
}

//Arrays to hold the success and error information
$errosOnPage = array();
$successfulValueOnPage = array();
$successfulValueOnPage[] = "Congratulations! You have successfully submitted the form";
$_SESSION['message'] = $errosOnPage;
	//$message = array();


//Get the Pick information for the car
$pickup_month              = $_POST['PICKUP_MONTH'];
$pickup_day                = $_POST['PICKUP_DAY'];                     
$pickup_year			   = $_POST['PICKUP_YEAR'];                   
$pickup_hour               = $_POST['PICKUP_HOUR'];                     
$pickup_minute             = $_POST['PICKUP_MINUTE'];                    
$pickup_am_pm              = $_POST['PICKUP_AM_PM'];



//Show the time and date information entered for Pickup as per AM/PM
if($pickup_am_pm == "AM")
{
	$successfulValueOnPage[] = "you entered Pick Up Date for car renting as " . ($pickup_month+1) . "/" . $pickup_day . "/" . $pickup_year . " " . $pickup_hour . ":" . $pickup_minute . " AM";
	$pickupTimestamp = mktime($pickup_hour, $pickup_minute, 0, $pickup_month, $pickup_day, $pickup_year);
}
else
{
	$successfulValueOnPage[] = "you entered Pick Up Date for car renting as " . ($pickup_month+1) . "/" . $pickup_day . "/" . $pickup_year . " " . $pickup_hour . ":" . $pickup_minute . " PM";
	$pickupTimestamp = mktime((12+$pickup_hour), $pickup_minute, 0, $pickup_month, $pickup_day, $pickup_year);
}

//Get the Return information for the car
$return_month              = $_POST['RETURN_MONTH'];                    
$return_day                = $_POST['RETURN_DAY'];                    
$return_year               = $_POST['RETURN_YEAR'];                      
$return_hour               = $_POST['RETURN_HOUR'];                     
$return_minute             = $_POST['RETURN_MINUTE'];                   
$return_am_pm              = $_POST['RETURN_AM_PM'];     


//Show the time and date information entered for Return as per AM/PM
if($return_am_pm == "AM")
{
	$successfulValueOnPage[] = "you entered Return Date for car renting as " . ($return_month+1) . "/" . $return_day . "/" . $return_year . " " . $return_hour . ":" . $return_minute . " AM.";
	$returnTimestamp = mktime($return_hour, $return_minute, 0, $return_month, $return_day, $return_year);
}
else
{
	$successfulValueOnPage[] = "you entered Return Date for car renting as " . ($return_month+1) . "/" . $return_day . "/" . $return_year . " " . $return_hour . ":" . $return_minute . " PM.";
	$returnTimestamp = mktime((12+$return_hour), $return_minute, 0, $return_month, $return_day, $return_year);
}

//Validate that Return information should be later than pickup time and date information
if(($returnTimestamp - $pickupTimestamp) <=0)
{
	$errosOnPage[returnDate] = "Your return date and time should be later than your pickup time for car renting.";
}


$pickup_location_code      = $_POST['PICKUP_LOCATION_CODE'];       
$pickup_street_address     = $_POST['PICKUP_STREET_ADDRESS'];          
$pickup_city_name          = $_POST['PICKUP_CITY_NAME'];           
$pickup_state              = $_POST['PICKUP_STATE'];                
$pickup_country_code       = $_POST['PICKUP_COUNTRY_CODE'];

//Validate the pickup location data for availability
$pickup_location_code = validateAndStripSlash($pickup_location_code);
$pickup_street_address = validateAndStripSlash($pickup_street_address);
$pickup_city_name = validateAndStripSlash($pickup_city_name);
$pickup_state = validateAndStripSlash($pickup_state);
$pickup_country_code = validateAndStripSlash($pickup_country_code);

//Validate to check that only airport code or puckup address should be specified and not both
if(($pickup_location_code != NULL) && (($pickup_street_address !=NULL) || ($pickup_city_name != NULL) || ($pickup_state !=NULL)))
{
	$errosOnPage[pickupLoc] = "Please enter only Pickup Airport Location or Pick up Address but not both.";
}

//Fill the array for the information given for pick loaction and if there is any errors
if($pickup_location_code == NULL)
{
	if($pickup_street_address != NULL)
	{
		$successfulValueOnPage[] = "you entered pickup street for car renting as $pickup_street_address.";
	}
	else
	{
		$errosOnPage[street] = "You forgot to enter street for car renting.";
	}
	if($pickup_city_name != NULL)
	{
		$successfulValueOnPage[] = "you entered pickup city for car renting as $pickup_city_name.";
	}
	else
	{
		$errosOnPage[city] = "You forgot to enter pickup city for car renting";
	}
	if($pickup_state != NULL)
	{
		$successfulValueOnPage[] = "you entered pickup state for car renting as $pickup_state.";
	}
	else
	{
		$errosOnPage[state] = "you forget to enter pickup state for car renting";
	}
	if($pickup_country_code != NULL)
	{
		$successfulValueOnPage[] = "you entered pickup country for car renting as $pickup_country_code.";
	}
	else
	{
		$errosOnPage[country] = "you forget to enter pickup country for car renting.";
	}
}
else
{
	$successfulValueOnPage[] = "you entered Airport code  for car renting as $pickup_location_code.";
}

$airline_code              = $_POST['AIRLINE_CODE']; 
$airline_code			   = validateAndStripSlash($airline_code);
$flight_number             = $_POST['FLIGHT_NUMBER'];                    
$flight_number			   = validateAndStripSlash($flight_number);

//validate if the optional airline is given then its corrosponding flight number should be given too
if(($airline_code == NULL) && ($flight_number != NULL) ||
	($airline_code != NULL) && ($flight_number == NULL))
{
	$errosOnPage[flightandairline] = "Please provide Flight Number and Airline code if any one of the information is filled.";
}

//fill the optional Airline Code and Flight Number to display
if($airline_code != NULL)
{
	$successfulValueOnPage[] = "you entered Airline code you flying from as $airline_code.";
}
if($flight_number != NULL)
{
	$successfulValueOnPage[] = "you entered Flight number you flying from as $flight_number.";
}


$rental_oneway             = $_POST['RENTAL_ONEWAY'];
$rental_oneway			   = validateIsSet($rental_oneway);

//Validate if return information is different than pickup information and capture it for display
if($rental_oneway != NULL)
{

	$return_location_code      = $_POST['RETURN_LOCATION_CODE'];
	$return_street_address     = $_POST['RETURN_STREET_ADDRESS'];            
	$return_city_name          = $_POST['RETURN_CITY_NAME'];           
	$return_state              = $_POST['RETURN_STATE'];              
	$return_country_code       = $_POST['RETURN_COUNTRY_CODE'];
	$return_location_code = validateAndStripSlash($return_location_code);
	$return_street_address = validateAndStripSlash($return_street_address);
	$return_city_name = validateAndStripSlash($return_city_name);
	$return_state = validateAndStripSlash($return_state);
	$return_country_code = validateAndStripSlash($return_country_code);
	if(($return_location_code != NULL) && (($return_street_address !=NULL) || ($return_city_name != NULL) || ($return_state !=NULL)))
	{
		$errosOnPage[returnLoc] = "Please enter only Return Airport Location or Return Address but not both.";
	}

	if($return_location_code == NULL)
	{
		if($return_street_address != NULL)
		{
			$successfulValueOnPage[] = "you entered returning car street for car renting as $pickup_street_address.";
		}
		else
		{
			$errosOnPage[retStreet] = "you forget to enter returning car street for car renting";
		}
		if($return_city_name != NULL)
		{
			$successfulValueOnPage[] = "you entered returning car  city for car renting as $return_city_name.";
		}
		else
		{
			$errosOnPage[retCity] = "you forget to enter returning car  city for car renting.";
		}
		if($return_state != NULL)
		{
			$successfulValueOnPage[] = "you entered returning car  state for car renting as $return_state.";
		}
		else
		{
			$errosOnPage[retState] = "you forget to enter returning car  state for car renting.";
		}
		if($return_country_code != NULL)
		{
			$successfulValueOnPage[] = "you entered returning car  country for car renting as $return_country_code.";
		}
		else
		{
			$errosOnPage[retCountry] = "you forget to enter returning car  country for car renting.";
		}
	}
	else
	{
		$successfulValueOnPage[] = "you entered returning car Airport code  for car renting as $return_location_code.";
	}
}

//Validate the discount code if entered and use it for display
$rate_code = $_POST['RATE_CODE'];  
if(validateAndStripSlash($rate_code) != NULL)
{
	$successfulValueOnPage[] = "you entered discount code for car renting as $rate_code.";
}

//validate the optional child infant information.
$child_infant_seat = $_POST['CHILD_INFANT_SEAT'];
$child_infant_seat_quantity= $_POST['CHILD_INFANT_SEAT_QUANTITY'];
$child_infant_seat = validateAndStripSlash($child_infant_seat);
$child_infant_seat_quantity= validateAndStripSlash($child_infant_seat_quantity);

//If check box for infant seat is entered then make sure the quantity is specified
if((($child_infant_seat != NULL) && ($child_infant_seat_quantity == NULL)) ||
	(($child_infant_seat != NULL) && ($child_infant_seat_quantity == NULL)))
{
	$errosOnPage[infant] = "Please enter both infant seats and its Quantity Information and not just one.";
}
if(($child_infant_seat != NULL) && ($child_infant_seat_quantity != NULL))
{
	$successfulValueOnPage[] = "you selected " . $child_infant_seat_quantity . " infant seats for car renting.";
}


//validate the optional child safety seat information.
$child_safety_seat = $_POST['CHILD_SAFETY_SEAT'];  
$child_safety_seat_quantity= $_POST['CHILD_SAFETY_SEAT_QUANTITY'];
$child_safety_seat = validateAndStripSlash($child_safety_seat);
$child_safety_seat_quantity= validateAndStripSlash($child_safety_seat_quantity);

//If check box for child safety seat is entered then make sure the quantity is specified
if((($child_safety_seat != NULL) && ($child_safety_seat_quantity == NULL)) ||
	(($child_safety_seat != NULL) && ($child_safety_seat_quantity == NULL)))
{
	$errosOnPage[safety] = "Please enter both child safty seats and its Quantity Information and not just one.";
}

if(($child_safety_seat != NULL) && ($child_safety_seat_quantity != NULL))
{
	$successfulValueOnPage[] = "you selected " . $child_safety_seat_quantity . " child safety seats for car renting.";
}



//validate the optional booster seat information.
$child_booster_seat = $_POST['CHILD_BOOSTER_SEAT'];      
$child_booster_seat_quantity= $_POST['CHILD_BOOSTER_SEAT_QUANTITY'];
$child_booster_seat  = validateAndStripSlash($child_booster_seat);
$child_booster_seat_quantity= validateAndStripSlash($child_booster_seat_quantity);

//If check box for booster seat is entered then make sure the quantity is specified
if((($child_booster_seat != NULL) && ($child_booster_seat_quantity == NULL)) ||
	(($child_booster_seat != NULL) && ($child_booster_seat_quantity == NULL)))
{
	$errosOnPage[booster] = "Please enter both booster seats and its Quantity Information and not just one.";
}
if(($child_booster_seat != NULL) && ($child_booster_seat_quantity != NULL))
{
	$successfulValueOnPage[] = "you selected " . $child_booster_seat_quantity . " booster seats for car renting."; 
}

$car_group_code = $_POST['CAR_GROUP_CODE'];

//validate the car type selected
$car_group_code = validateAndStripSlash($car_group_code);

//Check the type of car selected and use it for Display
if($car_group_code != NULL)
{
	if(car_group_code == "subcompact")
	{
		$successfulValueOnPage[] = "you selected subcompact car type(51.99USD) for car renting."; 
	}
	else if(car_group_code == "compact")
	{
		$successfulValueOnPage[] = "you selected compact car type(53.99USD) for car renting."; 
	}
	else if(car_group_code == "intermediate")
	{
		$successfulValueOnPage[] = "you selected intermediate car type(56.99USD) for car renting."; 
	}
	else if(car_group_code == "standardsize")
	{
		$successfulValueOnPage[] = "you selected standardsize car type(61.99USD) for car renting."; 
	}
	else if(car_group_code == "fullsize")
	{
		$successfulValueOnPage[] = "you selected fullsize car type(63.99USD) for car renting."; 
	}
}
else
{
	$errosOnPage[type] = "You forget to select car type for car renting.";
}


$cdw_accept  = $_POST['CDW_ACCEPT'];
//validate the Loss Damage Waiver if entered
$cdw_accept         = validateAndStripSlash($cdw_accept);
if($cdw_accept != NULL)
{
	$successfulValueOnPage[] = "you selected Loss Damage Waiver ( 22.99 USD per day ) for car renting."; 
}

$pai_accept = $_POST['PAI_ACCEPT'];                      
//validate the Personal Accident insurance if entered
$pai_accept         = validateAndStripSlash($pai_accept);
if($pai_accept != NULL)
{
	$successfulValueOnPage[] = "you selected Personal Accident insurance ( 22.99 USD per day ) for car renting."; 
}

$ali_accept = $_POST['ALI_ACCEPT'];
//validate the Additional Liability Insurance if entered
$ali_accept = validateAndStripSlash($ali_accept);
if($ali_accept != NULL)
{
	$successfulValueOnPage[] = "you selected Additional Liability Insurance ( 11.99 USD per day ) for car renting."; 
}

//validate the Personal information entered
$first_name = $_POST['FIRST_NAME'];
$first_name = validateAndStripSlash($first_name);
if($first_name != NULL)
{
	$successfulValueOnPage[] = "you entered your first name for car renting as $first_name.";
}
else
{
	$errosOnPage[fname] = "you forget to enter your first name for car renting.";
}

$last_name = $_POST['LAST_NAME'];        
$last_name = validateAndStripSlash($last_name);
if($last_name != NULL)
{
	$successfulValueOnPage[] = "you entered your last name for car renting as $last_name.";
}
else
{
	$errosOnPage[lname] = "you forget to enter your last name for car renting.";
}

$email_address = $_POST['EMAIL_ADDRESS'];
$email_address = validate($email_address);
if($email_address != NULL)
{
	$successfulValueOnPage[] = "you entered your email address for car renting as $email_address.";
}
else
{
	$errosOnPage[email] = "you forget to enter your email address for car renting";
}

if(!empty($errosOnPage)){
	//echo "sizeof($errosOnPage)";
	$errosOnPage[errors] = "Your form contans errors! Please correct them before submission.";
	//echo $errosOnPage;
}else{

	$_SESSION['page_success-list'] = $successfulValueOnPage;
}

$_SESSION['page_errors_list'] = $errosOnPage;



echo 'http://'.$_SERVER['SERVER_NAME'].'/rentalform.php';
/*if (!headers_sent()) {
    header('Location: ./rentalform.php');
    exit;
}*/
if (headers_sent()) { ?>
    <!-- die("Redirect failed. Please click on this link: <a href=...>"); -->
    <script type="text/javascript">
    	location.href = 'rentalform.php';
    </script>
<?php }
else {
    exit(header('Location:'.$_SERVER['SERVER_NAME'].'/rentalform.php'));
}
?>