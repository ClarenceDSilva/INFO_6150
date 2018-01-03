package Business;

import Business.Continent.Continent;
import Business.Country.Country;
import Business.Country.CountryList;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.StateEnterprise;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.GovernmentAdminRole;
import Business.Role.SystemAdminRole;
import Business.State.State;
import javax.mail.Message;
import Business.UserAccount.UserAccount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Rohit
 */
public class ConfigureASystem {

    public static EcoSystem configure() {
     String[] name = {"Rohit", "Aditya", "Clarence", "Ravi", "Mithun", "Shahrukh", "Kamlesh"};
   

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        Employee employee = system.getEmployeeDirectory().createEmployee("SYSTEM",null);

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("a", "a","wildlifemanagementsystem@gmail.com","6173043697","Sprint", employee, new SystemAdminRole(),system);

        Continent asia = system.createAndAddContinent();
        asia.setName("Asia");
        CountryList asiaList = new CountryList();
        Country c1 = asiaList.addcountry();
        c1.setCountryName("India");
        asia.setCountryDirectory(asiaList);
        String line = "";
        String separated = ",";
        String fileName = "MockData/MockData-Forest.csv";
        int count=1;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(separated);
                if (data[0].equalsIgnoreCase("Continent")) {
                    continue;
                }
                if (data[0].equalsIgnoreCase("Asia")) {
                    if (data[1].equalsIgnoreCase("India")) {
                        Enterprise s1 = c1.getEnterpriseDirectory().createAndAddEnterprise(data[2]);  
                        
                                            
                       String Uname1;
                        Uname1 = name[getRandomValue(name.length)];
                         Employee e2 = s1.getEmployeeDirectory().createEmployee("SYSTEM",null);  
                      // e2.setName("SYSTEM");
                       s1.getUserAccountDirectory().createUserAccount(Uname1, "a","wildlifemanagementsystem@gmail.com","6173043697","Sprint", e2, new AdminRole(),system);

                        
                         Organization o = s1.getOrganizationDirectory().createOrganization(Organization.Type.Government);
                       o.setName("ORGNO "+(count++));
                       o.setOrganizationType("Government Organization");
                       o.setEnterprise(s1);
                      
                       String Uname;
                        Uname = name[getRandomValue(name.length)];
                         Employee e = o.getEmployeeDirectory().createEmployee("SYSTEM", o);
                      // e.setEmpOrganization(o);
                      // e.setName("SYSTEM");
                       o.getUserAccountDirectory().createUserAccount(Uname, "a","wildlifemanagementsystem@gmail.com","6173043697","Sprint", e, new GovernmentAdminRole(),system);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CountryList NAList = new CountryList();
        Continent nAmerica = system.createAndAddContinent();
        nAmerica.setName("North America");
        Country c2 = NAList.addcountry();
        c2.setCountryName("USA");
        nAmerica.setCountryDirectory(NAList);
        line = "";
        separated = ",";
        fileName = "MockData/MockData-Forest.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(separated);
                if (data[0].equalsIgnoreCase("Continent")) {
                    continue;
                }
                if (data[0].equalsIgnoreCase("North America")) {
                    if (data[1].equalsIgnoreCase("USA")) {
                        Enterprise s2 = c2.getEnterpriseDirectory().createAndAddEnterprise(data[2]);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CountryList africaList = new CountryList();
        Continent africa = system.createAndAddContinent();
        africa.setName("Africa");
        Country c3 = africaList.addcountry();
        c3.setCountryName("Uganda");
        africa.setCountryDirectory(africaList);
        Enterprise s3 = c3.getEnterpriseDirectory().createAndAddEnterprise("UG");
        // s3.setStatename("UG");

        return system;
    }
public static int getRandomValue(int n) {
        Random rand = new Random();

        return rand.nextInt(n);
    }
    
    public void sendEmail(String receiver,String carrier,String subject, String msg)
    {
        System.out.println("Business.ConfigureASystem.sendEmail()");
        if(!carrier.equalsIgnoreCase(""))
        {
            if(carrier.equalsIgnoreCase("Sprint"))
            {
            receiver = receiver+"@pm.sprint.com";
            }
            if(carrier.equalsIgnoreCase("TMobile"))
            {
              receiver = receiver+"@tmomail.net";  
            }
             if(carrier.equalsIgnoreCase("Verizon"))
            {
              receiver = receiver+"@vtext.com";  
            }
              if(carrier.equalsIgnoreCase("AT&T"))
            {
              receiver = receiver+"@txt.att.net";  
            }
                         
        }
         System.out.println(receiver);
            //GEN-FIRST:event_btnSendActionPerformed
       // SMTP for Gmail: smtp.gmail.com; SMTP for Yahoo: smtp.mail.yahoo.com
       //String mailId = "wildlifemanagementsystem@gmail.com";
      // String password = "wildlife123";
       String mailId = "wildlifemanagementsystem@gmail.com";
       String password = "wildlife123";
       Properties prop = new Properties(); /*
      prop.setProperty("mail.transport.protocol", "smtp"); 
      prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "465");
               */
       prop.setProperty("mail.transport.protocol", "smtp");
       prop.put("mail.smtp.host", "smtp.gmail.com");
       prop.put("mail.smtp.socketFactory.port", "587");       
       prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
       prop.put("mail.smtp.starttls.enable", "true");
       prop.put("mail.smtp.auth", "true");
      // prop.put("mail.smtp.ssl.trust", "true");
       
       Session session = Session.getInstance(prop,
               new javax.mail.Authenticator() {
                   protected PasswordAuthentication getPassowordAuthentication(){
                       
                       if ((mailId != null) && (mailId.length() > 0) && (password != null) && (password.length() > 0)) {
                       return new PasswordAuthentication(mailId, password);
                       }
                       return null;
                   }
               }   
               );
       try{
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(mailId));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
           //message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("naik.roh@husky.neu.edu"));
           message.setSubject(subject);
           message.setText(msg);
           
           Transport transport = session.getTransport("smtp");
           transport.connect("smtp.gmail.com", mailId, password);
             if(!carrier.equalsIgnoreCase("Other"))
            {
              transport.sendMessage(message, message.getAllRecipients());
            }
                     transport.close();
           //JOptionPane.showMessageDialog(null, "Your message has been sent successfully!");
           System.out.println("Business.ConfigureASystem.sendEmail() 2");
       }catch(Exception e){
           //e.printStackTrace();
           JOptionPane.showMessageDialog(null, e);
       }
    
    }   
      
}
