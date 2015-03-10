import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by ncbrown on 3/8/15.
 */
public class Main {
    public static void main(String[] cheese) {
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
    }
}
