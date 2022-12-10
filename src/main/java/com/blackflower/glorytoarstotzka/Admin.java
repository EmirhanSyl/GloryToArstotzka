package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Admin extends Users{
    
    // Constractor Starts
    public Admin(Builder builder){
        super(builder);
    }
    
    // End of Constractor
    
    
    // Functions Start
    public void CreateCitizen(String citizenFirstName, String citizenLastName, 
            String citizenUsername, String citizenPassword, String citizenEMailAddress){
        
        Database.CreateCitizen(super.GetPassword(), citizenFirstName, citizenLastName, citizenUsername, citizenPassword, citizenEMailAddress);
    }
    
    public void CreateEmployee(String citizenFirstName, String citizenLastName, Employee.EmployeeType type, 
            String citizenUsername, String citizenPassword, String citizenEMailAddress){
        
        Database.CreateEmployee(super.GetPassword(), type, citizenFirstName, citizenLastName, citizenUsername, citizenPassword, citizenEMailAddress);
    }
    
    public void ListAllReports(){
        Database.ListAllReports(super.GetPassword());
    }
    
    // End Of Functions
    
    
    // Builder Starts
    public static class Builder extends Users.Builder{

        protected Builder(){}
        
        protected Builder(long citizenID, String citizenFirstName, String citizenLastName) {
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
        public Admin build(){
            Admin admin = new Admin(this);
            return admin;
        }
    }
    
    // End Of Builders
}
