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

    public String insertStatement() {
        if(GuardianNo == null) return "";
        String gno = getGuardianNo(), gn = getGivenName(), fn = getFamilyName(), ph = getPhone(),
                add = getAddress(), c = getCity(), s = getState(), z = getZip();
        return "INSERT INTO Guardian(GuardianNo,GivenName,FamilyName,Phone,Address,City,State,Zip)" +
                "VALUES ("+gno+","+gn+","+fn+","+ph+","+add+","+c+","+s+","+z+") " +
                "ON DUPLICATE KEY UPDATE GivenName="+gn+",FamilyName="+fn+",Phone="+ph+",Address="+add+
                ",City="+c+",State="+s+",Zip="+z+";";
    }

    public String getGuardianNo() { return GuardianNo == null ? "NULL" : "\"" + GuardianNo + "\""; }
    public String getGivenName() { return GivenName == null ? "NULL" : "\"" + GivenName + "\""; }
    public String getFamilyName() { return FamilyName == null ? "NULL" : "\"" + FamilyName + "\""; }
    public String getPhone() { return Phone == null ? "NULL" : "\"" + Phone + "\""; }
    public String getAddress() { return Address == null ? "NULL" : "\"" + Address + "\""; }
    public String getCity() { return City == null ? "NULL" : "\"" + City + "\""; }
    public String getState() { return State == null ? "NULL" : "\"" + State + "\""; }
    public String getZip() { return Zip == null ? "NULL" : "\"" + Zip + "\""; }

    public void setGuardianNo(String guardianNo) { GuardianNo = guardianNo; }
    public void setGivenName(String givenName) { GivenName = givenName; }
    public void setFamilyName(String familyName) { FamilyName = familyName; }
    public void setPhone(String phone) { Phone = phone; }
    public void setAddress(String address) { Address = address; }
    public void setCity(String city) { City = city; }
    public void setState(String state) { State = state; }
    public void setZip(String zip) { Zip = zip; }
}
