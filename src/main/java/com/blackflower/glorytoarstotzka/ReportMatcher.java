package com.blackflower.glorytoarstotzka;

import java.time.LocalDate;  

/**
 *
 * @author emirs
 */
public class ReportMatcher {
    
    // Variables
    private static int reportID = 1000000000;
    
    
    // Functions Start
    public static Report CreateReport(String reportSubject, Report.ReportType reportType, Citizen reporter){
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        
        Report report = new Report.Builder(GenerateReportID(), reporter, 
                day, month, year, reportSubject, reportType)
                .responsibleEmployee(MatchReport(reportType))
                .build();
        
        Database.AddReport(report);
        return report;
    }
    
    private static int GenerateReportID(){
        reportID++;
        return reportID;
    }
    
    public static Employee MatchReport(Report.ReportType reportType){
        Employee responsibleEmployee = null;
        switch (reportType) {
            case EDUCATION -> responsibleEmployee = Database.findMostAvailableEmployee(Employee.EmployeeType.EDUCATOR);
            case ELECTRICAL -> responsibleEmployee = Database.findMostAvailableEmployee(Employee.EmployeeType.ENGINEER);
            case WATER_SUPPLY -> responsibleEmployee = Database.findMostAvailableEmployee(Employee.EmployeeType.ENVIRONMENT_SPECIALIST);
            case OTHER -> responsibleEmployee = Database.findMostAvailableEmployee(Employee.EmployeeType.GENERAL_EXPERT);
        }
        return responsibleEmployee;
    }
    
    //  End Of The Functions
}
