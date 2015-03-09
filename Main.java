import java.io.IOException;

/**
 * Created by ncbrown on 3/8/15.
 */
public class Main {
    public static void main(String[] cheese) {
        // make sure all the proper tables/data are up-to-date
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("mysql -u root < Creates.sql");
            rt.exec("mysql -u root < HealthMessagesExchange.sql");
            rt.exec("mysql -u root < HealthMessagesExchange3.sql");
        } catch (IOException e) {
            System.out.println("Could not properly import data");
            e.printStackTrace();
        }
        // Extract the data
        Extractor ext = new Extractor();
        ext.run();
    }
}
