<?php
error_reporting(0);
session_start();

// if(isset($_SESSION['page_errors_list'])) {
// 	$errorsArr = $_SESSION['page_errors_list'];
// 	if(!empty($errorsArr)) {
// 		// Implies there are errors on the page. Display the error accordingly
// 		echo '<pre>';
// 		// print_r($errorsArr);
// 		// echo $_SESSION['page_errors_list']['carRent'];
// 		echo '</pre>';
// 	}
// }
?>
<!DOCTYPE html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Car Rental Company</TITLE>
</HEAD>
<BODY BGCOLOR="#FFFFFF" MARGINHEIGHT=0 MARGINWIDTH=0 TOPMARGIN=0 LEFTMARGIN=0>
<FORM METHOD="post" NAME="RES_FORM" id="RES_FORM" ACTION="rental.php">

<TABLE border=0 BGCOLOR="#9DB5CE" cellPadding=0 cellSpacing=0 width="75%">
<tr>
<td>

<table width="100%" cellspacing=0 cellpadding=0 border=0>
	<tr>
		<td align="center"><h1>Make a Reservation</h1></td>
	</tr>
</table>
<div><center><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['errors']) ? $_SESSION['page_errors_list']['errors'] : ""; ?></p></center></div>
<div><center><p style="color: green"><?php if(!($_SESSION['page_errors_list'])) {foreach($_SESSION['page_success-list'] as $value)
 {
 	echo "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; $value <br/>";
 }}?></p></center></div>
<!-- Rental Date & Time Begins -->
<fieldset><legend><h3>Rental Date and Time</h3></legend>
<TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="0" BORDER="0">
  <TR>
	<TD width="35%">Pick-up Date:</TD>
	<td width="30%" valign=middle>&nbsp;</td>
	<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['returnDate']) ? $_SESSION['page_errors_list']['returnDate'] : ""; ?></p></div>
	<TD width="45%">Return Date:</TD></TR>
  </TR>
  <TR>
	<TD width="35%"><SELECT NAME="PICKUP_MONTH"><OPTION VALUE="0">January</OPTION><OPTION VALUE="1">February</OPTION><OPTION VALUE="2">March</OPTION><OPTION VALUE="3">April</OPTION><OPTION VALUE="4">May</OPTION><OPTION VALUE="5">June</OPTION><OPTION VALUE="6">July</OPTION><OPTION VALUE="7">August</OPTION><OPTION VALUE="8">September</OPTION><OPTION VALUE="9">October</OPTION><OPTION VALUE="10">November</OPTION><OPTION VALUE="11">December</OPTION></SELECT>
	
	<SELECT NAME="PICKUP_DAY"><OPTION VALUE="1">1</OPTION><OPTION VALUE="2">2</OPTION><OPTION VALUE="3">3</OPTION><OPTION VALUE="4">4</OPTION><OPTION VALUE="5">5</OPTION><OPTION VALUE="6">6</OPTION><OPTION VALUE="7">7</OPTION><OPTION VALUE="8">8</OPTION><OPTION VALUE="9">9</OPTION><OPTION VALUE="10">10</OPTION><OPTION VALUE="11">11</OPTION><OPTION VALUE="12">12</OPTION><OPTION VALUE="13">13</OPTION><OPTION VALUE="14">14</OPTION><OPTION VALUE="15">15</OPTION><OPTION VALUE="16">16</OPTION><OPTION VALUE="17">17</OPTION><OPTION VALUE="18">18</OPTION><OPTION VALUE="19">19</OPTION><OPTION VALUE="20">20</OPTION><OPTION VALUE="21">21</OPTION><OPTION VALUE="22">22</OPTION><OPTION VALUE="23">23</OPTION><OPTION VALUE="24">24</OPTION><OPTION VALUE="25">25</OPTION><OPTION VALUE="26">26</OPTION><OPTION VALUE="27">27</OPTION><OPTION VALUE="28">28</OPTION><OPTION VALUE="29">29</OPTION><OPTION VALUE="30">30</OPTION><OPTION VALUE="31">31</OPTION></SELECT>
	
	<SELECT NAME="PICKUP_YEAR"><OPTION VALUE="2005">2005</OPTION><OPTION VALUE="2006">2006</OPTION><OPTION VALUE="2007">2007</OPTION><OPTION VALUE="2008">2008</OPTION><OPTION VALUE="2009">2009</OPTION></SELECT></TD>
	<td width="30%" valign=middle>&nbsp;</td>
	<TD width="45%">
	
	<SELECT NAME="RETURN_MONTH" ><OPTION VALUE="0">January</OPTION><OPTION VALUE="1">February</OPTION><OPTION VALUE="2">March</OPTION><OPTION VALUE="3">April</OPTION><OPTION VALUE="4">May</OPTION><OPTION VALUE="5">June</OPTION><OPTION VALUE="6">July</OPTION><OPTION VALUE="7">August</OPTION><OPTION VALUE="8">September</OPTION><OPTION VALUE="9">October</OPTION><OPTION VALUE="10">November</OPTION><OPTION VALUE="11">December</OPTION></SELECT>
	
	<SELECT NAME="RETURN_DAY"><OPTION VALUE="1">1</OPTION><OPTION VALUE="2">2</OPTION><OPTION VALUE="3">3</OPTION><OPTION VALUE="4">4</OPTION><OPTION VALUE="5">5</OPTION><OPTION VALUE="6">6</OPTION><OPTION VALUE="7">7</OPTION><OPTION VALUE="8">8</OPTION><OPTION VALUE="9">9</OPTION><OPTION VALUE="10">10</OPTION><OPTION VALUE="11">11</OPTION><OPTION VALUE="12">12</OPTION><OPTION VALUE="13">13</OPTION><OPTION VALUE="14">14</OPTION><OPTION VALUE="15">15</OPTION><OPTION VALUE="16">16</OPTION><OPTION VALUE="17">17</OPTION><OPTION VALUE="18">18</OPTION><OPTION VALUE="19" >19</OPTION><OPTION VALUE="20">20</OPTION><OPTION VALUE="21">21</OPTION><OPTION VALUE="22">22</OPTION><OPTION VALUE="23">23</OPTION><OPTION VALUE="24">24</OPTION><OPTION VALUE="25">25</OPTION><OPTION VALUE="26">26</OPTION><OPTION VALUE="27">27</OPTION><OPTION VALUE="28">28</OPTION><OPTION VALUE="29">29</OPTION><OPTION VALUE="30">30</OPTION><OPTION VALUE="31">31</OPTION></SELECT>
	
	<SELECT NAME="RETURN_YEAR"><OPTION VALUE="2005">2005</OPTION><OPTION VALUE="2006">2006</OPTION><OPTION VALUE="2007">2007</OPTION><OPTION VALUE="2008">2008</OPTION><OPTION VALUE="2009">2009</OPTION></SELECT></TD></TR>
  </TR>

   <TR>
	<TD width="35%">Pick-up Time:</TD>
	<td width="30%" valign=middle>&nbsp;</td>
	<TD width="45%">Return Time:</TD></TR>
  </TR>
  <TR>
	<TD width="35%">
	<SELECT NAME="PICKUP_HOUR" ><OPTION VALUE="1">1</OPTION><OPTION VALUE="2">2</OPTION><OPTION VALUE="3">3</OPTION><OPTION VALUE="4">4</OPTION><OPTION VALUE="5">5</OPTION><OPTION VALUE="6">6</OPTION><OPTION VALUE="7">7</OPTION><OPTION VALUE="8">8</OPTION><OPTION VALUE="9">9</OPTION><OPTION VALUE="10">10</OPTION><OPTION VALUE="11">11</OPTION><OPTION VALUE="12">12</OPTION></SELECT>
	<SELECT NAME="PICKUP_MINUTE" ><OPTION VALUE="00">00</OPTION><OPTION VALUE="15">15</OPTION><OPTION VALUE="30">30</OPTION><OPTION VALUE="45">45</OPTION></SELECT>
	<INPUT TYPE=radio  NAME="PICKUP_AM_PM"  VALUE="AM" CHECKED>AM<INPUT TYPE=radio  NAME="PICKUP_AM_PM"  VALUE="PM">PM</TD>
	<td width="30%" valign=middle>&nbsp;</td>
	<TD width="45%">
	<SELECT NAME="RETURN_HOUR" ><OPTION VALUE="1">1</OPTION><OPTION VALUE="2">2</OPTION><OPTION VALUE="3">3</OPTION><OPTION VALUE="4">4</OPTION><OPTION VALUE="5">5</OPTION><OPTION VALUE="6">6</OPTION><OPTION VALUE="7">7</OPTION><OPTION VALUE="8">8</OPTION><OPTION VALUE="9">9</OPTION><OPTION VALUE="10">10</OPTION><OPTION VALUE="11">11</OPTION><OPTION VALUE="12">12</OPTION></SELECT><SELECT NAME="RETURN_MINUTE" ><OPTION VALUE="00">00</OPTION><OPTION VALUE="15">15</OPTION><OPTION VALUE="30">30</OPTION><OPTION VALUE="45">45</OPTION></SELECT>
	<INPUT TYPE=radio  NAME="RETURN_AM_PM"  VALUE="AM" CHECKED>AM<INPUT TYPE=radio  NAME="RETURN_AM_PM"  VALUE="PM">PM</TD></TR>
  </TR>
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="30%">&nbsp;</td>
	<TD width="45%">&nbsp;</TD></TR>
   </TR>
