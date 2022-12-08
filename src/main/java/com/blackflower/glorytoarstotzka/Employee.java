
package com.blackflower.glorytoarstotzka;

import java.util.ArrayList;

/**
 *
 * @author emirs
 */
public class Employee extends Users{
    
    private ArrayList<Report> responsibleReports = new ArrayList<>();
    private ArrayList<Report> solvedReports = new ArrayList<>();
    
    public ArrayList<Report> GetResponsibleReports(){return responsibleReports;}
    public void AddReport(Report report){responsibleReports.add(report);}
    
    public ArrayList<Report> GetSolvedReports(){return responsibleReports;}
    public void CoplateReport(Report report){
        solvedReports.add(report);
        
        for (int i=0; i < responsibleReports.size(); i++) {
            if (responsibleReports.get(i).GetReportID() == report.GetReportID()) {
                responsibleReports.remove(i);
                break;
            }
        }
    }
}
