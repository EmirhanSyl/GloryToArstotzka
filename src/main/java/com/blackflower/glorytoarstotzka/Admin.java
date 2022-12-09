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

        public Builder() {}
        
        @Override
        public Admin build(){
            Admin admin = new Admin(this);
            return admin;
        }
    }
}
