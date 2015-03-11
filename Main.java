import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by ncbrown on 3/8/15.
 */
public class Main {
    public static void main(String[] cheese) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to reset the databases? (WARNING: THIS DELETES EVERYTHING)");
        System.out.print("(y/n) >> ");
        String reset = scan.next();
        if(reset.equalsIgnoreCase("y")) {
            // make sure all the proper tables/data are up-to-date
            Runtime rt = Runtime.getRuntime();
            System.out.println("Importing data from message exchanges...");
            try {
                rt.exec("mysql -u root < SQLscript.sql");
            } catch (IOException e) {
                System.out.println("Could not properly import data");
                e.printStackTrace();
            }
            System.out.println("Message exchange data imported.");
            // Extract the data
            Extractor ext = new Extractor();
            try {
                System.out.println("Extracting data from 'healthmessagesexchange2-messages' into system...");
                ext.run("healthmessagesexchange2", "messages");
                System.out.println("Done!");
                System.out.println("Extracting data from 'healthmessagesexchange3-messages' into system...");
                ext.run("healthmessagesexchange3", "messages");
                System.out.println("Done!");
                System.out.println("Extracting data from 'healthmessagesexchange3-messages2' into system...");
                ext.run("healthmessagesexchange3", "messages2");
                System.out.println("Done!");
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            System.out.println("\nDatabases have been reset.\n");
        }


        System.out.println("What type of user are you? (Select a number)\n1. Patient\n2. Doctor/Author\n3. Administrator\n4. None; Quit");
        System.out.print(">> ");
        int choice = scan.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Hello, patient!");
                PatientInterface.main(cheese);
                break;
            case 2:
                System.out.println("Hello, doctor/patient!");
                DoctorInterface.main(cheese);
                break;
            case 3:
                System.out.println("Hello, administrator!");
                AdministratorInterface.main(cheese);
                break;
            default:
                System.out.println("You do not have the proper access to this system... Exiting...");
                break;
        }
        System.out.println("\n...Goodbye!");
    }
}
