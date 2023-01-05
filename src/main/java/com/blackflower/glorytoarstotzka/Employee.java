
package com.blackflower.glorytoarstotzka;

import java.util.ArrayList;

/**
 *
 * @author emirs
 */
public class Employee extends Users{
    
    // Variables
    private final ArrayList<Report> responsibleReports = new ArrayList<>();
    private final ArrayList<Report> solvedReports = new ArrayList<>();
    
    
    public static final String[] EmployeeType = {
        "ENGINEER",
        "EDUCATOR",
        "ENVIRONMENT_SPECIALIST",
        "GENERAL_EXPERT"
    };
    
    private final String employeeType;
    
    
    // Constractor Starts
    public Employee(Builder builder){
        super(builder);
        this.employeeType = builder.employeeType;
    }
    
    // End Of Constractor
    
    
    // Encapsulation Starts
    public ArrayList<Report> GetResponsibleReports(){return this.responsibleReports;}
    public void AddReport(Report report){responsibleReports.add(report);}
    
    public ArrayList<Report> GetSolvedReports(){return this.solvedReports;}
    public void CoplateReport(Report report){
        solvedReports.add(report);
        
        for (int i=0; i < responsibleReports.size(); i++) {
            if (responsibleReports.get(i).GetReportID() == report.GetReportID()) {
                responsibleReports.remove(i);
                break;
            }
        }
    }
    
    public String getEmployeeType() {return this.employeeType;}
    
    // End Of Encapsulation
    
    
    // Functions Start
    
    public void ReportSelection(){                
        System.out.println("Select Report: ");
        
        for (int i = 0; i < responsibleReports.size(); i++) {
            System.out.println((i+1) + ": " + responsibleReports.get(i).GetReporterCitizen().GetCitizenFirstName() + " " + responsibleReports.get(i).GetReporterCitizen().GetCitizenLastName());
        }
    }
    public void SolveReport(int reportNum, String respond){
        Report report = responsibleReports.get(reportNum - 1);
        report.SetRespond(respond);
        CoplateReport(report);
    }
    
    
    public void ListResponsibleReports(){
        for (Report responsibleReport : responsibleReports) {
            responsibleReport.WriteReport();
        }
    }
    
    public void ListSolvedReports(){
        for (Report solvedReport : solvedReports) {
            solvedReport.WriteReport();
        }
    }
    
    public void ListAllReports(){
        ListResponsibleReports();
        ListSolvedReports();
    }
    
    public int ResponsibleReportCount(){return responsibleReports.size();}
    
    // End Of Functions
    
    
    // Builder Starts
    public static class Builder extends Users.Builder{
        private String employeeType;

        protected Builder() {}

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
        
        public Builder setEmployeeType(String employeeType) {
            this.employeeType = employeeType;
            return this;
        }
        
        @Override
        public Employee build(){
            Employee employee = new Employee(this);
            return employee;
        }
    }
    
    //End Of Builder
}
