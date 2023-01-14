package ReportPackage;

import ApplicationPackage.Database;
import UserPackage.Employee;
import UserPackage.Citizen;
import java.time.LocalDate;  

/**
 *
 * @author emirs
 */
public class ReportMatcher {
    
    // Variables
    private static int reportID = 1000000000;
    
    
    // Functions Start
    public static Report CreateReport(String reportSubject, String reportType, Citizen reporter){
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        
        Employee respondibleEmployee = MatchReport(reportType);
        
        Report report = new Report.Builder(GenerateReportID(), reporter, 
                day, month, year, reportSubject, reportType)
                .responsibleEmployee(respondibleEmployee)
                .build();
        
        Database.AddReport(report);
        respondibleEmployee.AddReport(report);
        return report;
    }
    
    private static int GenerateReportID(){
        reportID++;
        return reportID;
    }
    
    public static Employee MatchReport(String reportType){
        Employee responsibleEmployee = null;
        switch (reportType) {
            case "ELECTRICAL" -> responsibleEmployee = Database.findMostAvailableEmployee(Employee.EmployeeType[0]);
            case "EDUCATION" -> responsibleEmployee = Database.findMostAvailableEmployee(Employee.EmployeeType[1]);
            case "WATER_SUPPLY" -> responsibleEmployee = Database.findMostAvailableEmployee(Employee.EmployeeType[2]);
            case "OTHER" -> responsibleEmployee = Database.findMostAvailableEmployee(Employee.EmployeeType[3]);
        }    
        return responsibleEmployee;
    }
    
    //  End Of The Functions
}
