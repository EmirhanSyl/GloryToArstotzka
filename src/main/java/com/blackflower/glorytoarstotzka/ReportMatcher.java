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
        
        return report;
    }
    
    private static int GenerateReportID(){
        reportID++;
        return reportID;
    }
    
    public static Employee MatchReport(Report.ReportType reportType){
        switch (reportType) {
            case EDUCATION:
                break;
            case ELECTRICAL:
                break;
            case WATER_SUPPLY:
                break;
            case OTHER:
                break;
        }
        return null; // change this!
    }
    
    //  End Of The Functions
}
