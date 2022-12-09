package com.blackflower.glorytoarstotzka;

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
    
    public enum ReportType{
        EDUCATION,
        ELECTRICAL,
        WATER_SUPPLY,
        OTHER,
    }
    private final ReportType reportType;
    
    
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
    }
    
    // End Of Constractor
    
    
    // Encapsulation Starts
    public int GetReportID(){return reportID;}  
    
    public Citizen GetReporterCitizen(){return reporterCitizen;}
    
    public Employee GetResponsibleEmployee(){return responsibleEmployee;}
    public void SetResponsibleEmployee(Employee responsibleEmployee){this.responsibleEmployee = responsibleEmployee;}
    
    public String GetReportDate(){return reportDay + "." + reportMounth + "." + reportYear;}
    
    public String GetReportSubject(){return reportSubject;}
    
    public ReportType GetReportType(){return reportType;}
    
    // End Of Encapsulation
    
    
    // Builder Starts
    public static class Builder{
        int reportID;
        Citizen reporterCitizen;
        private Employee responsibleEmployee;

        int reportDay;
        int reportMounth;
        int reportYear;

        String reportSubject;
        ReportType reportType;

        public Builder() {}
        
        public Builder(int reportID, Citizen reporterCitizen, int reportDay, int reportMounth, int reportYear, String reportSubject, ReportType type){
            this.reportID = reportID;
            this.reporterCitizen = reporterCitizen;
            this.reportDay = reportDay;
            this.reportMounth = reportMounth;
            this.reportYear = reportYear;
            this.reportSubject = reportSubject;
            this.reportType = type;
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
}
