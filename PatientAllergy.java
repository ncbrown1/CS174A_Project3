/**
 * Created by ncbrown on 3/9/15.
 */
public class PatientAllergy {
    private String AllergyID;
    private String substance_name;
    private String reaction;
    private String status;
    private String PatientID;

    public PatientAllergy(String allergyID, String substance_name, String reaction, String status, String patientID) {
        AllergyID = allergyID;
        this.substance_name = substance_name;
        this.reaction = reaction;
        this.status = status;
        PatientID = patientID;
    }

    public String insertStatement() {
        if(AllergyID == null) return "";
        String aid = getAllergyID(), sn = getSubstanceName(), r = getReaction(), s = getStatus(), pid = getPatientID();
        return "INSERT INTO Allergy (AllergyID,substance_name,reaction,status,PatientID)" +
                "VALUES ("+aid+","+sn+","+r+","+s+","+pid+") " +
                "ON DUPLICATE KEY UPDATE substance_name="+sn+",reaction="+r+",status="+s+";";
    }

    public String getAllergyID() { return AllergyID == null ? "NULL" : "\"" + AllergyID + "\""; }
    public String getSubstanceName() { return substance_name == null ? "NULL" : "\"" + substance_name + "\""; }
    public String getReaction() { return reaction == null ? "NULL" : "\"" + reaction + "\""; }
    public String getStatus() { return status == null ? "NULL" : "\"" + status + "\""; }
    public String getPatientID() { return PatientID == null ? "NULL" : "\"" + PatientID + "\""; }

    public void setAllergyID(String allergyID) { AllergyID = allergyID; }
    public void setReaction(String reaction) { this.reaction = reaction; }
    public void setStatus(String status) { this.status = status; }
    public void setPatientID(String patientID) { PatientID = patientID; }
}
