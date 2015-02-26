import java.util.Date;

/**
 * Created by ncbrown on 2/25/15.
 */
public class Message {
    private String MsgId;
    private Date Last_Accessed;
    private String patientId;
    private String GivenName;
    private String FamilyName;
    private Date BirthTime;
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
    private Date LabTestPerformedDate;
    private String LabTestType;
    private String TestResultValue;
    private String ReferenceRangeHigh;
    private String ReferenceRangeLow;
    private String PlanId;
    private String Activity;
    private Date ScheduledDate;

    public Message(String msgId, Date last_Accessed, String patientId, String givenName, String familyName, Date birthTime, String providerId, String guardianNo, String relationship, String firstName, String lastName, String phone, String address, String city, String state, String zip, String authorId, String authorTitle, String authorFirstName, String authorLastName, String participatingRole, String payerId, String name, String policyHolder, String policyType, String purpose, String relativeId, String relation, String age, String diagnosis, String id, String substance, String reaction, String status, String labTestResultId, String patientVisitId, Date labTestPerformedDate, String labTestType, String testResultValue, String referenceRangeHigh, String referenceRangeLow, String planId, String activity, Date scheduledDate) {
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

    public String getMsgId() { return MsgId; }
    public void setMsgId(String msgId) { MsgId = msgId; }
    public Date getLast_Accessed() { return Last_Accessed; }
    public void setLast_Accessed(Date last_Accessed) { Last_Accessed = last_Accessed; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getGivenName() { return GivenName; }
    public void setGivenName(String givenName) { GivenName = givenName; }
    public String getFamilyName() { return FamilyName; }
    public void setFamilyName(String familyName) { FamilyName = familyName; }
    public Date getBirthTime() { return BirthTime; }
    public void setBirthTime(Date birthTime) { BirthTime = birthTime; }
    public String getProviderId() { return providerId; }
    public void setProviderId(String providerId) { this.providerId = providerId; }
    public String getGuardianNo() { return GuardianNo; }
    public void setGuardianNo(String guardianNo) { GuardianNo = guardianNo; }
    public String getRelationship() { return Relationship; }
    public void setRelationship(String relationship) { Relationship = relationship; }
    public String getFirstName() { return FirstName; }
    public void setFirstName(String firstName) { FirstName = firstName; }
    public String getLastName() { return LastName; }
    public void setLastName(String lastName) { LastName = lastName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
    public String getAuthorId() { return AuthorId; }
    public void setAuthorId(String authorId) { AuthorId = authorId; }
    public String getAuthorTitle() { return AuthorTitle; }
    public void setAuthorTitle(String authorTitle) { AuthorTitle = authorTitle; }
    public String getAuthorFirstName() { return AuthorFirstName; }
    public void setAuthorFirstName(String authorFirstName) { AuthorFirstName = authorFirstName; }
    public String getAuthorLastName() { return AuthorLastName; }
    public void setAuthorLastName(String authorLastName) { AuthorLastName = authorLastName; }
    public String getParticipatingRole() { return ParticipatingRole; }
    public void setParticipatingRole(String participatingRole) { ParticipatingRole = participatingRole; }
    public String getPayerId() { return PayerId; }
    public void setPayerId(String payerId) { PayerId = payerId; }
    public String getName() { return Name; }
    public void setName(String name) { Name = name; }
    public String getPolicyHolder() { return PolicyHolder; }
    public void setPolicyHolder(String policyHolder) { PolicyHolder = policyHolder; }
    public String getPolicyType() { return PolicyType; }
    public void setPolicyType(String policyType) { PolicyType = policyType; }
    public String getPurpose() { return Purpose; }
    public void setPurpose(String purpose) { Purpose = purpose; }
    public String getRelativeId() { return RelativeId; }
    public void setRelativeId(String relativeId) { RelativeId = relativeId; }
    public String getRelation() { return Relation; }
    public void setRelation(String relation) { Relation = relation; }
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    public String getDiagnosis() { return Diagnosis; }
    public void setDiagnosis(String diagnosis) { Diagnosis = diagnosis; }
    public String getId() { return Id; }
    public void setId(String id) { Id = id; }
    public String getSubstance() { return Substance; }
    public void setSubstance(String substance) { Substance = substance; }
    public String getReaction() { return Reaction; }
    public void setReaction(String reaction) { Reaction = reaction; }
    public String getStatus() { return Status; }
    public void setStatus(String status) { Status = status; }
    public String getLabTestResultId() { return LabTestResultId; }
    public void setLabTestResultId(String labTestResultId) { LabTestResultId = labTestResultId; }
    public String getPatientVisitId() { return PatientVisitId; }
    public void setPatientVisitId(String patientVisitId) { PatientVisitId = patientVisitId; }
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
    public String getPlanId() { return PlanId; }
    public void setPlanId(String planId) { PlanId = planId; }
    public String getActivity() { return Activity; }
    public void setActivity(String activity) { Activity = activity; }
    public Date getScheduledDate() { return ScheduledDate; }
    public void setScheduledDate(Date scheduledDate) { ScheduledDate = scheduledDate; }
}
