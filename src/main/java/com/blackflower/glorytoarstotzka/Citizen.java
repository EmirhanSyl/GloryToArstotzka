package com.blackflower.glorytoarstotzka;

import java.util.ArrayList;

/**
 *
 * @author emirs
 */
public class Citizen extends Users{
    
    // Variables
    private final ArrayList<Report> createdReports = new ArrayList<>();
    private final ArrayList<Report> solvedReports = new ArrayList<>();
    
    
    // Constractor Starts
    public Citizen(Builder builder) {
        super(builder);
    }

    // End Of Constractor
    
    
    // Encapsulation Starts
    public ArrayList<Report> GetCreatedReports(){return createdReports;}
    public void AddReport(Report report){createdReports.add(report);}
    
    public ArrayList<Report> GetSolvedReports(){return this.solvedReports;}
    public void ComplateReport(Report report){
        solvedReports.add(report);
        
        for (int i=0; i < createdReports.size(); i++) {
            if (createdReports.get(i).GetReportID() == report.GetReportID()) {
                createdReports.get(i).SetReportStatue(Report.ReportStatus.COMPLATED);
                createdReports.remove(i);
                break;
            }
        }
    }

    // End Of Encapsulation
    
    
    // Functions
    public void ListCreatedReports(){
        for (Report createdReport : createdReports) {
            createdReport.WriteReport();
        }
    }
    
    public void ListSolvedReports(){
        for (Report solvedReport : solvedReports) {
            solvedReport.WriteReport();
        }
    }
    
    public void ListAllReports(){
        ListCreatedReports();
        ListSolvedReports();
    }
    
    public void CreateReport(String reportSubject, Report.ReportType reportType){
        if (reportSubject.isEmpty() || reportType == null) {
            System.out.println("Report subject and report type CANNOT be Empty");
            return;
        }
        
        Report createdReport = ReportMatcher.CreateReport(reportSubject, reportType, this);
        AddReport(createdReport);
    }
    
    // End Of Functions
    
    
    // Builder Starts
    public static class Builder extends Users.Builder{
        
        public Builder() {}
        
        @Override
        public Citizen build(){
            Citizen citizen = new Citizen(this);
            return citizen;
        }
    }
    
    // End Of Builder
}
