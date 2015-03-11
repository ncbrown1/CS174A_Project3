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

public class PatientInterface {

    private final String userName = "root";
    private final String password = "";
    private final String serverName = "localhost";
    private final int portNumber = 3306;
    private final String dbName = "healthinformationsystem";
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
                            "FROM Guardian G, Patient P " +
                            "WHERE G.GuardianNo = P.PatientRole " +
                            "AND P.PatientID = " + PatientID;
            ResultSet rs = stmt.executeQuery(createString);
            while(rs.next()){
                //Retrieve by column name
                String GivenName = rs.getString("GivenName");
                String FamilyName = rs.getString("FamilyName");
                String Phone = rs.getString("Phone");
                String Address = rs.getString("Address");
                String City = rs.getString("City");
                String State = rs.getString("State");
                String Zip = rs.getString("Zip");

                //Display values
                System.out.println("GivenName: " + GivenName);
                System.out.println("FamilyName: " + FamilyName);
                System.out.println("Phone: " + Phone);
                System.out.println("Address: " + Address);
                System.out.println("City: " + City);
                System.out.println("State: " + State);
                System.out.println("Zip: " + Zip);
            }
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
        Connection conn;
        Statement stmt;
        try {
            conn = this.getConnection();
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("ERROR: Could not connect to the database");
            e.printStackTrace();
            return;
        }

        System.out.println("===== Patient Interface =====");
        System.out.println("Enter PatientID");

        Scanner scan = new Scanner(System.in);
        System.out.print(">> ");
        String PatientID = scan.next();

        try {
            stmt = conn.createStatement();
            printPatientInfo(stmt, PatientID);
        } catch (SQLException e) {
            System.out.println("ERROR: Could not find Patient");
            e.printStackTrace();
            return;
        }

        String EditInfo = null;
        int EditChoice = 0;
        while(EditChoice != 3) {
            System.out.println("1. Edit Patient information");
            System.out.println("2. Edit Guardian information");
            System.out.println("3. Exit");
            System.out.print(">> ");

            EditChoice = scan.nextInt();

            System.out.println("You entered: '" + EditInfo + "'");
            if (EditChoice == 1) { //EditInfo.equalsIgnoreCase("Patient")) {
                try {
                    System.out.println("Patient Information: GivenName,FamilyName,Suffix,Gender,Birthtime,ProviderID,Creation,PatientRole");
                    System.out.print("Enter Field to edit:\n>> ");
                    String NewField = scan.next();
                    System.out.print("Enter new value:\n>> ");
                    String NewValue = "'" + scan.next() + "'";

                    String createString =
                            "UPDATE Patient P " +
                                    "SET P." + NewField + " = " + NewValue +
                                    " WHERE P.PatientID = " + PatientID;
                    System.out.println(createString);
                    this.executeUpdate(conn, createString);
                    System.out.println("Updated Patient Info:");
                    try {
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
            } else if (EditChoice == 2) {//EditInfo.equalsIgnoreCase("Guardian")) {
                try {
                    stmt = conn.createStatement();
                    printGuardianInfo(stmt,PatientID);
                } catch (SQLException e) {
                    System.out.println("ERROR: Could not find guardian");
                    e.printStackTrace();
                    return;
                }
                try {
                    System.out.print("Guardian Enter Field to edit:\n>> ");
                    String NewField = scan.next();
                    System.out.print("Enter new value:\n>> ");
                    String NewValue = "'" + scan.next() + "'";

                    String createString =
                            "UPDATE Guardian G " +
                                    "SET G." + NewField + " = " + NewValue +
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
        PatientInterface app = new PatientInterface();
        app.run();

    }


}