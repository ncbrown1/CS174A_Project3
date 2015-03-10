/**
 * Created by ncbrown on 3/9/15.
 */
public class Str2Date {
    public static java.sql.Date convert(String datetime) {
        if(datetime == "" || datetime == null) return null;
        String[] d_and_t = datetime.split(" ");
        String date = d_and_t[0];
        String[] xs = date.split("/");
//        for(String n : xs) System.out.println(n);
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.set(new Integer(xs[2]), new Integer(xs[0])-1, new Integer(xs[1]));
//        System.out.println("A: " + new java.sql.Date(c.getTime().getTime()));
        return new java.sql.Date(c.getTime().getTime());
    }
}
