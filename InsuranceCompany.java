/**
 * Created by ncbrown on 2/26/15.
 */
public class InsuranceCompany {
    private String PayerID;
    private String Name;
    private String Purpose;
    private String PolicyType;
    private String PolicyHolder;

    public InsuranceCompany(String payerID, String name, String purpose, String policyType, String policyHolder) {
        PayerID = payerID;
        Name = name;
        Purpose = purpose;
        PolicyType = policyType;
        PolicyHolder = policyHolder;
    }

    public String insertStatement() {
        if(PayerID == null) return "";
        String pid = getPayerID(), n = getName(), prp = getPurpose(), ptyp = getPolicyType(), ph = getPolicyHolder();
        return "INSERT INTO InsuranceCompany(PayerID,Name,Purpose,PolicyType)" +
                "VALUES("+pid+","+n+","+prp+","+ptyp+") " +
                "ON DUPLICATE KEY UPDATE PayerID="+pid+",Name="+n+",Purpose="+prp+",PolicyType="+ptyp+";";
    }

    public String getPayerID() { return PayerID == null ? "NULL" : "\"" + PayerID + "\""; }
    public String getName() { return Name == null ? "NULL" : "\"" + Name + "\""; }
    public String getPurpose() { return Purpose == null ? "NULL" : "\"" + Purpose + "\""; }
    public String getPolicyType() { return PolicyType == null ? "NULL" : "\"" + PolicyType + "\""; }
    public String getPolicyHolder() { return PolicyHolder == null ? "NULL" : "\"" + PolicyHolder + "\""; }

    public void setPayerID(String payerID) { PayerID = payerID; }
    public void setName(String name) { Name = name; }
    public void setPurpose(String purpose) { Purpose = purpose; }
    public void setPolicyType(String policyType) { PolicyType = policyType; }
    public void setPolicyHolder(String policyHolder) { PolicyHolder = policyHolder; }
}
