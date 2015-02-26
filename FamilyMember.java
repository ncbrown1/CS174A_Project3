/**
 * Created by ncbrown on 2/26/15.
 */
public class FamilyMember {
    private String Relationship;
    private String Age;
    private String PatientID;
    private String FamilyMemberID;
    private String Diagnosis;

    public FamilyMember(String relationship, String age, String patientID, String familyMemberID, String diagnosis) {
        Relationship = relationship;
        Age = age;
        PatientID = patientID;
        FamilyMemberID = familyMemberID;
        Diagnosis = diagnosis;
    }

    public String getRelationship() { return Relationship; }
    public void setRelationship(String relationship) { Relationship = relationship; }
    public String getAge() { return Age; }
    public void setAge(String age) { Age = age; }
    public String getPatientID() { return PatientID; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public String getFamilyMemberID() { return FamilyMemberID; }
    public void setFamilyMemberID(String familyMemberID) { FamilyMemberID = familyMemberID; }
    public String getDiagnosis() { return Diagnosis; }
    public void setDiagnosis(String diagnosis) { Diagnosis = diagnosis; }
}
