import java.util.Calendar;
import java.util.Date;

/**
 * Created by ncbrown on 2/25/15.
 */
public class Message {
    private String MsgId;
    private String Last_Accessed;
    private String patientId;
    private String GivenName;
    private String FamilyName;
    private String BirthTime;
    private String providerId;
    private String GuardianNo;
    private String Relationship;
    private String FirstName;
    private String LastName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String AuthorId;
    private String AuthorTitle;
    private String AuthorFirstName;
    private String AuthorLastName;
    private String ParticipatingRole;
    private String PayerId;
    private String Name;
    private String PolicyHolder;
    private String PolicyType;
    private String Purpose;
    private String RelativeId;
    private String Relation;
    private String age;
    private String Diagnosis;
    private String Id;
    private String Substance;
    private String Reaction;
    private String Status;
    private String LabTestResultId;
    private String PatientVisitId;
    private String LabTestPerformedDate;
    private String LabTestType;
    private String TestResultValue;
    private String ReferenceRangeHigh;
    private String ReferenceRangeLow;
    private String PlanId;
    private String Activity;
    private String ScheduledDate;

    public Message(String msgId, String last_Accessed, String patientId, String givenName, String familyName, String birthTime, String providerId, String guardianNo, String relationship, String firstName, String lastName, String phone, String address, String city, String state, String zip, String authorId, String authorTitle, String authorFirstName, String authorLastName, String participatingRole, String payerId, String name, String policyHolder, String policyType, String purpose, String relativeId, String relation, String age, String diagnosis, String id, String substance, String reaction, String status, String labTestResultId, String patientVisitId, String labTestPerformedDate, String labTestType, String testResultValue, String referenceRangeHigh, String referenceRangeLow, String planId, String activity, String scheduledDate) {
        MsgId = msgId;
        Last_Accessed = last_Accessed;
        this.patientId = patientId;
        GivenName = givenName;
        FamilyName = familyName;
        BirthTime = birthTime;
        this.providerId = providerId;
        GuardianNo = guardianNo;
        Relationship = relationship;
        FirstName = firstName;
        LastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        AuthorId = authorId;
        AuthorTitle = authorTitle;
        AuthorFirstName = authorFirstName;
        AuthorLastName = authorLastName;
        ParticipatingRole = participatingRole;
        PayerId = payerId;
        Name = name;
        PolicyHolder = policyHolder;
        PolicyType = policyType;
        Purpose = purpose;
        RelativeId = relativeId;
        Relation = relation;
        this.age = age;
        Diagnosis = diagnosis;
        Id = id;
        Substance = substance;
        Reaction = reaction;
        Status = status;
        LabTestResultId = labTestResultId;
        PatientVisitId = patientVisitId;
        LabTestPerformedDate = labTestPerformedDate;
        LabTestType = labTestType;
        TestResultValue = testResultValue;
        ReferenceRangeHigh = referenceRangeHigh;
        ReferenceRangeLow = referenceRangeLow;
        PlanId = planId;
        Activity = activity;
        ScheduledDate = scheduledDate;
    }

    private String getTodayString() {
        Calendar c = Calendar.getInstance();
        return (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.YEAR);
    }

    public Patient getPatient() {
        Patient patient = new Patient(
                this.getPatientId(),
                this.getGuardianNo(),
                this.getGivenName(),
                this.getFamilyName(),
                null,
                null,
                this.getBirthTime(),
                this.getProviderId(),
                getTodayString(),
                this.getPayerId()
        );
        return patient;
    }

    public Guardian getGuardian() {
        Guardian guardian = new Guardian(
                this.getGuardianNo(),
                this.getRelationship(),
                this.getFirstName() + " " + this.getLastName(),
                this.getPhone(),
                this.getAddress(),
                this.getCity(),
                this.getState(),
                this.getZip()
        );
        return guardian;
    }

    public Author getAuthor() {
        Author author = new Author(
                this.getAuthorId(),
                this.getAuthorTitle(),
                this.getAuthorFirstName(),
                this.getAuthorLastName(),
                this.getPatientId(),
                this.getParticipatingRole()
        );
        return author;
    }

    public InsuranceCompany getInsuranceCompany() {
        InsuranceCompany insuranceCompany = new InsuranceCompany(
                this.getPayerId(),
                this.getName(),
                this.getPurpose(),
                this.getPolicyType(),
                this.getPolicyHolder()
        );
        return insuranceCompany;
    }

    public FamilyMember getFamilyMember() {
        FamilyMember familyMember = new FamilyMember(
                this.getRelation(),
                this.getAge(),
                this.getPatientId(),
                this.getRelativeId(),
                this.getDiagnosis()
        );
        return familyMember;
    }

    public Allergy getAllergy() {
        Allergy allergy = new Allergy(
                this.getId(),
                this.getSubstance()
        );
        return allergy;
    }

    public PatientAllergy getPatientAllergy() {
        PatientAllergy pallergy = new PatientAllergy(
                this.getId(),
                this.getSubstance(),
                this.getReaction(),
                this.getStatus(),
                this.getPatientId()
        );
        return pallergy;
    }

    public LabTestReport getLabTestReport() {
        LabTestReport labTestReport = new LabTestReport(
                this.getLabTestResultId(),
                this.getPatientVisitId(),
                this.getLabTestPerformedDate(),
                this.getLabTestType(),
                this.getTestResultValue(),
                this.getReferenceRangeHigh(),
                this.getReferenceRangeLow()
        );
        return labTestReport;
    }