</TABLE>
</fieldset>
<br>
<!-- Rental Date & Time Ends -->
<!-- Rental Location Information Begins -->
<fieldset><legend><h3>Rental Location Information</h3></legend>
<TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="0" BORDER="0">
   <TR>
	<TD width="35%">&nbsp;</TD>
	<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['pickupLoc']) ? $_SESSION['page_errors_list']['pickupLoc'] : ""; ?></p></div>
	<td width="40%" valign=middle><h2>-OR-</h2></td>
	<TD width="25%">&nbsp;</TD></TR>
  </TR>
 <TR>
	<TD width="35%">AirportLocationCode:</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['street']) ? $_SESSION['page_errors_list']['street'] : ""; ?></p></div>
	<TD width="25%">Street Address:</TD></TR>
  </TR>
   <TR>
	<TD width="35%"><INPUT TYPE=text NAME="PICKUP_LOCATION_CODE" SIZE=3  MAXLENGTH=3>(if known)</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%"><INPUT TYPE=text NAME="PICKUP_STREET_ADDRESS" SIZE=8  MAXLENGTH=30></TD></TR>
  </TR>
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%">City/Town:</TD></TR>
  </TR>
   <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['city']) ? $_SESSION['page_errors_list']['city'] : ""; ?></p></div>
	<TD width="25%"><INPUT TYPE=text NAME="PICKUP_CITY_NAME" SIZE=8  MAXLENGTH=30></TD></TR>
  </TR>
 
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['state']) ? $_SESSION['page_errors_list']['state'] : ""; ?></p></div>
	<TD width="25%">State/Province:</TD></TR>
  </TR>
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%"><SELECT NAME="PICKUP_STATE"  width=165><OPTION VALUE="">Please Select One</OPTION><OPTION VALUE="Not Applicable">Not Applicable</OPTION><OPTION VALUE="Alabama">Alabama</OPTION><OPTION VALUE="Alaska">Alaska</OPTION><OPTION VALUE="Arizona">Arizona</OPTION><OPTION VALUE="Arkansas">Arkansas</OPTION><OPTION VALUE="California">California</OPTION><OPTION VALUE="Colorado">Colorado</OPTION><OPTION VALUE="Connecticut">Connecticut</OPTION><OPTION VALUE="Delaware">Delaware</OPTION><OPTION VALUE="District of Columbia">District of Columbia</OPTION><OPTION VALUE="Florida">Florida</OPTION><OPTION VALUE="Georgia">Georgia</OPTION><OPTION VALUE="Hawaii">Hawaii</OPTION><OPTION VALUE="Idaho">Idaho</OPTION><OPTION VALUE="Illinois">Illinois</OPTION><OPTION VALUE="Indiana">Indiana</OPTION><OPTION VALUE="Iowa">Iowa</OPTION><OPTION VALUE="Kansas">Kansas</OPTION><OPTION VALUE="Kentucky">Kentucky</OPTION><OPTION VALUE="Louisiana">Louisiana</OPTION><OPTION VALUE="Maine">Maine</OPTION><OPTION VALUE="Maryland">Maryland</OPTION><OPTION VALUE="Massachusetts">Massachusetts</OPTION><OPTION VALUE="Michigan">Michigan</OPTION><OPTION VALUE="Minnesota">Minnesota</OPTION><OPTION VALUE="Mississippi">Mississippi</OPTION><OPTION VALUE="Missouri">Missouri</OPTION><OPTION VALUE="Montana">Montana</OPTION><OPTION VALUE="Nebraska">Nebraska</OPTION><OPTION VALUE="Nevada">Nevada</OPTION><OPTION VALUE="New Hampshire">New Hampshire</OPTION><OPTION VALUE="New Jersey">New Jersey</OPTION><OPTION VALUE="New Mexico">New Mexico</OPTION><OPTION VALUE="New York">New York</OPTION><OPTION VALUE="North Carolina">North Carolina</OPTION><OPTION VALUE="North Dakota">North Dakota</OPTION><OPTION VALUE="Ohio">Ohio</OPTION><OPTION VALUE="Oklahoma">Oklahoma</OPTION><OPTION VALUE="Oregon">Oregon</OPTION><OPTION VALUE="Pennsylvania">Pennsylvania</OPTION><OPTION VALUE="Rhode Island">Rhode Island</OPTION><OPTION VALUE="South Carolina">South Carolina</OPTION><OPTION VALUE="South Dakota">South Dakota</OPTION><OPTION VALUE="Tennessee">Tennessee</OPTION><OPTION VALUE="Texas">Texas</OPTION><OPTION VALUE="Utah">Utah</OPTION><OPTION VALUE="Vermont">Vermont</OPTION><OPTION VALUE="Virginia">Virginia</OPTION><OPTION VALUE="Washington">Washington</OPTION><OPTION VALUE="West Virginia">West Virginia</OPTION><OPTION VALUE="Wisconsin">Wisconsin</OPTION><OPTION VALUE="Wyoming">Wyoming</OPTION></SELECT></TD></TR>
  </TR>
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['country']) ? $_SESSION['page_errors_list']['country'] : ""; ?></p></div>
	<TD width="25%">Country:</TD></TR>
  </TR>
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%"><SELECT NAME="PICKUP_COUNTRY_CODE" ><OPTION VALUE="AL">Albania</OPTION><OPTION VALUE="AD">Andorra</OPTION><OPTION 
VALUE="AO">Angola</OPTION><OPTION VALUE="AI">Anguilla</OPTION><OPTION VALUE="AG">Antigua</OPTION><OPTION 
VALUE="AR">Argentina</OPTION><OPTION VALUE="AB">Aruba</OPTION><OPTION VALUE="AU">Australia</OPTION><OPTION 
VALUE="AT">Austria</OPTION><OPTION VALUE="AZ">Azerbaijan</OPTION><OPTION VALUE="BS">Bahamas</OPTION><OPTION 
VALUE="BH">Bahrain</OPTION><OPTION VALUE="BA">Belarus</OPTION><OPTION VALUE="BE">Belgium</OPTION><OPTION 
VALUE="BZ">Belize</OPTION><OPTION VALUE="BP">Benin (Peoples Republic of)</OPTION><OPTION 
VALUE="YE">Bonaire</OPTION><OPTION VALUE="QB">Bosnia</OPTION><OPTION VALUE="BW">Botswana</OPTION><OPTION 
VALUE="BR">Brazil</OPTION><OPTION VALUE="BN">Brunei</OPTION><OPTION VALUE="BG">Bulgaria</OPTION><OPTION 
VALUE="UV">Burkina Faso</OPTION><OPTION VALUE="CM">Cameroon</OPTION><OPTION VALUE="CA">Canada</OPTION><OPTION 
VALUE="CB">Cape Verdi Is.</OPTION><OPTION VALUE="CF">Central African Republic</OPTION><OPTION 
VALUE="CD">Chad</OPTION><OPTION VALUE="CL">Chile</OPTION><OPTION VALUE="CN">China</OPTION><OPTION 
VALUE="CJ">Comores</OPTION><OPTION VALUE="ZM">Congo (Dem. Rep. of the)</OPTION><OPTION VALUE="CK">Cook Islands 
(Rarotonga)</OPTION><OPTION VALUE="CR">Costa Rica</OPTION><OPTION VALUE="HR">Croatia</OPTION><OPTION 
VALUE="AN">Curacao (Netherland Antilles)</OPTION><OPTION VALUE="CY">Cyprus</OPTION><OPTION VALUE="CS">Czech 
Republic</OPTION><OPTION VALUE="DK">Denmark</OPTION><OPTION VALUE="DO">Dominican Republic</OPTION><OPTION 
VALUE="EC">Ecuador</OPTION><OPTION VALUE="EG">Egypt</OPTION><OPTION VALUE="EL">El Salvador</OPTION><OPTION 
VALUE="EQ">Equatorial Guinea</OPTION><OPTION VALUE="EE">Estonia</OPTION><OPTION VALUE="ET">Ethiopia</OPTION><OPTION 
VALUE="FO">Faroe Islands</OPTION><OPTION VALUE="FJ">Fiji Islands</OPTION><OPTION VALUE="FI">Finland</OPTION><OPTION 
VALUE="FR">France</OPTION><OPTION VALUE="FG">French Guiana</OPTION><OPTION VALUE="GA">Gabon</OPTION><OPTION 
VALUE="GE">Georgia</OPTION><OPTION VALUE="DE">Germany</OPTION><OPTION VALUE="GH">Ghana</OPTION><OPTION 
VALUE="GI">Gibraltar</OPTION><OPTION VALUE="CT">Grand Cayman</OPTION><OPTION VALUE="GR">Greece</OPTION><OPTION 
VALUE="GD">Grenada</OPTION><OPTION VALUE="GP">Guadeloupe(French West Indies)</OPTION><OPTION 
VALUE="GU">Guam</OPTION><OPTION VALUE="GT">Guatemala</OPTION><OPTION VALUE="GN">Guinea</OPTION><OPTION 
VALUE="HT">Haiti</OPTION><OPTION VALUE="HD">Honduras</OPTION><OPTION VALUE="HK">Hong Kong</OPTION><OPTION 
VALUE="HU">Hungary</OPTION><OPTION VALUE="IS">Iceland</OPTION><OPTION VALUE="IN">India</OPTION><OPTION 
VALUE="ID">Indonesia</OPTION><OPTION VALUE="IE">Ireland (Republic)</OPTION><OPTION VALUE="IL">Israel</OPTION><OPTION 
VALUE="IT">Italy</OPTION><OPTION VALUE="CI">Ivory Coast</OPTION><OPTION VALUE="JM">Jamaica</OPTION><OPTION 
VALUE="JO">Jordan</OPTION><OPTION VALUE="KZ">Kazakhstan</OPTION><OPTION VALUE="KE">Kenya</OPTION><OPTION 
VALUE="KW">Kuwait</OPTION><OPTION VALUE="LV">Latvia</OPTION><OPTION VALUE="LB">Lebanon</OPTION><OPTION 
VALUE="LS">Lesotho</OPTION><OPTION VALUE="LT">Lithuania</OPTION><OPTION VALUE="LU">Luxembourg</OPTION><OPTION 
VALUE="MK">Macau</OPTION><OPTION VALUE="QM">Macedonia (Fyrom)</OPTION><OPTION VALUE="MG">Madagascar</OPTION><OPTION 
VALUE="MW">Malawi</OPTION><OPTION VALUE="MY">Malaysia</OPTION><OPTION VALUE="ML">Mali</OPTION><OPTION 
VALUE="MT">Malta</OPTION><OPTION VALUE="MQ">Martinique</OPTION><OPTION VALUE="MU">Mauritius</OPTION><OPTION 
VALUE="MX">Mexico</OPTION><OPTION VALUE="MD">Moldova</OPTION><OPTION VALUE="MA">Morocco</OPTION><OPTION 
VALUE="MZ">Mozambique</OPTION><OPTION VALUE="SW">Namibia (South West Africa)</OPTION><OPTION VALUE="NC">New 
Caledonia</OPTION><OPTION VALUE="NZ">New Zealand</OPTION><OPTION VALUE="NI">Nicaragua</OPTION><OPTION 
VALUE="NG">Nigeria</OPTION><OPTION VALUE="NO">Norway</OPTION><OPTION VALUE="OM">Oman (Sultanate of)</OPTION><OPTION 
VALUE="PK">Pakistan</OPTION><OPTION VALUE="PA">Panama</OPTION><OPTION VALUE="NU">Papua New Guinea</OPTION><OPTION 
VALUE="PE">Peru</OPTION><OPTION VALUE="PH">Philippines</OPTION><OPTION VALUE="PL">Poland</OPTION><OPTION 
VALUE="PT">Portugal</OPTION><OPTION VALUE="PR">Puerto Rico</OPTION><OPTION VALUE="QA">Qatar</OPTION><OPTION 
VALUE="RI">Reunion Islands</OPTION><OPTION VALUE="RO">Romania</OPTION><OPTION VALUE="RU">Russian 
Federation</OPTION><OPTION VALUE="AS">Samoa (American)</OPTION><OPTION VALUE="WS">Samoa (Western)</OPTION><OPTION 
VALUE="SA">Saudi Arabia</OPTION><OPTION VALUE="SN">Senegal</OPTION><OPTION VALUE="SC">Seychelles</OPTION><OPTION 
VALUE="SG">Singapore</OPTION><OPTION VALUE="QV">Slovak Republic</OPTION><OPTION VALUE="QS">Slovenia</OPTION><OPTION 
VALUE="SI">Solomon Islands</OPTION><OPTION VALUE="ZA">South Africa</OPTION><OPTION VALUE="KP">South 
Korea</OPTION><OPTION VALUE="ES">Spain</OPTION><OPTION VALUE="LK">Sri Lanka</OPTION><OPTION VALUE="BY">St 
Barthelemy</OPTION><OPTION VALUE="LC">St Lucia</OPTION><OPTION VALUE="ZY">St Martin</OPTION><OPTION VALUE="VC">St 
Vincent</OPTION><OPTION VALUE="SR">Suriname</OPTION><OPTION VALUE="SZ">Swaziland</OPTION><OPTION 
VALUE="SE">Sweden</OPTION><OPTION VALUE="CH">Switzerland</OPTION><OPTION VALUE="TA">Tahiti (French 
Polynesia)</OPTION><OPTION VALUE="TZ">Tanzania</OPTION><OPTION VALUE="TH">Thailand</OPTION><OPTION VALUE="NL">The 
Netherlands</OPTION><OPTION VALUE="TG">Togo</OPTION><OPTION VALUE="TO">Tonga</OPTION><OPTION VALUE="TL">Tortola 
(British Virgin Isl)</OPTION><OPTION VALUE="TT">Trinidad & Tobago</OPTION><OPTION VALUE="TN">Tunisia</OPTION><OPTION 
VALUE="TR">Turkey</OPTION><OPTION VALUE="TC">Turks and Caicos</OPTION><OPTION VALUE="US" SELECTED >U S 
A</OPTION><OPTION VALUE="CX">US Virgin Islands (St Croix)</OPTION><OPTION VALUE="CV">US Virgin Islands (St 
Thomas)</OPTION><OPTION VALUE="UA">Ukraine</OPTION><OPTION VALUE="UE">United Arab Emirates</OPTION><OPTION 
VALUE="GB">United Kingdom</OPTION><OPTION VALUE="UY">Uruguay</OPTION><OPTION VALUE="NH">Vanuatu</OPTION><OPTION 
VALUE="VE">Venezuela</OPTION><OPTION VALUE="SK">West Indies (St Kitts, Nevis)</OPTION><OPTION VALUE="YU">Yugoslavia 
(Federation of)</OPTION><OPTION VALUE="ZB">Zambia</OPTION><OPTION VALUE="KF">Zimbabwe</OPTION></SELECT></TD></TR>
  </TR>
