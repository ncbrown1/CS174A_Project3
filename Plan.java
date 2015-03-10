import java.util.Date;

/**
 * Created by ncbrown on 2/26/15.
 */
public class Plan {
    private String Activity;
    private String PatientID;
    private Date ActivityDate;
    private String PlanID;

    public Plan(String activity, String patientID, String activityDate, String planID) {
        Activity = activity;
        PatientID = patientID;
        ActivityDate = Str2Date.convert(activityDate);
        PlanID = planID;
    }

    public String insertStatement() {
        if(PlanID == null) return "";
        String a = getActivity(), pid = getPatientID(), ad = getActivityDate(), p = getPlanID();
        return "INSERT INTO Plan(PlanID,Activity,PatientID,ActivityDate) " +
                "VALUES("+p+","+a+","+pid+","+ad+") " +
                "ON DUPLICATE KEY UPDATE Activity="+a+",PatientID="+pid+",ActivityDate="+ad+";";
    }

    public String getActivity() { return Activity == null ? "NULL" : "\"" + Activity + "\""; }
    public String getPatientID() { return PatientID == null ? "NULL" : "\"" + PatientID + "\""; }
    public String getActivityDate() { return ActivityDate == null ? "NULL" : "\"" + ActivityDate + "\""; }
    public String getPlanID() { return PlanID == null ? "NULL" : "\"" + PlanID + "\""; }

    public void setActivity(String activity) { Activity = activity; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public void setActivityDate(String activityDate) { ActivityDate = Str2Date.convert(activityDate); }
    public void setPlanID(String planID) { PlanID = planID; }
}
