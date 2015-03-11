

/**
 * Created by christinamorris on 3/9/15.
 */
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.Properties;
        import java.io.*;
        import java.sql.*;
        import java.util.Scanner;


public class AdministratorInterface {

    /** The name of the MySQL account to use (or empty for anonymous) */
    private final String userName = "root";

    /** The password for the MySQL account (or empty for anonymous) */
    private final String password = "";

    /** The name of the computer running MySQL */
    private final String serverName = "localhost";

    /** The port of the MySQL server (default is 3306) */
    private final int portNumber = 3306;

    /** The name of the database we are testing with (this default is installed with MySQL) */
    private final String dbName = "healthinformationsystem";

    /** The name of the table we are testing with */
    private final String tableName = "Patient";

    /**
     * Get a new database connection
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        conn = DriverManager.getConnection("jdbc:mysql://"
                        + this.serverName + ":" + this.portNumber + "/" + this.dbName,
                connectionProps);

        return conn;
    }

    /**
     * Run a SQL command which does not return a recordset:
     * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
     *
     * @throws SQLException If something goes wrong
     */
    public boolean executeUpdate(Connection conn, String command) throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(command); // This will throw a SQLException if it fails
            return true;
        } finally {

            // This will run whether we throw an exception or not
            if (stmt != null) { stmt.close(); }
        }
    }



    /**
     * Connect to MySQL and do some stuff.
     */
    public void run() {

        // Connect to MySQL
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = this.getConnection();
            stmt = conn.createStatement();
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("ERROR: Could not connect to the database");
            e.printStackTrace();
            return;
        }
        int OptionNum = 0;
        Scanner scan = new Scanner(System.in);
        while (OptionNum != 5) {
            System.out.println("===== Administrator Interface =====");
            System.out.println("Type Number of Action:");
            System.out.println("1:View number of patients for each type of allergy (substance).");
            System.out.println("2:List the patients who have more than one allergy.");
            System.out.println("3:List the patients who have a plan for surgery today.");
            System.out.println("4:Identify authors with more than one patient.");
            System.out.println("5:Quit");
            System.out.print(">> ");

            OptionNum = scan.nextInt();

            if (OptionNum == 1) {
                try {
                    System.out.print("Enter Substance Name:\n>> ");
                    String SubstanceName = "'" + scan.next() + "'";

                    String createString =
                            "SELECT COUNT(DISTINCT A.PatientID) " +
                                    "FROM Allergy A " +
                                    "WHERE A.substance_name = " + SubstanceName;
                    ResultSet rs = stmt.executeQuery(createString);
                    while (rs.next()) {
                        //Retrieve by column name
                        String count = rs.getString("COUNT(DISTINCT A.PatientID)");


                        //Display values
                        System.out.println("Number of Patients: " + count);


                    }

                } catch (SQLException e) {
                    System.out.println("ERROR: Could not update Patient");
                    e.printStackTrace();
                    return;
                }
            }
            if (OptionNum == 2) {
                try {

                    String createString =
                            "SELECT P.GivenName, P.FamilyName " +
                                    "FROM Patient P " +
                                    "WHERE 1 < (SELECT COUNT(*) " +
                                    "FROM Allergy PA " +
                                    "WHERE PA.PatientID = P.PatientID) ";
                    ResultSet rs = stmt.executeQuery(createString);
                    System.out.println("Patients with multiple allergies:");
                    while (rs.next()) {
                        //Retrieve by column name
                        String GivenName = rs.getString("P.GivenName");
                        String FamilyName = rs.getString("P.FamilyName");

                        //Display values
                        System.out.println(GivenName + " " + FamilyName);


                    }

                } catch (SQLException e) {
                    System.out.println("ERROR: Could not update Patient");
                    e.printStackTrace();
                    return;
                }
            }
            if (OptionNum == 3) {
                try {
                    String createString = "" +
                            "SELECT P.GivenName, P.FamilyName " +
                            "FROM Plan Pl, Patient P " +
                            "WHERE Pl.ActivityDate = CURDATE() AND P.PatientID = Pl.PatientID";

                    ResultSet rs = stmt.executeQuery(createString);
                    System.out.println("Patients who have a plan for surgery today:");
                    while (rs.next()) {
                        //Retrieve by column name
                        String GivenName = rs.getString("P.GivenName");
                        String FamilyName = rs.getString("P.FamilyName");

                        //Display values
                        System.out.println(GivenName + " " + FamilyName);

                    }

                } catch (SQLException e) {
                    System.out.println("ERROR: Could not update Patient");
                    e.printStackTrace();
                    return;
                }
            }
            if (OptionNum == 4) {
                try {
                    String createString =
                            "SELECT A.AuthorFirstName, A.AuthorLastName " +
                                    "FROM Author AS A " +
                                    "WHERE 1 < (SELECT COUNT(*) " +
                                    "           FROM AuthorPatient AP " +
                                    "           WHERE AP.AuthorID = A.AuthorID)";
                    ResultSet rs = stmt.executeQuery(createString);
                    System.out.println("Authors with more than one patient:");
                    while (rs.next()) {
                        //Retrieve by column name
                        String GivenName = rs.getString("A.AuthorFirstName");
                        String FamilyName = rs.getString("A.AuthorLastName");

                        //Display values
                        System.out.println(GivenName + " " + FamilyName);

                    }

                } catch (SQLException e) {
                    System.out.println("ERROR: Could not update Patient");
                    e.printStackTrace();
                    return;
                }
            }
        }

    }


    /**
     * Connect to the DB and do some stuff
     */
    public static void main(String[] args) {
        AdministratorInterface app = new AdministratorInterface();
        app.run();

    }


}