<TR>
	<TD width="35%"><INPUT TYPE=checkbox  NAME="RENTAL_ONEWAY"  VALUE="true">
 I plan to return the car to a different location.</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%">&nbsp;</TD>
  </TR>
  <tr>
		<td width="25%">&nbsp;</td>
		<td width="50%" valign=middle>&nbsp;</td>
		<td width="25%">&nbsp;</td>
	</tr>
	<tr>
		<td width="25%"><h3>Additional Information(optional)</h3></td>
		<td width="50%" valign=middle>&nbsp;</td>
		<td width="25%">&nbsp;</td>
	</tr> 
    <tr>
    	<td>
    	<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['flightandairline']) ? $_SESSION['page_errors_list']['flightandairline'] : ""; ?></p></div></td>
		<td width="25%">Arriving Airline:</td>
		<td width="50%" valign=middle>&nbsp;</td>
		<td width="25%">Flight No:</td>
	 </tr>
    <tr>
		<td width="25%"><SELECT NAME="AIRLINE_CODE" ><OPTION VALUE="" SELECTED >None</OPTION><OPTION VALUE="XX">-OTHER AIRLINES (NOT LISTED)</OPTION><OPTION VALUE="VX">ACES AIRLINES</OPTION><OPTION VALUE="EI">AER LINGUS</OPTION><OPTION VALUE="AR">AEROLINEAS ARGENTINAS</OPTION><OPTION VALUE="AM">AEROMEXICO</OPTION><OPTION VALUE="VH">AEROPOSTAL AIRLINES</OPTION><OPTION VALUE="AC">AIR CANADA</OPTION><OPTION VALUE="AF">AIR FRANCE</OPTION><OPTION VALUE="JM">AIR JAMAICA</OPTION><OPTION VALUE="LK">AIR LUXOR</OPTION><OPTION VALUE="KM">AIR MALTA</OPTION><OPTION VALUE="SW">AIR NAMIBIA</OPTION><OPTION VALUE="NZ">AIR NEW ZEALAND</OPTION><OPTION VALUE="FL">AIRTRAN AIRWAYS</OPTION><OPTION VALUE="AS">ALASKA AIRLINES</OPTION><OPTION VALUE="AZ">ALITALIA</OPTION><OPTION VALUE="NH">ALL NIPPON AIRWAYS</OPTION><OPTION VALUE="AQ">ALOHA AIRLINES</OPTION><OPTION VALUE="HP">AMERICA WEST AIRLINES</OPTION><OPTION VALUE="AA">AMERICAN AIRLINES</OPTION><OPTION VALUE="TZ">AMERICAN TRANS AIR</OPTION><OPTION VALUE="OS">AUSTRIAN AIRLINES</OPTION><OPTION VALUE="AV">AVIANCA AIRLINES</OPTION><OPTION VALUE="GU">AVIATECA AIRLINES</OPTION><OPTION VALUE="UP">BAHAMAS AIR</OPTION><OPTION VALUE="BA">BRITISH AIRWAYS</OPTION><OPTION VALUE="BE">BRITISH EUROPEAN</OPTION><OPTION VALUE="BD">BRITISH MIDLAND</OPTION><OPTION VALUE="CP">CANADIAN AIRLINES</OPTION><OPTION VALUE="C6">CANJET AIRLINES</OPTION><OPTION VALUE="CX">CATHAY PACIFIC AIRWAYS</OPTION><OPTION VALUE="KX">CAYMAN AIRWAYS</OPTION><OPTION VALUE="CI">CHINA AIRLINES</OPTION><OPTION VALUE="CO">CONTINENTAL AIRLINES</OPTION><OPTION VALUE="OK">CZECH AIRLINES</OPTION><OPTION VALUE="DL">DELTA AIR LINES</OPTION><OPTION VALUE="U2">EASYJET</OPTION><OPTION VALUE="LY">EL AL ISRAEL AIRLINES</OPTION><OPTION VALUE="EK">EMIRATES AIRLINE</OPTION><OPTION VALUE="BR">EVA AIRWAYS</OPTION><OPTION VALUE="AY">FINNAIR</OPTION><OPTION VALUE="ZU">FREEDOM AIR</OPTION><OPTION VALUE="F9">FRONTIER AIRLINES</OPTION><OPTION VALUE="GF">GULF AIR</OPTION><OPTION VALUE="HA">HAWAIIAN AIRLINES</OPTION><OPTION VALUE="QX">HORIZON AIR</OPTION><OPTION VALUE="IB">IBERIA</OPTION><OPTION VALUE="FI">ICELANDAIR</OPTION><OPTION VALUE="DH">INDEPENDENCE AIR</OPTION><OPTION VALUE="IM">INTENSIVE AIR</OPTION><OPTION VALUE="JL">JAPAN AIRLINES</OPTION><OPTION VALUE="B6">JET BLUE AIRWAYS</OPTION><OPTION VALUE="SG">JETSGO</OPTION><OPTION VALUE="JQ">JETSTAR</OPTION><OPTION VALUE="KD">KENDELL AIRLINES</OPTION><OPTION VALUE="KP">KIWI INTERNATIONAL AIR LINES</OPTION><OPTION VALUE="KL">KLM-ROYAL DUTCH AIRLINES</OPTION><OPTION VALUE="KE">KOREAN AIR</OPTION><OPTION VALUE="LR">LACSA AIRLINES</OPTION><OPTION VALUE="LA">LAN CHILE AIRLINES</OPTION><OPTION VALUE="NG">LAUDA AIR</OPTION><OPTION VALUE="LO">LOT POLISH AIRLINES</OPTION><OPTION VALUE="LH">LUFTHANSA GERMAN AIRLINES</OPTION><OPTION VALUE="MH">MALAYSIA AIRLINES</OPTION><OPTION VALUE="MA">MALEV HUNGARIAN AIRLINES</OPTION><OPTION VALUE="YV">MESA AIRLINES</OPTION><OPTION VALUE="MX">MEXICANA DE AVIACION</OPTION><OPTION VALUE="JI">MIDWAY AIRLINES</OPTION><OPTION VALUE="YX">MIDWEST AIRLINES</OPTION><OPTION VALUE="YJ">NATIONAL AIRWAYS</OPTION><OPTION VALUE="CE">NATIONWIDE</OPTION><OPTION VALUE="6Y">NICA AIRLINES</OPTION><OPTION VALUE="NW">NORTHWEST AIRLINES</OPTION><OPTION VALUE="OA">OLYMPIC AIRWAYS</OPTION><OPTION VALUE="PB">PROVINCIAL AIRLINES</OPTION><OPTION VALUE="QF">QANTAS AIRWAYS</OPTION><OPTION VALUE="QN">ROYAL AIRLINES</OPTION><OPTION VALUE="FR">RYANAIR</OPTION><OPTION VALUE="4Z">SA AIRLINK</OPTION><OPTION VALUE="EH">SAETA AIRLINES</OPTION><OPTION VALUE="SK">SAS-SCANDINAVIAN AIRLINE</OPTION><OPTION VALUE="SQ">SINGAPORE AIRLINES</OPTION><OPTION VALUE="SN">SN BRUSSELS AIRLINES</OPTION><OPTION VALUE="SA">SOUTH AFRICAN AIRWAYS</OPTION><OPTION VALUE="WN">SOUTHWEST AIRLINES</OPTION><OPTION VALUE="SP">SPANAIR</OPTION><OPTION VALUE="NK">SPIRIT AIRLINES</OPTION><OPTION VALUE="LX">SWISS INTERNATIONAL AIRLINES</OPTION><OPTION VALUE="TA">TACA AIRLINES</OPTION><OPTION VALUE="JJ">TAM AIRLINES</OPTION><OPTION VALUE="TP">TAP AIR PORTUGAL</OPTION><OPTION VALUE="TG">THAI AIRWAYS</OPTION><OPTION VALUE="FF">TOWER AIR</OPTION><OPTION VALUE="TK">TURKISH AIRLINES</OPTION><OPTION VALUE="UA">UNITED AIRLINES</OPTION><OPTION VALUE="US">US AIRWAYS</OPTION><OPTION VALUE="NJ">VANGUARD AIRLINES</OPTION><OPTION VALUE="RG">VARIG</OPTION><OPTION VALUE="VS">VIRGIN ATLANTIC AIRWAYS</OPTION><OPTION VALUE="DJ">VIRGIN BLUE</OPTION><OPTION VALUE="W7">WESTERN PACIFIC AIRLINES</OPTION><OPTION VALUE="WS">WESTJET AIRLINES</OPTION></SELECT></td>
		<td width="50%" valign=middle>&nbsp;</td>
		<td width="25%"><INPUT TYPE=text NAME="FLIGHT_NUMBER" VALUE="" SIZE=4  MAXLENGTH=4></td>
	 </tr>
	<tr>
		<td width="25%">&nbsp;</td>
		<td width="50%" valign=middle>&nbsp;</td>
		<td width="25%">&nbsp;</td>
	</tr>
