import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.*;
import java.sql.*;
import java.util.Scanner;


public class DoctorInterface {

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

        Scanner scan = new Scanner(System.in);

        int EditOption = 0;
        while (EditOption != 4) {

            System.out.println("===== Doctor Interface =====");
            System.out.println("1. Edit Patient Info");
            System.out.println("2. Edit Allergies");
            System.out.println("3. Edit Plans");
            System.out.println("4. Quit");
            System.out.print(">> ");

            EditOption = scan.nextInt();
            if (EditOption == 1) {
                System.out.print("Enter PatientID\n>> ");
                String PatientID = scan.next();
                try {
                    try {
                        stmt = conn.createStatement();
                        printPatientInfo(stmt, PatientID);
                    } catch (SQLException e) {
                        System.out.println("ERROR: Could not find Patient");
                        e.printStackTrace();
                        return;
                    }
                    System.out.println("Patient Information: PatientID,GivenName,FamilyName,Suffix,Gender,Birthtime,ProviderID,Creation,PatientRole");
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
            } else if (EditOption == 2) { //EditOption.equalsIgnoreCase("Allergy")) {
                System.out.print("Enter PatientID\n>> ");
                String PatientID = scan.next();

                try {
                    String createString =
                            "SELECT * " +
                                    "FROM Allergy " +
                                    "WHERE PatientID = " + PatientID + ";";
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(createString);
                    while(rs.next()){
                        //Retrieve by column name
                        String AllergyID = rs.getString("AllergyID");
                        String substance_name = rs.getString("substance_name");
                        String reaction = rs.getString("reaction");
                        String status = rs.getString("status");

                        //Display values
                        System.out.println("Allergy: " + AllergyID);
                        System.out.println("substance_name: " + substance_name);
                        System.out.println("reaction: " + reaction);
                        System.out.println("status: " + status);
                    }
                } catch (SQLException e) {
                    System.out.println("ERROR: Could not find Patient");
                    e.printStackTrace();
                    return;
                }

                System.out.print("Enter AllergyID\n>> ");
                String AllergyID = scan.next();

                try {
                    stmt = conn.createStatement();
                    printAllergyInfo(stmt, PatientID, AllergyID);
                } catch (SQLException e) {
                    System.out.println("ERROR: Could not find Allergy");
                    e.printStackTrace();
                    return;
                }
                try {
                    System.out.print("Enter Field to edit:\n>> ");
                    String NewField = scan.next();
                    System.out.print("Enter new value:\n>> ");
                    String NewValue = "'" + scan.next() + "'";

                    String createString =
                            "UPDATE Allergy A " +
                                    "SET A." + NewField + " = " + NewValue +
                                    " WHERE A.PatientID = " + PatientID +
                                    " AND A.AllergyID = " + AllergyID;

                    System.out.println(createString);
                    this.executeUpdate(conn, createString);
                    System.out.println("Updated Allergy Info:");
                    try {
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
            } else if (EditOption == 3) {//.equalsIgnoreCase("Plan")) {
                System.out.print("Enter PatientID\n>> ");
                String PatientID = scan.next();

                try {
                    String createString =
                            "SELECT * " +
                                    "FROM Plan " +
                                    "WHERE PatientID = " + PatientID + ";";
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(createString);
                    while(rs.next()){
                        //Retrieve by column name
                        String PlanID = rs.getString("PlanID");
                        String Activity = rs.getString("Activity");
                        String ActivityDate = rs.getString("ActivityDate");

                        //Display values
                        System.out.println("PlanID: " + PlanID);
                        System.out.println("Activity: " + Activity);
                        System.out.println("ActivityDate: " + ActivityDate);
                    }
                } catch (SQLException e) {
                    System.out.println("ERROR: Could not find Patient");
                    e.printStackTrace();
                    return;
                }

                System.out.print("Enter PlanID\n>> ");
                String PlanID = "'" + scan.next() + "'";

                try {
                    stmt = conn.createStatement();
                    printPlanInfo(stmt, PlanID);
                } catch (SQLException e) {
                    System.out.println("ERROR: Could not find Activity");
                    e.printStackTrace();
                    return;
                }


                try {
                    System.out.print("Enter Field to edit:\n>> ");
                    String NewField = scan.next();
                    System.out.print("Enter new value:\n>> ");
                    String NewValue = "'" + scan.next() + "'";

                    String createString =
                            "UPDATE Plan P " +
                                    "SET p." + NewField + " = " + NewValue +
                                    " WHERE P.PlanID = " + PlanID;
                    System.out.println(createString);
                    this.executeUpdate(conn, createString);
                    System.out.println("Updated Plan Info:");
                    try {
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
        }
    }


    /**
     * Connect to the DB and do some stuff
     */
    public static void main(String[] args) {
        DoctorInterface app = new DoctorInterface();
        app.run();

    }


}