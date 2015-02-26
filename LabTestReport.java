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
    private String PatientID;

    public LabTestReport(String labTestResultID, String patientVisitID, Date labTestPerformedDate, String labTestType, String testResultValue, String referenceRangeHigh, String referenceRangeLow, String patientID) {
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
    public void setLabTestResultID(String labTestResultID) { LabTestResultID = labTestResultID; }
    public String getPatientVisitID() { return PatientVisitID; }
    public void setPatientVisitID(String patientVisitID) { PatientVisitID = patientVisitID; }
    public Date getLabTestPerformedDate() { return LabTestPerformedDate; }
    public void setLabTestPerformedDate(Date labTestPerformedDate) { LabTestPerformedDate = labTestPerformedDate; }
    public String getLabTestType() { return LabTestType; }
    public void setLabTestType(String labTestType) { LabTestType = labTestType; }
    public String getTestResultValue() { return TestResultValue; }
    public void setTestResultValue(String testResultValue) { TestResultValue = testResultValue; }
    public String getReferenceRangeHigh() { return ReferenceRangeHigh; }
    public void setReferenceRangeHigh(String referenceRangeHigh) { ReferenceRangeHigh = referenceRangeHigh; }
    public String getReferenceRangeLow() { return ReferenceRangeLow; }
    public void setReferenceRangeLow(String referenceRangeLow) { ReferenceRangeLow = referenceRangeLow; }
    public String getPatientID() { return PatientID; }
    public void setPatientID(String patientID) { PatientID = patientID; }
}
