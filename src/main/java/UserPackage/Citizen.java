package UserPackage;

import ApplicationPackage.Database;
import ReportPackage.Report;
import ReportPackage.ReportMatcher;
import TaxPackage.Tax;
import java.util.ArrayList;

/**
 *
 * @author emirs
 */
public class Citizen extends Users{
    
    // Variables
    private final ArrayList<Report> createdReports = new ArrayList<>();
    private final ArrayList<Report> solvedReports = new ArrayList<>();
    private final ArrayList<Tax> paidTaxes = new ArrayList<>();
    
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
    
    public void CreateReport(String reportSubject, String reportType){
        if (reportSubject.isEmpty() || reportType == null) {
            System.out.println("Report subject and report type CANNOT be Empty");
            return;
        }
        
        Report createdReport = ReportMatcher.CreateReport(reportSubject, reportType, this);
        AddReport(createdReport);
    }
    
    public void ListTaxes(){
        Database.ListAllTaxes(paidTaxes);
    }
    
    public void PayTax(){
        Database.ListUnpaidTaxes(paidTaxes);
    }
    
    // End Of Functions
    
    
    // Builder Starts
    public static class Builder extends Users.Builder{
        
        public Builder() {}

        public Builder(long citizenID, String citizenFirstName, String citizenLastName) {
            super(citizenID, citizenFirstName, citizenLastName);
        }
        
        @Override
        public Builder username(String username){
           super.username(username);
            return this;
        }
        
        @Override
        public Builder password(String password){
           super.password(password);
            return this;
        }
        
        @Override
        public Builder emailAddress(String emailAddress){
           super.emailAddress(emailAddress);
            return this;
        }
        
        @Override
        public Citizen build(){
            Citizen citizen = new Citizen(this);
            return citizen;
        }
    }
    
    // End Of Builder
}
