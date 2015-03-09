import java.util.Date;

/**
 * Created by ncbrown on 2/26/15.
 */
public class Plan {
    private String Activity;
    private String PatientID;
    private String ActivityDate;
    private String PlanID;

    public Plan(String activity, String patientID, String activityDate, String planID) {
        Activity = activity;
        PatientID = patientID;
        ActivityDate = activityDate;
        PlanID = planID;
    }

    public String getActivity() { return Activity; }
    public String getPatientID() { return PatientID; }
    public String getActivityDate() { return ActivityDate; }
    public String getPlanID() { return PlanID; }

    public void setActivity(String activity) { Activity = activity; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public void setActivityDate(String activityDate) { ActivityDate = activityDate; }
    public void setPlanID(String planID) { PlanID = planID; }
}