</table>
</fieldset>
<!-- Rental Location Information Ends -->
<!-- Return Location Information Begins -->
<fieldset><legend><h3>Return Location Information(only needed if different from pickup location)</h3></legend>
<TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="0" BORDER="0">
   <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle><h2>-OR-</h2></td>
	<TD width="25%">&nbsp;</TD></TR>
  </TR>
 <TR>
 	<td>
 		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['returnLoc']) ? $_SESSION['page_errors_list']['returnLoc'] : ""; ?></p></div></td>
 	</td>
	<TD width="35%">AirportLocationCode:</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%">Street Address:</TD></TR>
  </TR>
   <TR>
	<TD width="35%"><INPUT TYPE=text NAME="RETURN_LOCATION_CODE" SIZE=3  MAXLENGTH=3>(if known)</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<td>
 		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['retStreet']) ? $_SESSION['page_errors_list']['retStreet'] : ""; ?></p></div></td>
	<TD width="25%"><INPUT TYPE=text NAME="RETURN_STREET_ADDRESS" SIZE=8  MAXLENGTH=30></TD></TR>
  </TR>
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%">City/Town:</TD></TR>
  </TR>
   <TR>
   	<td>
 		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['retCity']) ? $_SESSION['page_errors_list']['retCity'] : ""; ?></p></div></td>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%"><INPUT TYPE=text NAME="RETURN_CITY_NAME" SIZE=8  MAXLENGTH=30></TD></TR>
  </TR>
 
  <TR>
  	<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['retState']) ? $_SESSION['page_errors_list']['retState'] : ""; ?></p></div></td>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%">State/Province:</TD></TR>
  </TR>
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%"><SELECT NAME="RETURN_STATE"  width=165><OPTION VALUE="">Please Select One</OPTION><OPTION VALUE="Not Applicable">Not Applicable</OPTION><OPTION VALUE="Alabama">Alabama</OPTION><OPTION VALUE="Alaska">Alaska</OPTION><OPTION VALUE="Arizona">Arizona</OPTION><OPTION VALUE="Arkansas">Arkansas</OPTION><OPTION VALUE="California">California</OPTION><OPTION VALUE="Colorado">Colorado</OPTION><OPTION VALUE="Connecticut">Connecticut</OPTION><OPTION VALUE="Delaware">Delaware</OPTION><OPTION VALUE="District of Columbia">District of Columbia</OPTION><OPTION VALUE="Florida">Florida</OPTION><OPTION VALUE="Georgia">Georgia</OPTION><OPTION VALUE="Hawaii">Hawaii</OPTION><OPTION VALUE="Idaho">Idaho</OPTION><OPTION VALUE="Illinois">Illinois</OPTION><OPTION VALUE="Indiana">Indiana</OPTION><OPTION VALUE="Iowa">Iowa</OPTION><OPTION VALUE="Kansas">Kansas</OPTION><OPTION VALUE="Kentucky">Kentucky</OPTION><OPTION VALUE="Louisiana">Louisiana</OPTION><OPTION VALUE="Maine">Maine</OPTION><OPTION VALUE="Maryland">Maryland</OPTION><OPTION VALUE="Massachusetts">Massachusetts</OPTION><OPTION VALUE="Michigan">Michigan</OPTION><OPTION VALUE="Minnesota">Minnesota</OPTION><OPTION VALUE="Mississippi">Mississippi</OPTION><OPTION VALUE="Missouri">Missouri</OPTION><OPTION VALUE="Montana">Montana</OPTION><OPTION VALUE="Nebraska">Nebraska</OPTION><OPTION VALUE="Nevada">Nevada</OPTION><OPTION VALUE="New Hampshire">New Hampshire</OPTION><OPTION VALUE="New Jersey">New Jersey</OPTION><OPTION VALUE="New Mexico">New Mexico</OPTION><OPTION VALUE="New York">New York</OPTION><OPTION VALUE="North Carolina">North Carolina</OPTION><OPTION VALUE="North Dakota">North Dakota</OPTION><OPTION VALUE="Ohio">Ohio</OPTION><OPTION VALUE="Oklahoma">Oklahoma</OPTION><OPTION VALUE="Oregon">Oregon</OPTION><OPTION VALUE="Pennsylvania">Pennsylvania</OPTION><OPTION VALUE="Rhode Island">Rhode Island</OPTION><OPTION VALUE="South Carolina">South Carolina</OPTION><OPTION VALUE="South Dakota">South Dakota</OPTION><OPTION VALUE="Tennessee">Tennessee</OPTION><OPTION VALUE="Texas">Texas</OPTION><OPTION VALUE="Utah">Utah</OPTION><OPTION VALUE="Vermont">Vermont</OPTION><OPTION VALUE="Virginia">Virginia</OPTION><OPTION VALUE="Washington">Washington</OPTION><OPTION VALUE="West Virginia">West Virginia</OPTION><OPTION VALUE="Wisconsin">Wisconsin</OPTION><OPTION VALUE="Wyoming">Wyoming</OPTION</SELECT></TD></TR>
  </TR>
  <TR>
  	<td>
 		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['retCountry']) ? $_SESSION['page_errors_list']['retCountry'] : ""; ?></p></div></td>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%">Country:</TD></TR>
  </TR>
  <TR>
	<TD width="35%">&nbsp;</TD>
	<td width="40%" valign=middle>&nbsp;</td>
	<TD width="25%"><SELECT NAME="RETURN_COUNTRY_CODE" ><OPTION VALUE="AL">Albania</OPTION><OPTION VALUE="AD">Andorra</OPTION><OPTION 
