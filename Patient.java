import java.sql.Date;

/**
 * Created by ncbrown on 2/25/15.
 */
public class Patient {
    private String patientid;
    private String patientrole;
    private String givenname;
    private String familyname;
    private String suffix;
    private String gender;
    private Date birthtime;
    private String providerId;
    private String payerId;
    private Date xmlCreationdate;

    public Patient(String ID, String patientrole, String givenname, String familyname, String suffix, String gender, String birthtime, String providerid, String xmlCreationDate, String payerId)
    {
        this.patientid = ID;
        this.patientrole = patientrole;
        this.givenname = givenname;
        this.familyname = familyname;
        this.suffix = suffix;
        this.gender = gender;
        this.birthtime = Str2Date.convert(birthtime);
        this.providerId = providerid;
        this.xmlCreationdate = Str2Date.convert(xmlCreationDate);
        this.payerId = payerId;
    }

    public String insertStatement() {
        if(patientid == null || patientrole == null) return "";
        String pid = getPatientid(), gn = getGivenname(), fn = getFamilyname(), suf = getSuffix(),
                gen = getGender(), bt = getBirthtime(), prid = getProviderId(),
                xcd = getXmlCreationdate(), pr = getPatientrole(), pay = getPayerId();
        return "INSERT INTO Patient (PatientID,GivenName,FamilyName,Suffix,Gender,Birthtime,ProviderID,Creation,PatientRole,PayerID)" +
                "VALUES (" + pid + "," + gn + "," + fn + "," + suf + "," + gen + "," +
                bt + "," + prid + "," + xcd + "," + pr + "," + pay + ") " +
                "ON DUPLICATE KEY UPDATE GivenName=" + pid + ",FamilyName=" + fn + ",Suffix=" + suf + "," +
                "Gender=" + gen + ",Birthtime=" + bt + ",ProviderID=" + prid + ",Creation=" + xcd + "," +
                "PatientRole=" + pr + ",PayerID=" + pay + ";";
    }


    public String getPatientid() { return patientid == null ? "NULL" : "\"" + patientid + "\""; }
    public String getPatientrole() { return patientrole == null ? "NULL" : "\"" + patientrole + "\""; }
    public String getGivenname() { return givenname == null ? "NULL" : "\"" + givenname + "\""; }
    public String getFamilyname() { return familyname == null ? "NULL" : "\"" + familyname + "\""; }
    public String getSuffix() { return suffix == null ? "NULL" : "\"" + suffix + "\""; }
    public String getGender() { return gender == null ? "NULL" : "\"" + gender + "\""; }
    public String getBirthtime() { return birthtime == null ? "NULL" : "\"" + birthtime.toString() + "\""; }
    public String getProviderId() { return providerId == null ? "NULL" : "\"" + providerId + "\""; }
    public String getPayerId() { return payerId == null ? "NULL" : "\"" + payerId + "\""; }
    public String getXmlCreationdate() { return xmlCreationdate == null ? "NULL" : "\"" + xmlCreationdate.toString() + "\""; }

    public void setPatientid(String patientid) { this.patientid = patientid;}
    public void setPatientrole(String patientrole) { this.patientrole = patientrole; }
    public void setGivenname(String givenname) { this.givenname = givenname; }
    public void setFamilyname(String familyname) { this.familyname = familyname; }
    public void setSuffix(String suffix) { this.suffix = suffix; }
    public void setGender(String gender) { this.gender = gender; }
    public void setBirthtime(String birthtime) { this.birthtime = Str2Date.convert(birthtime); }
    public void setProviderId(String providerId) { this.providerId = providerId; }
    public void setXmlCreationdate(String xmlCreationdate) { this.xmlCreationdate = Str2Date.convert(xmlCreationdate); }
}
