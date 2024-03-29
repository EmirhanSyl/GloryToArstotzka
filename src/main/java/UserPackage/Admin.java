package UserPackage;

import ApplicationPackage.Database;
import TaxPackage.Tax;

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
    
    public void CreateEmployee(String citizenFirstName, String citizenLastName, String type, 
            String citizenUsername, String citizenPassword, String citizenEMailAddress){
        
        Database.CreateEmployee(super.GetPassword(), type, citizenFirstName, citizenLastName, citizenUsername, citizenPassword, citizenEMailAddress);
    }
    
    public void ListAllReports(){
        Database.ListAllReports(super.GetPassword());
    }
    
    public void CreateTax(String taxName, int taxAmount){
        Tax tax = new Tax.Builder(taxName, taxAmount).build();
        Database.CreateTax(this.GetPassword(), tax);
    }
    
    // End Of Functions
    
    
    // Builder Starts
    public static class Builder extends Users.Builder{

        public Builder(){}
        
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
        public Admin build(){
            Admin admin = new Admin(this);
            return admin;
        }
    }
    
    // End Of Builders
}
