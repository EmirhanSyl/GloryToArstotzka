package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Users {
    
    // Variables
    private long citizenID;
    
    private String citizenFirstName;
    private String citizenLastName;
    
    private String username;
    private String password;
    
    private String emailAddress;
    
    // Encapsulation
    public long GetCitizenID(){return citizenID;}    
    public void SetCitizenID(long citizenID) {
        int numCount = 0;
        for (long tempID = citizenID; tempID != 0; tempID /= 10, ++numCount) {}
        
        if (numCount == 11 && citizenID > 0) {
            this.citizenID = citizenID;
        }
        else{
            System.out.println("Incorrect value for citizenID!");
        }
    }
    
    public String GetCitizenFirstName(){return citizenFirstName;}
    public void SetCitizenFirstName(String citizenFirstName){
        if (!citizenFirstName.isEmpty()) {
            this.citizenFirstName = citizenFirstName;
        }else{
            System.out.println("Incorrect value for citizen first name!");
        }
    }
    
    public String GetCitizenLastName(){return citizenLastName;}
    public void SetCitizenLastName(String citizenLastName){
        if (!citizenLastName.isEmpty()) {
            this.citizenLastName = citizenLastName;
        }else{
            System.out.println("Incorrect value for citizen last name!");
        }
    }
    
    public String GetUsername(){return username;}
    public void SetUsername(String username){
        if (!username.isEmpty()) {
            this.username = username;
        }else{
            System.out.println("Incorrect value for username!");
        }
    }
    
    public String GetPassword(){return password;}
    public void SetPassword(String password){
        if (!password.isEmpty() && password.length() > 8) {
            this.password = password;
        }else{
            System.out.println("Incorrect value for password!");
        }
    }
    
    public String GetEmailAddress(){return emailAddress;}
    public void SetEmailAddress(String emailAddress){
        if (!emailAddress.isEmpty()) {
            this.emailAddress = emailAddress;
        }else{
            System.out.println("Incorrect value for citizen email address!");
        }
    }
    
    //End Of Encapsulation
}
