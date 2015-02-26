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
    public String getAge() { return Age; }
    public String getPatientID() { return PatientID; }
    public String getFamilyMemberID() { return FamilyMemberID; }
    public String getDiagnosis() { return Diagnosis; }

    public void setRelationship(String relationship) { Relationship = relationship; }
    public void setAge(String age) { Age = age; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public void setFamilyMemberID(String familyMemberID) { FamilyMemberID = familyMemberID; }
    public void setDiagnosis(String diagnosis) { Diagnosis = diagnosis; }
}
