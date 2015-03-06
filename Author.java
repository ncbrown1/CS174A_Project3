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

    public String getAuthorID() { return AuthorID; }
    public String getAuthorTitle() { return AuthorTitle; }
    public String getAuthorFirstName() { return AuthorFirstName; }
    public String getAuthorLastName() { return AuthorLastName; }
    public String getPatientID() { return PatientID; }
    public String getParticipatingRole() { return ParticipatingRole; }

    public void setAuthorID(String authorID) { AuthorID = authorID; }
    public void setAuthorTitle(String authorTitle) { AuthorTitle = authorTitle; }
    public void setAuthorFirstName(String authorFirstName) { AuthorFirstName = authorFirstName; }
    public void setAuthorLastName(String authorLastName) { AuthorLastName = authorLastName; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public void setParticipatingRole(String participatingRole) { ParticipatingRole = participatingRole; }
}
