/**
 * Created by ncbrown on 2/26/15.
 */
public class AuthorAssignment {
    private String PatientID;
    private String AuthorID;
    private String ParticipatingRole;

    public AuthorAssignment(String patientID, String authorID, String participatingRole) {
        PatientID = patientID;
        AuthorID = authorID;
        ParticipatingRole = participatingRole;
    }

    public String getPatientID() { return PatientID; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public String getAuthorID() { return AuthorID; }
    public void setAuthorID(String authorID) { AuthorID = authorID; }
    public String getParticipatingRole() { return ParticipatingRole; }
    public void setParticipatingRole(String participatingRole) { ParticipatingRole = participatingRole; }
}
