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
public class Doctor {

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


    public void printAllergyInfo(Statement stmt, String PatientID, String AllergyID){
        try {
            String createString =
                    "SELECT * " +
                            "FROM Allergy A " +
                            "WHERE A.AllergyID = " + AllergyID + ";";

            ResultSet rs = stmt.executeQuery(createString);
            while(rs.next()){
                //Retrieve by column name
                String substance_name = rs.getString("substance_name");
                String reaction = rs.getString("reaction");
                String status = rs.getString("status");


                //Display values
                System.out.println("substance_name: " + substance_name);
                System.out.println("reaction: " + reaction);
                System.out.println("status: " + status);

            }
        } catch (SQLException e) {
            System.out.println("ERROR: Could not find Allergy");
            e.printStackTrace();
            return;
        }
    }

    public void printPlanInfo(Statement stmt, String PlanID){
        try {
            String createString =
                    "SELECT * " +
                            "FROM Plan P " +
                            "WHERE P.PlanID = " + PlanID;
            ResultSet rs = stmt.executeQuery(createString);
            while(rs.next()){
                //Retrieve by column name
                String ActivityDate = rs.getString("ActivityDate");
                String Activity = rs.getString("Activity");
                String PatientID = rs.getString("PatientID");

                //Display values
                System.out.println("Activity: " + Activity);
                System.out.println("PatientID: " + PatientID);
                System.out.println("ActivityDate: " + ActivityDate);

            }
        } catch (SQLException e) {
            System.out.println("ERROR: Could not find Plan");
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


        System.out.println("Doctor Interface");
        System.out.println("Enter Allergy to edit Allergy");
        System.out.println("Enter Plan to edit Plan");

        String EditOption = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            EditOption = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        if (EditOption.equalsIgnoreCase("Allergy")) {
            System.out.println("Enter PatientID");
            String PatientID = null;
            try {
                PatientID = br.readLine();
            } catch (IOException ioe) {
                System.out.println("IO error trying to read your name!");
                System.exit(1);
            }

            System.out.println("Enter AllergyID");
            String AllergyID = null;
            try {
                AllergyID = br.readLine();
            } catch (IOException ioe) {
                System.out.println("IO error trying to read your name!");
                System.exit(1);
            }
            try {
                conn = this.getConnection();
                stmt = conn.createStatement();
                printAllergyInfo(stmt, PatientID, AllergyID);
            } catch (SQLException e) {
                System.out.println("ERROR: Could not find Allergy");
                e.printStackTrace();
                return;
            }
            try {
                System.out.println("Enter Field to edit:");
                String NewField = null;
                String NewValue = null;
                try {
                    NewField = br.readLine();

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
                        "UPDATE Allergy A " +
                                "SET A." + NewField + " = " + NewValue +
                                " WHERE A.PatientID = " + PatientID +
                                " AND A.AllergyID = " + AllergyID;

                System.out.println(createString);
                this.executeUpdate(conn, createString);
                System.out.println("Updated Allegy Info:");
                try {
                    conn = this.getConnection();
                    stmt = conn.createStatement();
                    printAllergyInfo(stmt, PatientID, AllergyID);
                } catch (SQLException e) {
                    System.out.println("ERROR: Could not find Allergy");
                    e.printStackTrace();
                    return;
                }
            } catch (SQLException e) {
                System.out.println("ERROR: Could not update Allergy");
                e.printStackTrace();
                return;
            }
        }

        System.out.println("Enter PlanID");
        String PlanID = null;
        try {
            PlanID = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }


        try {
            conn = this.getConnection();
            stmt = conn.createStatement();
            printPlanInfo(stmt, PlanID);
        } catch (SQLException e) {
            System.out.println("ERROR: Could not find Activity");
            e.printStackTrace();
            return;
        }


        try {
            System.out.println("Enter Field to edit:");
            String NewField = null;
            String NewValue = null;
            try {
                NewField = br.readLine();
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
                    "UPDATE Plan P " +
                            "SET p." + NewField + " = " + NewValue +
                            " WHERE P.PlanID = " + PlanID;
            System.out.println(createString);
            this.executeUpdate(conn, createString);
            System.out.println("Updated Plan Info:");
            try {
                conn = this.getConnection();
                stmt = conn.createStatement();
                printPlanInfo(stmt, PlanID);
            } catch (SQLException e) {
                System.out.println("ERROR: Could not find Plan");
                e.printStackTrace();
                return;
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Could not update Plan");
            e.printStackTrace();
            return;
        }
    }


    /**
     * Connect to the DB and do some stuff
     */
    public static void main(String[] args) {
        Doctor app = new Doctor();
        app.run();

    }


}