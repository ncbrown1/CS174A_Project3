/**
 * Created by ncbrown on 3/10/15.
 */
public class AuthorPatient {
    private String AuthorID;
    private String PatientID;

    public AuthorPatient(String authorID, String patientID) {
        AuthorID = authorID;
        PatientID = patientID;
    }

    public String insertStatement() {
        if(AuthorID == null) return "";
        String aid = getAuthorID(), pid = getPatientID();
        return "INSERT INTO AuthorPatient(AuthorID,PatientID) " +
                "VALUES ("+aid+","+pid+") " +
                "ON DUPLICATE KEY UPDATE PatientID="+pid+",AuthorID="+aid+";";
    }

    public String getAuthorID() { return AuthorID == null ? "NULL" : "\"" + AuthorID + "\""; }
    public String getPatientID() { return PatientID == null ? "NULL" : "\"" + PatientID + "\""; }

    public void setAuthorID(String authorID) { AuthorID = authorID; }
    public void setPatientID(String patientID) { PatientID = patientID; }
}
