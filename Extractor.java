import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by ncbrown on 3/8/15.
 */
public class Extractor {

    private final String user = "root";
    private final String pass = "";
    private final String server = "localhost";
    private final int port = 3306;
    private final String messagesdb = "healthmessagesexchange2";
    private final String informationdb = "healthinformationsystem";

    public Connection getMessagesConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.user);
        connectionProps.put("password", this.pass);

        conn = DriverManager.getConnection("jdbc:mysql://"
                        + this.server + ":" + this.port + "/" + this.messagesdb,
                connectionProps);

        return conn;
    }

    public Connection getInfoConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.user);
        connectionProps.put("password", this.pass);

        conn = DriverManager.getConnection("jdbc:mysql://"
                        + this.server + ":" + this.port + "/" + this.informationdb,
                connectionProps);

        return conn;
    }

    public Connection getConnection(String databaseName) throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.user);
        connectionProps.put("password", this.pass);

        conn = DriverManager.getConnection("jdbc:mysql://" + this.server + ":" + this.port + "/" + databaseName,
                connectionProps);
        return conn;
    }

    public boolean executeUpdate(Connection conn, String command) throws SQLException {
        if(command == "") return true;
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

    public ResultSet executeQuery(Connection conn, String query) throws SQLException {
        Statement stmt = null;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public void run(String databaseName, String tableName) throws SQLException {

        // Connect to MySQL
        Connection msgcon = null;
        Connection infocon = null;
        try {
            msgcon = this.getConnection(databaseName);
            infocon = this.getConnection(this.informationdb);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("ERROR: Could not connect to the database");
            e.printStackTrace();
            return;
        }

        ResultSet rs = this.executeQuery(msgcon, "SELECT * FROM " + tableName);
        while(rs.next()) {
            Message message = new Message(
                    rs.getString("MsgID"), rs.getString("Last_Accessed"), rs.getString("patientId"),
                    rs.getString("GivenName"), rs.getString("FamilyName"), rs.getString("BirthTime"),
                    rs.getString("providerId"), rs.getString("GuardianNo"), rs.getString("Relationship"),
                    rs.getString("FirstName"), rs.getString("LastName"), rs.getString("phone"),
                    rs.getString("address"), rs.getString("city"), rs.getString("state"),
                    rs.getString("zip"), rs.getString("AuthorId"), rs.getString("AuthorTitle"),
                    rs.getString("AuthorFirstName"), rs.getString("AuthorLastName"), rs.getString("ParticipatingRole"),
                    rs.getString("PayerId"), rs.getString("Name"), rs.getString("PolicyHolder"),
                    rs.getString("PolicyType"), rs.getString("Purpose"), rs.getString("RelativeId"),
                    rs.getString("Relation"), rs.getString("age"), rs.getString("Diagnosis"),
                    rs.getString("Id"), rs.getString("Substance"), rs.getString("Reaction"),
                    rs.getString("Status"), rs.getString("LabTestResultId"), rs.getString("PatientVisitId"),
                    rs.getString("LabTestPerformedDate"), rs.getString("LabTestType"), rs.getString("TestResultValue"),
                    rs.getString("ReferenceRangeHigh"), rs.getString("ReferenceRangeLow"), rs.getString("PlanId"),
                    rs.getString("Activity"), rs.getString("ScheduledDate"));
            executeUpdate(msgcon,"UPDATE "+tableName+" SET Last_Accessed=CURDATE() WHERE MsgID=\"" + rs.getString("MsgID") + "\"");
            executeUpdate(infocon,message.getGuardian().insertStatement());
            executeUpdate(infocon,message.getInsuranceCompany().insertStatement());
            executeUpdate(infocon,message.getLabTestReport().insertStatement());
            executeUpdate(infocon,message.getPatient().insertStatement());
            executeUpdate(infocon,message.getAuthor().insertStatement());
            executeUpdate(infocon,message.getAuthorPatient().insertStatement());
            executeUpdate(infocon,message.getFamilyMember().insertStatement());
            executeUpdate(infocon,message.getPatientAllergy().insertStatement());
            executeUpdate(infocon,message.getPatientTest().insertStatement());
            executeUpdate(infocon,message.getPlan().insertStatement());
        }
        System.out.println("Finished importing data");
    }
}
