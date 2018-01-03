/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

/**
 *
 * @author Rohit
 */
import Business.Country.Country;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TicketWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class Loader {

    private EcoSystem system;
    private UserAccount ua;
    private String[] subject = {"Forest Fire detected", "Contamination of water detected", "Low oxygen in water body detected", "Sudden rise in temperature detected", "Air contamination detected", "Soil contamination detected", "High carbon dioxide in water body detected"};
    private String[] ticketPriority = {"High", "Medium", "Low"};

    public Loader(EcoSystem system) {
        this.system = system;
        ua = new UserAccount();
        ua.setEmailID("wildlifemanagementsystem@gmail.com");
        ua.setUsername("Auto-Generated");
    }

    /**
     * Creates an Example SwingWorker
     */
    public SwingWorker createWorker() {
        return new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // Start Progress
                setProgress(0);
                waitFor(500);

                for (int iCount = 1; iCount <= 100; iCount++) {

                //    if (iCount % 2 == 0) {
                        TicketWorkRequest request = new TicketWorkRequest();

                        request.setMessage("System Generated.");
                        request.setSender(ua);
                        request.setStatus("Open");
                        request.setSubject(subject[getRandomValue(subject.length)]);
                        request.setTicketPriority(ticketPriority[getRandomValue(ticketPriority.length)]);

                        //  ArrayList<Country> countryList =  system.getContinentList().get(getRandomValue(system.getContinentList().size())).getCountryDirectory().getCountryList();
                        ArrayList<Country> countryList = new ArrayList<>();
//      ArrayList<Enterprise> enterpriseList   =  countryList.get(getRandomValue(countryList.size())).getEnterpriseDirectory().getEnterpriseList();
                        ArrayList<Enterprise> enterpriseList = new ArrayList<>();
//  ArrayList<Organization> organizationList =  enterpriseList.get(getRandomValue(enterpriseList.size())).getOrganizationDirectory().getOrganizationList();
                        ArrayList<Organization> organizationList = new ArrayList<>();
                        while (organizationList.isEmpty()) {
                            try {
                                countryList = system.getContinentList().get(getRandomValue(system.getContinentList().size())).getCountryDirectory().getCountryList();
                                enterpriseList = countryList.get(getRandomValue(countryList.size())).getEnterpriseDirectory().getEnterpriseList();
                                organizationList = enterpriseList.get(getRandomValue(enterpriseList.size())).getOrganizationDirectory().getOrganizationList();
                                //organizationList =  system.getContinentList().get(getRandomValue(system.getContinentList().size())).getCountryDirectory().getCountryList().get(getRandomValue(countryList.size())).getEnterpriseDirectory().getEnterpriseList().get(getRandomValue(enterpriseList.size())).getOrganizationDirectory().getOrganizationList();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                        }
                        organizationList.get(getRandomValue(organizationList.size())).getWorkQueue().getWorkRequestList().add(request);
                        publish(iCount);
                   // }

                    // Set Progress
                    setProgress(iCount);
                    System.out.println("Progress "+iCount);
                    waitFor(20000);
                }

                // Finished
                return true;
            }

            @Override
            protected void process(List<Integer> chunks) {
                // Get Info
                for (int number : chunks) {
                    System.out.println(number);
                }
            }

            @Override
            protected void done() {
                boolean bStatus = false;
                try {
                    bStatus = get();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Finished with status " + bStatus);
            }
        };
    } // End of Method: createWorker()

    /**
     * Wait the given time in milliseconds
     *
     * @param iMillis
     */
    private void waitFor(int iMillis) {
        try {
            Thread.sleep(iMillis);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    } // End of Method: waitFor()

    public static void main(String[] args) {
//        // Create the worker
//        Loader l = new Loader();
//        SwingWorker work = l.createWorker();
//        work.execute();
//
//        // Wait for it to finish
//        while (!work.isDone()) {
//            // Show Progress
//            try {
//                int iProgress = work.getProgress();
//                System.out.println("Progress %" + iProgress);
//                Thread.sleep(500);
//            }
//            catch (Exception ex) {
//                System.err.println(ex);
//            }
//        } // End of Loop: while (!work.isDone())
    } // End of: main()

    private int getRandomValue(int n) {
        Random rand = new Random();

        return rand.nextInt(n);
    }

} // End of Class definition
