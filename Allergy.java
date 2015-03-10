/**
 * Created by ncbrown on 2/26/15.
 */
public class Allergy {
    private String AllergyID;
    private String substance_name;

    public Allergy(String allergyID, String substance_name) {
        AllergyID = allergyID;
        this.substance_name = substance_name;
    }

    public String insertStatement() {
        String sn = getSubstanceName(), aid = getAllergyID();
        return "INSERT INTO Allergy(AllergyID,substance_name)" +
                "VALUES ("+sn+","+aid+") " +
                "ON DUPLICATE KEY UPDATE substance_name="+sn+";";
    }

    public String getSubstanceName() { return substance_name == null ? "NULL" : "\"" + substance_name + "\""; }
    public String getAllergyID() { return AllergyID == null ? "NULL" : "\"" + AllergyID + "\""; }

    public void setSubstanceName(String substance_name) { this.substance_name = substance_name; }
    public void setAllergyID(String allergyID) { AllergyID = allergyID; }
}
