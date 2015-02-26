/**
 * Created by ncbrown on 2/26/15.
 */
public class InsuranceCompany {
    private String PayerID;
    private String Name;
    private String Purpose;
    private String PolicyType;

    public InsuranceCompany(String payerID, String name, String purpose, String policyType) {
        PayerID = payerID;
        Name = name;
        Purpose = purpose;
        PolicyType = policyType;
    }

    public String getPayerID() { return PayerID; }
    public void setPayerID(String payerID) { PayerID = payerID; }
    public String getName() { return Name; }
    public void setName(String name) { Name = name; }
    public String getPurpose() { return Purpose; }
    public void setPurpose(String purpose) { Purpose = purpose; }
    public String getPolicyType() { return PolicyType; }
    public void setPolicyType(String policyType) { PolicyType = policyType; }
}