VALUE="AO">Angola</OPTION><OPTION VALUE="AI">Anguilla</OPTION><OPTION VALUE="AG">Antigua</OPTION><OPTION 
VALUE="AR">Argentina</OPTION><OPTION VALUE="AB">Aruba</OPTION><OPTION VALUE="AU">Australia</OPTION><OPTION 
VALUE="AT">Austria</OPTION><OPTION VALUE="AZ">Azerbaijan</OPTION><OPTION VALUE="BS">Bahamas</OPTION><OPTION 
VALUE="BH">Bahrain</OPTION><OPTION VALUE="BA">Belarus</OPTION><OPTION VALUE="BE">Belgium</OPTION><OPTION 
VALUE="BZ">Belize</OPTION><OPTION VALUE="BP">Benin (Peoples Republic of)</OPTION><OPTION 
VALUE="YE">Bonaire</OPTION><OPTION VALUE="QB">Bosnia</OPTION><OPTION VALUE="BW">Botswana</OPTION><OPTION 
VALUE="BR">Brazil</OPTION><OPTION VALUE="BN">Brunei</OPTION><OPTION VALUE="BG">Bulgaria</OPTION><OPTION 
VALUE="UV">Burkina Faso</OPTION><OPTION VALUE="CM">Cameroon</OPTION><OPTION VALUE="CA">Canada</OPTION><OPTION 
VALUE="CB">Cape Verdi Is.</OPTION><OPTION VALUE="CF">Central African Republic</OPTION><OPTION 
VALUE="CD">Chad</OPTION><OPTION VALUE="CL">Chile</OPTION><OPTION VALUE="CN">China</OPTION><OPTION 
VALUE="CJ">Comores</OPTION><OPTION VALUE="ZM">Congo (Dem. Rep. of the)</OPTION><OPTION VALUE="CK">Cook Islands 
(Rarotonga)</OPTION><OPTION VALUE="CR">Costa Rica</OPTION><OPTION VALUE="HR">Croatia</OPTION><OPTION 
VALUE="AN">Curacao (Netherland Antilles)</OPTION><OPTION VALUE="CY">Cyprus</OPTION><OPTION VALUE="CS">Czech 
Republic</OPTION><OPTION VALUE="DK">Denmark</OPTION><OPTION VALUE="DO">Dominican Republic</OPTION><OPTION 
VALUE="EC">Ecuador</OPTION><OPTION VALUE="EG">Egypt</OPTION><OPTION VALUE="EL">El Salvador</OPTION><OPTION 
VALUE="EQ">Equatorial Guinea</OPTION><OPTION VALUE="EE">Estonia</OPTION><OPTION VALUE="ET">Ethiopia</OPTION><OPTION 
VALUE="FO">Faroe Islands</OPTION><OPTION VALUE="FJ">Fiji Islands</OPTION><OPTION VALUE="FI">Finland</OPTION><OPTION 
VALUE="FR">France</OPTION><OPTION VALUE="FG">French Guiana</OPTION><OPTION VALUE="GA">Gabon</OPTION><OPTION 
VALUE="GE">Georgia</OPTION><OPTION VALUE="DE">Germany</OPTION><OPTION VALUE="GH">Ghana</OPTION><OPTION 
VALUE="GI">Gibraltar</OPTION><OPTION VALUE="CT">Grand Cayman</OPTION><OPTION VALUE="GR">Greece</OPTION><OPTION 
VALUE="GD">Grenada</OPTION><OPTION VALUE="GP">Guadeloupe(French West Indies)</OPTION><OPTION 
VALUE="GU">Guam</OPTION><OPTION VALUE="GT">Guatemala</OPTION><OPTION VALUE="GN">Guinea</OPTION><OPTION 
VALUE="HT">Haiti</OPTION><OPTION VALUE="HD">Honduras</OPTION><OPTION VALUE="HK">Hong Kong</OPTION><OPTION 
VALUE="HU">Hungary</OPTION><OPTION VALUE="IS">Iceland</OPTION><OPTION VALUE="IN">India</OPTION><OPTION 
VALUE="ID">Indonesia</OPTION><OPTION VALUE="IE">Ireland (Republic)</OPTION><OPTION VALUE="IL">Israel</OPTION><OPTION 
VALUE="IT">Italy</OPTION><OPTION VALUE="CI">Ivory Coast</OPTION><OPTION VALUE="JM">Jamaica</OPTION><OPTION 
VALUE="JO">Jordan</OPTION><OPTION VALUE="KZ">Kazakhstan</OPTION><OPTION VALUE="KE">Kenya</OPTION><OPTION 
VALUE="KW">Kuwait</OPTION><OPTION VALUE="LV">Latvia</OPTION><OPTION VALUE="LB">Lebanon</OPTION><OPTION 
VALUE="LS">Lesotho</OPTION><OPTION VALUE="LT">Lithuania</OPTION><OPTION VALUE="LU">Luxembourg</OPTION><OPTION 
VALUE="MK">Macau</OPTION><OPTION VALUE="QM">Macedonia (Fyrom)</OPTION><OPTION VALUE="MG">Madagascar</OPTION><OPTION 
VALUE="MW">Malawi</OPTION><OPTION VALUE="MY">Malaysia</OPTION><OPTION VALUE="ML">Mali</OPTION><OPTION 
VALUE="MT">Malta</OPTION><OPTION VALUE="MQ">Martinique</OPTION><OPTION VALUE="MU">Mauritius</OPTION><OPTION 
VALUE="MX">Mexico</OPTION><OPTION VALUE="MD">Moldova</OPTION><OPTION VALUE="MA">Morocco</OPTION><OPTION 
VALUE="MZ">Mozambique</OPTION><OPTION VALUE="SW">Namibia (South West Africa)</OPTION><OPTION VALUE="NC">New 
Caledonia</OPTION><OPTION VALUE="NZ">New Zealand</OPTION><OPTION VALUE="NI">Nicaragua</OPTION><OPTION 
VALUE="NG">Nigeria</OPTION><OPTION VALUE="NO">Norway</OPTION><OPTION VALUE="OM">Oman (Sultanate of)</OPTION><OPTION 
VALUE="PK">Pakistan</OPTION><OPTION VALUE="PA">Panama</OPTION><OPTION VALUE="NU">Papua New Guinea</OPTION><OPTION 
VALUE="PE">Peru</OPTION><OPTION VALUE="PH">Philippines</OPTION><OPTION VALUE="PL">Poland</OPTION><OPTION 
VALUE="PT">Portugal</OPTION><OPTION VALUE="PR">Puerto Rico</OPTION><OPTION VALUE="QA">Qatar</OPTION><OPTION 
VALUE="RI">Reunion Islands</OPTION><OPTION VALUE="RO">Romania</OPTION><OPTION VALUE="RU">Russian 
Federation</OPTION><OPTION VALUE="AS">Samoa (American)</OPTION><OPTION VALUE="WS">Samoa (Western)</OPTION><OPTION 
VALUE="SA">Saudi Arabia</OPTION><OPTION VALUE="SN">Senegal</OPTION><OPTION VALUE="SC">Seychelles</OPTION><OPTION 
VALUE="SG">Singapore</OPTION><OPTION VALUE="QV">Slovak Republic</OPTION><OPTION VALUE="QS">Slovenia</OPTION><OPTION 
VALUE="SI">Solomon Islands</OPTION><OPTION VALUE="ZA">South Africa</OPTION><OPTION VALUE="KP">South 
Korea</OPTION><OPTION VALUE="ES">Spain</OPTION><OPTION VALUE="LK">Sri Lanka</OPTION><OPTION VALUE="BY">St 
Barthelemy</OPTION><OPTION VALUE="LC">St Lucia</OPTION><OPTION VALUE="ZY">St Martin</OPTION><OPTION VALUE="VC">St 
Vincent</OPTION><OPTION VALUE="SR">Suriname</OPTION><OPTION VALUE="SZ">Swaziland</OPTION><OPTION 
VALUE="SE">Sweden</OPTION><OPTION VALUE="CH">Switzerland</OPTION><OPTION VALUE="TA">Tahiti (French 
Polynesia)</OPTION><OPTION VALUE="TZ">Tanzania</OPTION><OPTION VALUE="TH">Thailand</OPTION><OPTION VALUE="NL">The 
Netherlands</OPTION><OPTION VALUE="TG">Togo</OPTION><OPTION VALUE="TO">Tonga</OPTION><OPTION VALUE="TL">Tortola 
(British Virgin Isl)</OPTION><OPTION VALUE="TT">Trinidad & Tobago</OPTION><OPTION VALUE="TN">Tunisia</OPTION><OPTION 
VALUE="TR">Turkey</OPTION><OPTION VALUE="TC">Turks and Caicos</OPTION><OPTION VALUE="US" SELECTED >U S 
A</OPTION><OPTION VALUE="CX">US Virgin Islands (St Croix)</OPTION><OPTION VALUE="CV">US Virgin Islands (St 
Thomas)</OPTION><OPTION VALUE="UA">Ukraine</OPTION><OPTION VALUE="UE">United Arab Emirates</OPTION><OPTION 
VALUE="GB">United Kingdom</OPTION><OPTION VALUE="UY">Uruguay</OPTION><OPTION VALUE="NH">Vanuatu</OPTION><OPTION 
VALUE="VE">Venezuela</OPTION><OPTION VALUE="SK">West Indies (St Kitts, Nevis)</OPTION><OPTION VALUE="YU">Yugoslavia 
(Federation of)</OPTION><OPTION VALUE="ZB">Zambia</OPTION><OPTION VALUE="KF">Zimbabwe</OPTION></SELECT></TD></TR>
  </TR>
	<tr>
		<td width="25%">&nbsp;</td>
		<td width="50%" valign=middle>&nbsp;</td>
		<td width="25%">&nbsp;</td>
	</tr>
