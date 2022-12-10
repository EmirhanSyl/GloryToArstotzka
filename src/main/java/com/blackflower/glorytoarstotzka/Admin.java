package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Admin extends Users{
    
    public Admin(Builder builder){
        super(builder);
    }
    
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
}
