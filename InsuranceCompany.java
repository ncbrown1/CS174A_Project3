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

    public String getPayerID() { return PayerID; }
    public String getName() { return Name; }
    public String getPurpose() { return Purpose; }
    public String getPolicyType() { return PolicyType; }
    public String getPolicyHolder() { return PolicyHolder; }

    public void setPayerID(String payerID) { PayerID = payerID; }
    public void setName(String name) { Name = name; }
    public void setPurpose(String purpose) { Purpose = purpose; }
    public void setPolicyType(String policyType) { PolicyType = policyType; }
    public void setPolicyHolder(String policyHolder) { PolicyHolder = policyHolder; }
}
