package ReportPackage;

import UserPackage.Employee;
import UserPackage.Citizen;

/**
 *
 * @author emirs
 */
public class Report {
    
    // Variables
    private final int reportID;
    
    private final Citizen reporterCitizen;
    private Employee responsibleEmployee;
    
    private final int reportDay;
    private final int reportMounth;
    private final int reportYear;
    
    private final String reportSubject;
    private String respond;
    
    public final static String[] ReportType = {
        "EDUCATION",
        "ELECTRICAL",
        "WATER_SUPPLY",
        "OTHER"
    };
    private final String reportType;
    
    public enum ReportStatus{
        IN_PROGRESS,
        COMPLATED,
    }
    private ReportStatus reportStatus;
    
    
    // Constractor Starts
    public Report(Builder builder){
        this.reportID = builder.reportID;
        this.reporterCitizen = builder.reporterCitizen;
        this.responsibleEmployee = builder.responsibleEmployee;
        this.reportDay = builder.reportDay;
        this.reportMounth = builder.reportMounth;
        this.reportYear = builder.reportYear;
        this.reportSubject = builder.reportSubject;
        this.reportType = builder.reportType;
        this.reportStatus = builder.reportStatus;
    }
    
    // End Of Constractor
    
    
    // Encapsulation Starts
    public int GetReportID(){return reportID;}  
    
    public Citizen GetReporterCitizen(){return reporterCitizen;}
    
    public Employee GetResponsibleEmployee(){return responsibleEmployee;}
    public void SetResponsibleEmployee(Employee responsibleEmployee){this.responsibleEmployee = responsibleEmployee;}
    
    public String GetReportDate(){return reportDay + "." + reportMounth + "." + reportYear;}
    
    public String GetReportSubject(){return reportSubject;}
    
    public String GetReportType(){return reportType;}
    
    public ReportStatus GetReportStatus(){return reportStatus;}
    public void SetReportStatue(ReportStatus status){this.reportStatus = status;}
    
    public String GetRespond(){return respond;}
    public void SetRespond(String response){this.respond = response;}
    
    // End Of Encapsulation
    
    
    // Functions Start
    public void WriteReport(){
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Report Title: " + reportType + " ISSUE");
        System.out.println("Reporter: " + reporterCitizen.GetCitizenFirstName() + " " + reporterCitizen.GetCitizenLastName());
        System.out.println("Report ID: " + reportID);
        System.out.println("Report Date: " + GetReportDate());
        System.out.println("Relevant Expert: " + responsibleEmployee.GetCitizenFirstName() + " " + responsibleEmployee.GetCitizenLastName());
        System.out.println("Report Status: " + reportStatus.toString());
        System.out.println("Report Subject: " + reportSubject);
        System.out.println("Report Respond: " + respond);
        System.out.println("----------------------------------------");
        System.out.println();
    }
    
    // End Of Functions
    
    
    // Builder Starts
    public static class Builder{
        int reportID;
        Citizen reporterCitizen;
        private Employee responsibleEmployee;

        int reportDay;
        int reportMounth;
        int reportYear;

        String reportSubject;
        String reportType;
        ReportStatus reportStatus;

        public Builder() {}
        
        public Builder(int reportID, Citizen reporterCitizen, int reportDay, int reportMounth, int reportYear, String reportSubject, String type){
            this.reportID = reportID;
            this.reporterCitizen = reporterCitizen;
            this.reportDay = reportDay;
            this.reportMounth = reportMounth;
            this.reportYear = reportYear;
            this.reportSubject = reportSubject;
            this.reportType = type;
            this.reportStatus = ReportStatus.IN_PROGRESS;
        }
        
        public Builder responsibleEmployee(Employee responsibleEmployee){
            this.responsibleEmployee = responsibleEmployee;
            return this;
        }
        
        public Report build(){
            Report report = new Report(this);
            return report;
        }
    }
    
    // End Of Builder
}
