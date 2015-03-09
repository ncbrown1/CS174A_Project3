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
    private String birthtime;
    private String providerId;
    private String xmlCreationdate;

    public Patient(String ID, String patientrole, String givenname, String familyname, String suffix, String gender, String birthtime, String providerid, String xmlCreationDate)
    {
        this.patientid = ID;
        this.patientrole = patientrole;
        this.givenname = givenname;
        this.familyname = familyname;
        this.suffix = suffix;
        this.gender = gender;
        this.birthtime = birthtime;
        this.providerId = providerid;
        this.xmlCreationdate = xmlCreationDate;
    }

    public String getPatientid() { return patientid; }
    public String getPatientrole() { return patientrole; }
    public String getGivenname() { return givenname; }
    public String getFamilyname() { return familyname; }
    public String getSuffix() { return suffix; }
    public String getGender() { return gender; }
    public String getBirthtime() { return birthtime; }
    public String getProviderId() { return providerId; }
    public String getXmlCreationdate() { return xmlCreationdate; }

    public void setPatientid(String patientid) { this.patientid = patientid;}
    public void setPatientrole(String patientrole) { this.patientrole = patientrole; }
    public void setGivenname(String givenname) { this.givenname = givenname; }
    public void setFamilyname(String familyname) { this.familyname = familyname; }
    public void setSuffix(String suffix) { this.suffix = suffix; }
    public void setGender(String gender) { this.gender = gender; }
    public void setBirthtime(String birthtime) { this.birthtime = birthtime; }
    public void setProviderId(String providerId) { this.providerId = providerId; }
    public void setXmlCreationdate(String xmlCreationdate) { this.xmlCreationdate = xmlCreationdate; }
}
