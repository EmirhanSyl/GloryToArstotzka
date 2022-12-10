package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Users {
    
    // Variables
    private final long citizenID;
    
    private final String citizenFirstName;
    private final String citizenLastName;
    
    private String username;
    private String password;
    
    private String emailAddress;
    
    // Constractor Starts
    public Users(Builder builder) {
        this.citizenID = builder.citizenID;
	this.citizenFirstName = builder.citizenFirstName;
	this.citizenLastName = builder.citizenLastName;
        this.username = builder.username;
        this.password = builder.password;
        this.emailAddress = builder.emailAddress;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // End Of Constractor
    
    // Encapsulation Starts
    public long GetCitizenID(){return citizenID;}
    public String GetCitizenFirstName(){return citizenFirstName;}
    public String GetCitizenLastName(){return citizenLastName;}
    
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
    
    // End Of Encapsulation
    
    
    // Builder Start
    public static class Builder{
        private long citizenID;
        private String citizenFirstName;
        private String citizenLastName;
        
        private String username;
        private String password;
        private String emailAddress;

        protected Builder() {}
        
        public Builder(long citizenID, String citizenFirstName, String citizenLastName){
            int numCount = 0;
            for (long tempID = citizenID; tempID != 0; tempID /= 10, ++numCount) {}
        
            if (numCount == 11 && citizenID > 0 && !citizenFirstName.isEmpty() && !citizenLastName.isEmpty()) {
                this.citizenID = citizenID;
                this.citizenFirstName = citizenFirstName;
                this.citizenLastName = citizenLastName;
            }
            else{
                System.out.println("Incorrect values for citizenID, citizenFirstName or citizenLastName!");
            }
        }
        
        public Builder username(String username){
            if (!username.isEmpty()) {
                this.username = username;
            }else{
                System.out.println("Incorrect value for username!");
            }
            
            return this;
        }
        
        public Builder password(String password){
            if (!password.isEmpty() && password.length() > 8) {
                this.password = password;
            } else {
                System.out.println("Incorrect value for password!");
            }
            return this;
        }
        
        public Builder emailAddress(String emailAddress){
            if (!emailAddress.isEmpty()) {
                this.emailAddress = emailAddress;
            } else {
                System.out.println("Incorrect value for citizen email address!");
            }
            return this;
        }
        
        public Users build() {
            Users user =  new Users(this);
            return user;
	}
    }
    // End Of Builder
}
