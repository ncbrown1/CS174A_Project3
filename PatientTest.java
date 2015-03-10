/**
 * Created by ncbrown on 3/9/15.
 */
public class PatientTest {
    private String PatientID;
    private String LabTestResultID;

    public PatientTest(String patientID, String labTestResultID) {
        PatientID = patientID;
        LabTestResultID = labTestResultID;
    }

    public String insertStatement() {
        if(LabTestResultID == null) return "";
        String pid = getPatientID(), ltr = getLabTestResultID();
        return "INSERT INTO Patient_Test(PatientID,LabTestResultID) " +
                "VALUES ("+pid+","+ltr+") " +
                "ON DUPLICATE KEY UPDATE PatientID="+pid+",LabTestResultID="+ltr+";";
    }

    public String getPatientID() { return PatientID == null ? "NULL" : "\"" + PatientID + "\""; }
    public String getLabTestResultID() { return LabTestResultID == null ? "NULL" : "\"" + LabTestResultID + "\""; }

    public void setPatientID(String patientID) { PatientID = patientID; }
    public void setLabTestResultID(String labTestResultID) { LabTestResultID = labTestResultID; }
}
