/**
 * Created by ncbrown on 2/26/15.
 */
public class Allergy {
    private String substance;
    private String reaction;
    private String status;
    private String PatientID;

    public Allergy(String substance, String reaction, String status, String patientID) {
        this.substance = substance;
        this.reaction = reaction;
        this.status = status;
        PatientID = patientID;
    }

    public String getSubstance() { return substance; }
    public void setSubstance(String substance) { this.substance = substance; }
    public String getReaction() { return reaction; }
    public void setReaction(String reaction) { this.reaction = reaction; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPatientID() { return PatientID; }
    public void setPatientID(String patientID) { PatientID = patientID; }
}
