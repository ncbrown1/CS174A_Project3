import java.util.Date;

/**
 * Created by ncbrown on 2/26/15.
 */
public class LabTestReport {
    private String LabTestResultID;
    private String PatientVisitID;
    private Date LabTestPerformedDate;
    private String LabTestType;
    private String TestResultValue;
    private String ReferenceRangeHigh;
    private String ReferenceRangeLow;

    public LabTestReport(String labTestResultID, String patientVisitID, String labTestPerformedDate, String labTestType, String testResultValue, String referenceRangeHigh, String referenceRangeLow) {
        LabTestResultID = labTestResultID;
        PatientVisitID = patientVisitID;
        LabTestPerformedDate = Str2Date.convert(labTestPerformedDate);
        LabTestType = labTestType;
        TestResultValue = testResultValue;
        ReferenceRangeHigh = referenceRangeHigh;
        ReferenceRangeLow = referenceRangeLow;
    }

    public String insertStatement() {
        if(LabTestResultID == null) return "";
        String ltr = getLabTestResultID(), pv = getPatientVisitID(), ltd = getLabTestPerformedDate(),
                t = getLabTestType(), val = getTestResultValue(), rh = getReferenceRangeHigh(), rl = getReferenceRangeLow();
        return "INSERT INTO LabTestReport(LabTestResultID,PatientVisitID,LabTestPerformedDate,LabTestType,ReferenceRangeHigh" +
                ",ReferenceRangeLow,TestResultValue) VALUES ("+ltr+","+pv+","+ltd+","+t+","+rh+","+rl+","+val+") " +
                "ON DUPLICATE KEY UPDATE PatientVisitID="+pv+",LabTestPerformedDate="+ltd+",LabTestType="+t+"," +
                "ReferenceRangeHigh="+rh+",ReferenceRangeLow="+rl+",TestResultValue="+val+";";
    }

    public String getLabTestResultID() { return LabTestResultID == null ? "NULL" : "\"" + LabTestResultID + "\""; }
    public String getPatientVisitID() { return PatientVisitID == null ? "NULL" : "\"" + PatientVisitID + "\""; }
    public String getLabTestPerformedDate() { return LabTestPerformedDate == null ? "NULL" : "\"" + LabTestPerformedDate + "\""; }
    public String getLabTestType() { return LabTestType == null ? "NULL" : "\"" + LabTestType + "\""; }
    public String getTestResultValue() { return TestResultValue == null ? "NULL" : "\"" + TestResultValue + "\""; }
    public String getReferenceRangeHigh() { return ReferenceRangeHigh == null ? "NULL" : "\"" + ReferenceRangeHigh + "\""; }
    public String getReferenceRangeLow() { return ReferenceRangeLow == null ? "NULL" : "\"" + ReferenceRangeLow + "\""; }

    public void setLabTestResultID(String labTestResultID) { LabTestResultID = labTestResultID; }
    public void setPatientVisitID(String patientVisitID) { PatientVisitID = patientVisitID; }
    public void setLabTestPerformedDate(String labTestPerformedDate) { LabTestPerformedDate = Str2Date.convert(labTestPerformedDate); }
    public void setLabTestType(String labTestType) { LabTestType = labTestType; }
    public void setTestResultValue(String testResultValue) { TestResultValue = testResultValue; }
    public void setReferenceRangeHigh(String referenceRangeHigh) { ReferenceRangeHigh = referenceRangeHigh; }
    public void setReferenceRangeLow(String referenceRangeLow) { ReferenceRangeLow = referenceRangeLow; }
}
