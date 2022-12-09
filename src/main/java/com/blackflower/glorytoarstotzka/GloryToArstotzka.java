package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class GloryToArstotzka{
    
    public static void main(String[] args) {
        System.out.println("GLORY TO ARSTOTZKA");
        
        //Admin admin = new Admin();
        Users user = new Users.Builder(100000001L, "", "")
                .username("")
                .password("gdfg")
                .emailAddress("")
                .build();
        System.out.println(user.GetCitizenID());
        
    }
}