</table>
</fieldset>
<!-- Return Location Information Ends -->

 
<!-- Rates & Discounts Begins -->
<fieldset><legend><h3>Rates & Discounts</h3></legend>
<TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="0" BORDER="0">
	<tr>
		<td>To ensure that you receive the best and most accurate rate, please fill out as much of the following information as possible.</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><h4>Discount Code(optional)</h4></td>
	</tr>
	<tr>
		<td>Worldwide Discount:</td>
	</tr>
	<tr>
		<td><INPUT TYPE=text NAME="RATE_CODE" SIZE=7  MAXLENGTH=4></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><h4>Optional Equipment (child Seats:)</h4></td>
	</tr>
	<tr>
		<td>
 		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['infant']) ? $_SESSION['page_errors_list']['infant'] : ""; ?></p></div></td>
		<td><INPUT TYPE=checkbox  NAME="CHILD_INFANT_SEAT"  VALUE="true"> Infant Seats  
		<SELECT NAME="CHILD_INFANT_SEAT_QUANTITY" ><OPTION VALUE="">Quantity</OPTION><OPTION VALUE="1">1</OPTION><OPTION VALUE="2">2</OPTION><OPTION VALUE="3">3</OPTION></SELECT></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>	<tr>
		<td>
		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['safety']) ? $_SESSION['page_errors_list']['safety'] : ""; ?></p></div></td>
		<td><INPUT TYPE=checkbox  NAME="CHILD_SAFETY_SEAT"  VALUE="true"> Safety Seats  
		<SELECT NAME="CHILD_SAFETY_SEAT_QUANTITY" ><OPTION VALUE="">Quantity</OPTION><OPTION VALUE="1">1</OPTION><OPTION VALUE="2">2</OPTION><OPTION VALUE="3">3</OPTION></SELECT></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>	<tr>
		<td>
		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['booster']) ? $_SESSION['page_errors_list']['booster'] : ""; ?></p></div></td>
		<td><INPUT TYPE=checkbox  NAME="CHILD_BOOSTER_SEAT"  VALUE="true"> Booster Seats 
		<SELECT NAME="CHILD_BOOSTER_SEAT_QUANTITY" ><OPTION VALUE="">Quantity</OPTION><OPTION VALUE="1">1</OPTION><OPTION VALUE="2">2</OPTION><OPTION VALUE="3">3</OPTION></SELECT></td>
	</tr>
