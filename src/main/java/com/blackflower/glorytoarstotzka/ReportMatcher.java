package com.blackflower.glorytoarstotzka;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

public class ReportMatcher {
    
    private static int reportID = 1000000000;
    
    public static Report CreateReport(String reportSubject, Report.ReportType reportType, Citizen reporter){
        int year = java.time.LocalDate.now().getYear();
        int month = java.time.LocalDate.now().getMonthValue();
        int day = java.time.LocalDate.now().getDayOfMonth();
        
        Report report = new Report.Builder(GenerateReportID(), reporter, 
                day, month, year, reportSubject, reportType)
                .responsibleEmployee(MatchReport())
                .build();
        
        return report;
    }
    
    private static int GenerateReportID(){
        reportID++;
        return reportID;
    }
    
    public static Employee MatchReport(){
        
    }
}
