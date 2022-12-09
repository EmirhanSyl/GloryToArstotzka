package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Admin extends Users{
    private final int testInt;
    
    public Admin(Builder builder){
        super(builder);
    }
    
    public static class Builder extends Users.Builder{
        private int testInt;

        Builder() {}
        
        public Builder(int testInt) {
            this.testInt = testInt;
        }
        
        @Override
        public Admin build(){
            Admin admin = new Admin(this);
            return admin;
        }
    }
}