</TABLE>
</fieldset>
<!-- Rates & Discounts Ends -->

<!-- Car Selection Begins -->
<fieldset><legend><h3>Car Selection</h3></legend>

<TABLE WIDTH="50%" CELLSPACING="0" CELLPADDING="0" BORDER="0">
		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['type']) ? $_SESSION['page_errors_list']['type'] : ""; ?></p></div>
	<tr>
		<td width="25%">&nbsp;</td>
		<td width="50%" valign=middle><b>Car Class</b></td>
		<td width="25%"><b>Base Rate</b></td>
	</tr>
	<tr>
		<td width="25%"><INPUT TYPE=radio  NAME="CAR_GROUP_CODE"  VALUE="subcompact"></td>
		<td width="50%" valign=middle>Subcompact</td>
		<td width="25%">51.99USD</td>
	</tr>
	<tr>
		<td width="25%"><INPUT TYPE=radio  NAME="CAR_GROUP_CODE"  VALUE="compact"></td>
		<td width="50%" valign=middle>Compact</td>
		<td width="25%">53.99USD</td>
	</tr>
	<tr>
		<td width="25%"><INPUT TYPE=radio  NAME="CAR_GROUP_CODE"  VALUE="intermediate"></td>
		<td width="50%" valign=middle>Intermediate</td>
		<td width="25%">56.99USD</td>
	</tr>
	<tr>
		<td width="25%"><INPUT TYPE=radio  NAME="CAR_GROUP_CODE"  VALUE="standardsize"></td>
		<td width="50%" valign=middle>Standard Size</td>
		<td width="25%">61.99USD</td>
	</tr>
	<tr>
		<td width="25%"><INPUT TYPE=radio  NAME="CAR_GROUP_CODE"  VALUE="fullsize"></td>
		<td width="50%" valign=middle>Full Size</td>
		<td width="25%">63.99USD</td>
	</tr>
