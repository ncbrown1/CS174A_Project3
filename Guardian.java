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
    public String getGivenName() { return GivenName; }
    public String getFamilyName() { return FamilyName; }
    public String getPhone() { return Phone; }
    public String getAddress() { return Address; }
    public String getCity() { return City; }
    public String getState() { return State; }
    public String getZip() { return Zip; }

    public void setGuardianNo(String guardianNo) { GuardianNo = guardianNo; }
    public void setGivenName(String givenName) { GivenName = givenName; }
    public void setFamilyName(String familyName) { FamilyName = familyName; }
    public void setPhone(String phone) { Phone = phone; }
    public void setAddress(String address) { Address = address; }
    public void setCity(String city) { City = city; }
    public void setState(String state) { State = state; }
    public void setZip(String zip) { Zip = zip; }
}
