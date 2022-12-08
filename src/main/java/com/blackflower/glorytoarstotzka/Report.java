package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Report {
    private int reportID;
    
    private Citizen reporterCitizen;
    private Employee responsibleEmployee;
    
    private int reportDay;
    private int reportMounth;
    private int reportYear;
    
    private String reportSubject;
    
    enum ReportType{
        EDUCATION,
        ELECTRICAL,
        WATER_SUPPLY,
        OTHER,
    }
    private ReportType reportType;
    
    public int GetReportID(){return reportID;}
    public void SetReportID(int reportID){this.reportID = reportID;}
    
    public Citizen GetReporterCitizen(){return reporterCitizen;}
    public void SetReporterCitizen(Citizen reporterCitizen){this.reporterCitizen = reporterCitizen;}
    
    public Employee GetResponsibleEmployee(){return responsibleEmployee;}
    public void SetResponsibleEmployee(Employee responsibleEmployee){this.responsibleEmployee = responsibleEmployee;}
    
    public String GetReportDate(){return reportDay + "." + reportMounth + "." + reportYear;}
    public void SetReportDate(int reportDay, int reportMounth, int reportYear){
        this.reportDay = reportDay;
        this.reportMounth = reportMounth;
        this.reportYear = reportYear;
    }
    
    public String GetReportSubject(){return reportSubject;}
    
    public ReportType GetReportType(){return reportType;}
    public void SetReportType(ReportType type){this.reportType = type;}
}
