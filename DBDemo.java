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

/**
 * This class demonstrates how to connect to MySQL and run some basic commands.
 *
 * In order to use this, you have to download the Connector/J driver and add
 * its .jar file to your build path.  You can find it here:
 *
 * http://dev.mysql.com/downloads/connector/j/
 *
 * You will see the following exception if it's not in your class path:
 *
 * java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/
 *
 * To add it to your class path:
 * 1. Right click on your project
 * 2. Go to Build Path -> Add External Archives...
 * 3. Select the file mysql-connector-java-5.1.24-bin.jar
 *    NOTE: If you have a different version of the .jar file, the name may be
 *    a little different.
 *
 * The user name and password are both "root", which should be correct if you followed
 * the advice in the MySQL tutorial. If you want to use different credentials, you can
 * change them below.
 *
 * You will get the following exception if the credentials are wrong:
 *
 * java.sql.SQLException: Access denied for user 'userName'@'localhost' (using password: YES)
 *
 * You will instead get the following exception if MySQL isn't installed, isn't
 * running, or if your serverName or portNumber are wrong:
 *
 * java.net.ConnectException: Connection refused
 */
public class DBDemo {

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


    public void printPatientInfo(Statement stmt, String PatientID){
        try {
            String createString =
                    "SELECT * " +
                            "FROM Patient P " +
                            "WHERE P.PatientID = " + PatientID + ";";

            ResultSet rs = stmt.executeQuery(createString);
            while(rs.next()){
                //Retrieve by column name
                String GivenName = rs.getString("GivenName");
                String FamilyName = rs.getString("FamilyName");
                String Suffix = rs.getString("Suffix");
                String Gender = rs.getString("Gender");
                String Birthtime = rs.getString("Birthtime");
                String ProviderID = rs.getString("ProviderID");
                String Creation = rs.getString("Creation");
                String PatientRole = rs.getString("PatientRole");

                //Display values
                System.out.println("Name: " + GivenName + " " + FamilyName);
                System.out.println("Suffix: " + Suffix);
                System.out.println("Gender: " + Gender);
                System.out.println("Birthtime: " + Birthtime);
                System.out.println("ProviderID: " + ProviderID);
                System.out.println("Creation: " + Creation);
                System.out.println("PatientRole: " + PatientRole);
            }
            System.out.println("Patient Information");
        } catch (SQLException e) {
            System.out.println("ERROR: Could not find Patient");
            e.printStackTrace();
            return;
        }
    }

    public void printGuardianInfo(Statement stmt, String PatientID){
        try {
            String createString =
                    "SELECT * " +
                            "FROM Guardian_of G, Patient P " +
                            "WHERE G.GuardianNo = P.PatientRole " +
                            "AND P.PatientID = " + PatientID;
            ResultSet rs = stmt.executeQuery(createString);
            while(rs.next()){
                //Retrieve by column name
                String GivenName = rs.getString("GivenName");
                String FamilyName = rs.getString("FamilyName");
                String Suffix = rs.getString("Suffix");
                String Gender = rs.getString("Gender");
                String Birthtime = rs.getString("Birthtime");
                String ProviderID = rs.getString("ProviderID");
                String Creation = rs.getString("Creation");
                String PatientRole = rs.getString("PatientRole");

                //Display values
                System.out.println("Name: " + GivenName + " " + FamilyName);
                System.out.println("Suffix: " + Suffix);
                System.out.println("Gender: " + Gender);
                System.out.println("Birthtime: " + Birthtime);
                System.out.println("ProviderID: " + ProviderID);
                System.out.println("Creation: " + Creation);
                System.out.println("PatientRole: " + PatientRole);
            }
            System.out.println("Patient Information");
        } catch (SQLException e) {
            System.out.println("ERROR: Could not find Guardian");
            e.printStackTrace();
            return;
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
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("ERROR: Could not connect to the database");
            e.printStackTrace();
            return;
        }

        System.out.println("Patient Interface");
        System.out.println("Enter PatientID");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String PatientID = null;
        try {
            PatientID = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

        try {
            conn = this.getConnection();
            stmt = conn.createStatement();
            printPatientInfo(stmt, PatientID);
        } catch (SQLException e) {
            System.out.println("ERROR: Could not find Patient");
            e.printStackTrace();
            return;
        }
        try {
            conn = this.getConnection();
            stmt = conn.createStatement();
            printGuardianInfo(stmt, PatientID);
        } catch (SQLException e) {
            System.out.println("ERROR: Could not find Patient");
            e.printStackTrace();
            return;
        }
        String EditInfo = null;
        while (EditInfo != "done") {
            System.out.println("Type Patient to edit Patient information");
            System.out.println("Type Guardian to edit Guardian information");
            System.out.println("Type done to exit");
            try {
                EditInfo = br.readLine();
            } catch (IOException ioe) {
                System.out.println("IO error trying to read your name!");
                System.exit(1);
            }
            System.out.println("You entered: '" + EditInfo + "'");
            if (EditInfo.equalsIgnoreCase("Patient")) {
                try {
                    System.out.println("Patient Information: PatientID,GivenName,FamilyName,Suffix,Gender,Birthtime,ProviderID,Creation,PatientRole");
                    System.out.println("Enter Field to edit:");
                    String NewValue = null;
                    try {
                        PatientID = br.readLine();

                    } catch (IOException ioe) {
                        System.out.println("IO error trying to read your name!");
                        System.exit(1);
                    }
                    System.out.println("Enter new value:");
                    try {
                        NewValue = br.readLine();
                    } catch (IOException ioe) {
                        System.out.println("IO error trying to read your name!");
                        System.exit(1);
                    }

                    String createString =
                            "UPDATE Patient P " +
                                    "SET P." + PatientID + " = " + NewValue +
                                    " WHERE P.PatientID = PatientID;";
                    System.out.println(createString);
                    this.executeUpdate(conn, createString);
                    System.out.println("Updated Patient Info:");
                    try {
                        conn = this.getConnection();
                        stmt = conn.createStatement();
                        printPatientInfo(stmt, PatientID);
                    } catch (SQLException e) {
                        System.out.println("ERROR: Could not find Patient");
                        e.printStackTrace();
                        return;
                    }
                } catch (SQLException e) {
                    System.out.println("ERROR: Could not update Patient");
                    e.printStackTrace();
                    return;
                }
            }
            if (EditInfo.equalsIgnoreCase("Guardian\n")) {
                try {
                    System.out.println("Guardian Enter Field to edit:");
                    String NewValue = null;
                    try {
                        PatientID = br.readLine();
                    } catch (IOException ioe) {
                        System.out.println("IO error trying to read your name!");
                        System.exit(1);
                    }
                    System.out.println("Enter new value:");
                    try {
                        NewValue = br.readLine();
                    } catch (IOException ioe) {
                        System.out.println("IO error trying to read your name!");
                        System.exit(1);
                    }

                    String createString =
                            "UPDATE Guardian_of G " +
                                    "SET G." + PatientID + " = " + NewValue +
                                    " WHERE G.GuardianNo = (SELECT P.PatientRole " +
                                    "FROM Patient P " +
                                    "WHERE P.PatientID = " + PatientID + ");";
                    System.out.println(createString);
                    this.executeUpdate(conn, createString);
                    System.out.println("Updated Patient Info:");
                    try {
                        conn = this.getConnection();
                        stmt = conn.createStatement();
                        printGuardianInfo(stmt, PatientID);
                    } catch (SQLException e) {
                        System.out.println("ERROR: Could not find Patient");
                        e.printStackTrace();
                        return;
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
        DBDemo app = new DBDemo();
        app.run();

    }


}