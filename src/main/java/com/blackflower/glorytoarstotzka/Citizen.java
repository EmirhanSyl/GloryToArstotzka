package com.blackflower.glorytoarstotzka;

import java.util.ArrayList;

/**
 *
 * @author emirs
 */
public class Citizen extends Users{
    
    // Variables
    private ArrayList<Report> createdReports = new ArrayList<>();
    private ArrayList<Report> solvedReports = new ArrayList<>();
    
    
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
                createdReports.remove(i);
                break;
            }
        }
    }

    // End Of Encapsulation
    
    
    // Functions
    public void ListCreatedReports(){
        
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
