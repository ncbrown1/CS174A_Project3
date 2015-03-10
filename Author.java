/**
 * Created by ncbrown on 2/26/15.
 */
public class Author {
    private String AuthorID;
    private String AuthorTitle;
    private String AuthorFirstName;
    private String AuthorLastName;
    private String PatientID;
    private String ParticipatingRole;

    public Author(String authorID, String authorTitle, String authorFirstName, String authorLastName, String patientID, String participatingRole) {
        AuthorID = authorID;
        AuthorTitle = authorTitle;
        AuthorFirstName = authorFirstName;
        AuthorLastName = authorLastName;
        PatientID = patientID;
        ParticipatingRole = participatingRole;
    }

    public String insertStatement() {
        if(AuthorID == null) return "";
        String aid = getAuthorID(), t = getAuthorTitle(), fn = getAuthorFirstName(), ln = getAuthorLastName(),
                pid = getPatientID(), pr = getParticipatingRole();
        return "INSERT INTO Author(AuthorID,AuthorTitle,AuthorFirstName,AuthorLastName,PatientID,ParticipatingRole) " +
                "VALUES ("+aid+","+t+","+fn+","+ln+","+pid+","+pr+") " +
                "ON DUPLICATE KEY UPDATE AuthorTitle="+t+",AuthorFirstName="+fn+",AuthorLastName="+ln+",ParticipatingRole="+pr+";";
    }

    public String getAuthorID() { return AuthorID == null ? "NULL" : "\"" + AuthorID + "\""; }
    public String getAuthorTitle() { return AuthorTitle == null ? "NULL" : "\"" + AuthorTitle + "\""; }
    public String getAuthorFirstName() { return AuthorFirstName == null ? "NULL" : "\"" + AuthorFirstName + "\""; }
    public String getAuthorLastName() { return AuthorLastName == null ? "NULL" : "\"" + AuthorLastName + "\""; }
    public String getPatientID() { return PatientID == null ? "NULL" : "\"" + PatientID + "\""; }
    public String getParticipatingRole() { return ParticipatingRole == null ? "NULL" : "\"" + ParticipatingRole + "\""; }

    public void setAuthorID(String authorID) { AuthorID = authorID; }
    public void setAuthorTitle(String authorTitle) { AuthorTitle = authorTitle; }
    public void setAuthorFirstName(String authorFirstName) { AuthorFirstName = authorFirstName; }
    public void setAuthorLastName(String authorLastName) { AuthorLastName = authorLastName; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public void setParticipatingRole(String participatingRole) { ParticipatingRole = participatingRole; }
}