    public PatientTest getPatientTest() {
        PatientTest patientTest = new PatientTest(
                this.getPatientId(),
                this.getLabTestResultId()
        );
        return patientTest;
    }

    public Plan getPlan() {
        Plan plan = new Plan(
                this.getActivity(),
                this.getPatientId(),
                this.getScheduledDate(),
                this.getPlanId()
        );
        return plan;
    }

    public String getMsgId() { return MsgId; }
    public String getLast_Accessed() { return Last_Accessed; }
    public String getPatientId() { return patientId; }
    public String getGivenName() { return GivenName; }
    public String getFamilyName() { return FamilyName; }
    public String getBirthTime() { return BirthTime; }
    public String getProviderId() { return providerId; }
    public String getGuardianNo() { return GuardianNo; }
    public String getRelationship() { return Relationship; }
    public String getFirstName() { return FirstName; }
    public String getLastName() { return LastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    public String getAuthorId() { return AuthorId; }
    public String getAuthorTitle() { return AuthorTitle; }
    public String getAuthorFirstName() { return AuthorFirstName; }
    public String getAuthorLastName() { return AuthorLastName; }
    public String getParticipatingRole() { return ParticipatingRole; }
    public String getPayerId() { return PayerId; }
    public String getName() { return Name; }
    public String getPolicyHolder() { return PolicyHolder; }
    public String getPolicyType() { return PolicyType; }
    public String getPurpose() { return Purpose; }
    public String getRelativeId() { return RelativeId; }
    public String getRelation() { return Relation; }
    public String getAge() { return age; }
    public String getDiagnosis() { return Diagnosis; }
    public String getId() { return Id; }
    public String getSubstance() { return Substance; }
    public String getReaction() { return Reaction; }
    public String getStatus() { return Status; }
    public String getLabTestResultId() { return LabTestResultId; }
    public String getPatientVisitId() { return PatientVisitId; }
    public String getLabTestPerformedDate() { return LabTestPerformedDate; }
    public String getLabTestType() { return LabTestType; }
    public String getTestResultValue() { return TestResultValue; }
    public String getReferenceRangeHigh() { return ReferenceRangeHigh; }
    public String getReferenceRangeLow() { return ReferenceRangeLow; }
    public String getPlanId() { return PlanId; }
    public String getActivity() { return Activity; }
    public String getScheduledDate() { return ScheduledDate; }

    public void setMsgId(String msgId) { MsgId = msgId; }
    public void setLast_Accessed(String last_Accessed) { Last_Accessed = last_Accessed; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public void setGivenName(String givenName) { GivenName = givenName; }
    public void setFamilyName(String familyName) { FamilyName = familyName; }
    public void setBirthTime(String birthTime) { BirthTime = birthTime; }
    public void setProviderId(String providerId) { this.providerId = providerId; }
    public void setGuardianNo(String guardianNo) { GuardianNo = guardianNo; }
    public void setRelationship(String relationship) { Relationship = relationship; }
    public void setFirstName(String firstName) { FirstName = firstName; }
    public void setLastName(String lastName) { LastName = lastName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZip(String zip) { this.zip = zip; }
    public void setAuthorId(String authorId) { AuthorId = authorId; }
    public void setAuthorTitle(String authorTitle) { AuthorTitle = authorTitle; }
    public void setAuthorFirstName(String authorFirstName) { AuthorFirstName = authorFirstName; }
    public void setAuthorLastName(String authorLastName) { AuthorLastName = authorLastName; }
    public void setParticipatingRole(String participatingRole) { ParticipatingRole = participatingRole; }
    public void setPayerId(String payerId) { PayerId = payerId; }
    public void setName(String name) { Name = name; }
    public void setPolicyHolder(String policyHolder) { PolicyHolder = policyHolder; }
    public void setPolicyType(String policyType) { PolicyType = policyType; }
    public void setPurpose(String purpose) { Purpose = purpose; }
    public void setRelativeId(String relativeId) { RelativeId = relativeId; }
    public void setRelation(String relation) { Relation = relation; }
    public void setAge(String age) { this.age = age; }
    public void setDiagnosis(String diagnosis) { Diagnosis = diagnosis; }
    public void setId(String id) { Id = id; }
    public void setSubstance(String substance) { Substance = substance; }
    public void setReaction(String reaction) { Reaction = reaction; }
    public void setStatus(String status) { Status = status; }
    public void setLabTestResultId(String labTestResultId) { LabTestResultId = labTestResultId; }
    public void setPatientVisitId(String patientVisitId) { PatientVisitId = patientVisitId; }
    public void setLabTestPerformedDate(String labTestPerformedDate) { LabTestPerformedDate = labTestPerformedDate; }
    public void setLabTestType(String labTestType) { LabTestType = labTestType; }
    public void setTestResultValue(String testResultValue) { TestResultValue = testResultValue; }
    public void setReferenceRangeHigh(String referenceRangeHigh) { ReferenceRangeHigh = referenceRangeHigh; }
    public void setReferenceRangeLow(String referenceRangeLow) { ReferenceRangeLow = referenceRangeLow; }
    public void setPlanId(String planId) { PlanId = planId; }
    public void setActivity(String activity) { Activity = activity; }
    public void setScheduledDate(String scheduledDate) { ScheduledDate = scheduledDate; }

}
