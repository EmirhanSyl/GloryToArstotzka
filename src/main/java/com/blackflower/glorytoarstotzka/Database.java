package com.blackflower.glorytoarstotzka;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author emirs
 */
public class Database {
    
    // Variables
    static Random random = new Random();
    
    private final static ArrayList<Employee> allEmployeesOfArstotszka = new ArrayList<>();
    
    private final static ArrayList<Employee> engineersOfArstotszka = new ArrayList<>();
    private final static ArrayList<Employee> educatorsOfArstotszka = new ArrayList<>();
    private final static ArrayList<Employee> environmentExpertsOfArstotszka = new ArrayList<>();
    private final static ArrayList<Employee> generalExpertsOfArstotszka = new ArrayList<>();
    
    private final static ArrayList<Citizen> citizensOfArstotszka = new ArrayList<>();
    private final static ArrayList<Admin> adminsOfArstotszka = new ArrayList<>();
    
    
    // Functions Start
    public static void CreateEmployee(String key_password, Employee.EmployeeType type,
            String citizenFirstName, String citizenLastName, String citizenUsername,
            String citizenPassword, String citizenEMailAddress){
        
        // key_password Control
        boolean isPasswordCorrect = false;
        for (Admin admin : adminsOfArstotszka) {
            if (admin.GetPassword().equals(key_password)) {
                isPasswordCorrect = true;
            }
        }
        if (!isPasswordCorrect) {return;}
        // End of key_password Control
        
        //Employee createdEmployee = new Employee.Builder(CitizenIDGenerator(), citizenFirstName, citizenLastName)
    }
    
    private static long CitizenIDGenerator(){
        return random.nextLong(10000000000L, 99999999999L);
    }
    
    // End Of Functions
    
}
