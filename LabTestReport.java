import java.util.Date;

/**
 * Created by ncbrown on 2/26/15.
 */
public class LabTestReport {
    private String LabTestResultID;
    private String PatientVisitID;
    private String LabTestPerformedDate;
    private String LabTestType;
    private String TestResultValue;
    private String ReferenceRangeHigh;
    private String ReferenceRangeLow;
    private String PatientID;

    public LabTestReport(String labTestResultID, String patientVisitID, String labTestPerformedDate, String labTestType, String testResultValue, String referenceRangeHigh, String referenceRangeLow, String patientID) {
        LabTestResultID = labTestResultID;
        PatientVisitID = patientVisitID;
        LabTestPerformedDate = labTestPerformedDate;
        LabTestType = labTestType;
        TestResultValue = testResultValue;
        ReferenceRangeHigh = referenceRangeHigh;
        ReferenceRangeLow = referenceRangeLow;
        PatientID = patientID;
    }

    public String getLabTestResultID() { return LabTestResultID; }
    public String getPatientVisitID() { return PatientVisitID; }
    public String getLabTestPerformedDate() { return LabTestPerformedDate; }
    public String getLabTestType() { return LabTestType; }
    public String getTestResultValue() { return TestResultValue; }
    public String getReferenceRangeHigh() { return ReferenceRangeHigh; }
    public String getReferenceRangeLow() { return ReferenceRangeLow; }
    public String getPatientID() { return PatientID; }

    public void setLabTestResultID(String labTestResultID) { LabTestResultID = labTestResultID; }
    public void setPatientVisitID(String patientVisitID) { PatientVisitID = patientVisitID; }
    public void setLabTestPerformedDate(String labTestPerformedDate) { LabTestPerformedDate = labTestPerformedDate; }
    public void setLabTestType(String labTestType) { LabTestType = labTestType; }
    public void setTestResultValue(String testResultValue) { TestResultValue = testResultValue; }
    public void setReferenceRangeHigh(String referenceRangeHigh) { ReferenceRangeHigh = referenceRangeHigh; }
    public void setReferenceRangeLow(String referenceRangeLow) { ReferenceRangeLow = referenceRangeLow; }
    public void setPatientID(String patientID) { PatientID = patientID; }
}
