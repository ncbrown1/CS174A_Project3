import java.util.Date;

/**
 * Created by ncbrown on 2/26/15.
 */
public class Plan {
    private String Activity;
    private String PatientID;
    private Date ActivityDate;

    public Plan(String activity, String patientID, Date activityDate) {
        Activity = activity;
        PatientID = patientID;
        ActivityDate = activityDate;
    }

    public String getActivity() { return Activity; }
    public void setActivity(String activity) { Activity = activity; }
    public String getPatientID() { return PatientID; }
    public void setPatientID(String patientID) { PatientID = patientID; }
    public Date getActivityDate() { return ActivityDate; }
    public void setActivityDate(Date activityDate) { ActivityDate = activityDate; }
}
