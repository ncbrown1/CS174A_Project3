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

    public String insertStatement() {
        if(FamilyMemberID == null) return "";
        String r = getRelationship(), a = getAge(), pid = getPatientID(), fmid = getFamilyMemberID(), d = getDiagnosis();
        return "INSERT INTO FamilyHistory(Relationship,Age,PatientID,FamilyMemberID,Diagnosis)" +
                "VALUES ("+r+","+a+","+pid+","+fmid+","+d+") " +
                "ON DUPLICATE KEY UPDATE Relationship="+r+",Age="+a+",Diagnosis="+d+";";
    }

    public String getRelationship() { return Relationship == null ? "NULL" : "\"" + Relationship + "\""; }
    public String getAge() { return Age == null ? "NULL" : "\"" + Age + "\""; }
    public String getPatientID() { return PatientID == null ? "NULL" : "\"" + PatientID + "\""; }
    public String getFamilyMemberID() { return FamilyMemberID == null ? "NULL" : "\"" + FamilyMemberID + "\""; }
    public String getDiagnosis() { return Diagnosis == null ? "NULL" : "\"" + Diagnosis + "\""; }

    public void setRelationship(String relationship) { Relationship = relationship; }
    public void setAge(String age) { Age = age; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public void setFamilyMemberID(String familyMemberID) { FamilyMemberID = familyMemberID; }
    public void setDiagnosis(String diagnosis) { Diagnosis = diagnosis; }
}
