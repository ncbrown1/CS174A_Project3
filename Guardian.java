/**
 * Created by ncbrown on 2/26/15.
 */
public class Guardian {
    private String GuardianNo;
    private String GivenName;
    private String FamilyName;
    private String Phone;
    private String Address;
    private String City;
    private String State;
    private String Zip;

    public Guardian(String guardianNo, String givenName, String familyName, String phone, String address, String city, String state, String zip) {
        GuardianNo = guardianNo;
        GivenName = givenName;
        FamilyName = familyName;
        Phone = phone;
        Address = address;
        City = city;
        State = state;
        Zip = zip;
    }

    public String getGuardianNo() { return GuardianNo; }
    public void setGuardianNo(String guardianNo) { GuardianNo = guardianNo; }
    public String getGivenName() { return GivenName; }
    public void setGivenName(String givenName) { GivenName = givenName; }
    public String getFamilyName() { return FamilyName; }
    public void setFamilyName(String familyName) { FamilyName = familyName; }
    public String getPhone() { return Phone; }
    public void setPhone(String phone) { Phone = phone; }
    public String getAddress() { return Address; }
    public void setAddress(String address) { Address = address; }
    public String getCity() { return City; }
    public void setCity(String city) { City = city; }
    public String getState() { return State; }
    public void setState(String state) { State = state; }
    public String getZip() { return Zip; }
    public void setZip(String zip) { Zip = zip; }
}
