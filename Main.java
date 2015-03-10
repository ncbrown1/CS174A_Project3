import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by ncbrown on 3/8/15.
 */
public class Main {
    public static void main(String[] cheese) {
        // make sure all the proper tables/data are up-to-date
//        Runtime rt = Runtime.getRuntime();
//        try {
//            rt.exec("mysql -u root < Creates.sql");
//            rt.exec("mysql -u root < HealthMessagesExchange.sql");
//            rt.exec("mysql -u root < HealthMessagesExchange3.sql");
//        } catch (IOException e) {
//            System.out.println("Could not properly import data");
//            e.printStackTrace();
//        }
//        // Extract the data
//        Extractor ext = new Extractor();
//        ext.run();

//        System.out.println(new Date(new java.util.Date().getTime()));
//        String x = "2015-02-15";
//        String[] xs = x.split("-");
//        for(String n : xs) System.out.println(n);
//        Calendar c = Calendar.getInstance();
//        c.set(new Integer(xs[0]), new Integer(xs[1]), new Integer(xs[2]));
//        System.out.println(new Date(c.getTime().getTime()));

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH); // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);

        System.out.printf("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month + 1, day, hour, minute, second, millis);

        String datetime = "2/15/2015 12:00:00AM";
        String[] d_and_t = datetime.split(" ");
        String date = d_and_t[0];
        String[] xs = date.split("/");
        for(String n : xs) System.out.println(n);
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.set(new Integer(xs[2]), new Integer(xs[0])-1, new Integer(xs[1]));
        System.out.println("A: " + new java.sql.Date(c.getTime().getTime()));
    }
}