</TABLE>
</fieldset>
<!-- Car Selection Ends -->

<!-- Optional Coverages Begins -->
<fieldset><legend><h3>Optional Coverages(optional)</h3></legend>
<TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="0" BORDER="0">
	<tr>
		<td>Optional coverages are subject to tax in certain locations.
		This tax is not reflected in the Estimated Total.</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><INPUT TYPE=checkbox  NAME="CDW_ACCEPT"  VALUE="true"> Loss Damage Waiver ( 22.99 USD per day )</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>	
	<tr>
		<td><INPUT TYPE=checkbox  NAME="PAI_ACCEPT"  VALUE="true"> Personal Accident insurance ( 22.99 USD per day )</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>	
	<tr>
		<td><INPUT TYPE=checkbox  NAME="ALI_ACCEPT"  VALUE="true"> Additional Liability Insurance ( 11.99 USD per day )</td>
	</tr>
</TABLE>
</fieldset>
<!-- Optional Coverages Ends -->

<!-- Personal Information Begins -->
<fieldset><legend><h3>Personal Information</h3></legend>
<TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="0" BORDER="0">
	<tr>
		<td>Please enter the information requested below, and then click on "Make Reservation" to complete the reservation process. Your email address is required in order to send an email confirmation.You don't need to provide the credit card information to do your Rental Car Reservation.</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['fname']) ? $_SESSION['page_errors_list']['fname'] : ""; ?></p></div></td>
		<td>First Name: <INPUT TYPE=text NAME="FIRST_NAME" SIZE=20  MAXLENGTH=12></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>	
	<tr>
		<td>
		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['lname']) ? $_SESSION['page_errors_list']['lname'] : ""; ?></p></div></td>
		<td>Last Name: <INPUT TYPE=text NAME="LAST_NAME" SIZE=20  MAXLENGTH=12></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>	
	<tr>
		<td>
		<div><p style="color: red"><?php echo isset($_SESSION['page_errors_list']['email']) ? $_SESSION['page_errors_list']['email'] : ""; ?></p></div></td>
		<td>Email Address:<INPUT TYPE=text NAME="EMAIL_ADDRESS" SIZE=20  MAXLENGTH=12></td>
	</tr>
</TABLE>
</fieldset>
<!-- Personal Information Ends -->
<TABLE WIDTH="100%" CELLSPACING="0" CELLPADDING="0" BORDER="0">
	<tr>
		<td>&nbsp;</td>
	</tr>	
	<tr>
		<td align = "center"><INPUT TYPE=submit NAME="submit" id="test"  value="Submit this Information"SIZE=20  MAXLENGTH=12></td>
	</tr>
</TABLE>
<?php unset($_SESSION['page_errors_list']); ?>
<?php unset($_SESSION['page_success-list']); ?>

</td>
</tr>
</table>
</BODY>
</FORM>
</HTML>