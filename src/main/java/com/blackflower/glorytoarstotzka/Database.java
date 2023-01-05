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
    
    private final static ArrayList<Users> Arstotzkanians = new ArrayList<>();
    private final static ArrayList<Report> allReports  = new ArrayList<>();
    private final static ArrayList<Tax> taxes = new ArrayList<>();
    
    private static boolean isAdminInitiated = false;
    
    // Encapsulation Starts
    public static void AddReport(Report report){allReports.add(report);}
    // End Of Encapsulation
    
    
    // Functions Start
    public static void CreateEmployee(String key_password, String type,
            String citizenFirstName, String citizenLastName, String citizenUsername,
            String citizenPassword, String citizenEMailAddress){
        
        // key_password Control        
        if (!key_passwordControl(key_password)) {return;}
        // End of key_password Control
        
        Employee createdEmployee = new Employee.Builder(CitizenIDGenerator(), citizenFirstName, citizenLastName)
                .username(citizenUsername)
                .password(citizenPassword)
                .emailAddress(citizenEMailAddress)
                .setEmployeeType(type)
                .build();
        
        Arstotzkanians.add(createdEmployee);
    }
    
    public static void CreateCitizen(String key_password, String citizenFirstName, 
            String citizenLastName, String citizenUsername,
            String citizenPassword, String citizenEMailAddress){
        
        // key_password Control        
        if (!key_passwordControl(key_password)) {System.out.println("Validation ERROR!"); return;}
        // End of key_password Control
        
        Citizen createdCitizen = new Citizen.Builder(CitizenIDGenerator(), citizenFirstName, citizenLastName)
                .username(citizenUsername)
                .password(citizenPassword)
                .emailAddress(citizenEMailAddress)
                .build();
        
        Arstotzkanians.add(createdCitizen);
    }
    
    public static void CreateTax(String key_password, Tax tax){
        
        // key_password Control        
        if (!key_passwordControl(key_password)) {System.out.println("Validation ERROR!"); return;}
        // End of key_password Control
        
        taxes.add(tax);
        System.out.println("New Tax Added Successfuly");
    }
    
    private static long CitizenIDGenerator(){
        return random.nextLong(10000000000L, 99999999999L);
    }
    
    private static boolean key_passwordControl(String key_password) {
        boolean isPasswordCorrect = false;
        for (Users user : Arstotzkanians) {
            if (user instanceof Admin) {
                
                Admin admin = (Admin) user;
                if (admin.GetPassword().equals(key_password)) {
                    isPasswordCorrect = true;
                }
            }
        }
        return isPasswordCorrect;
    }
    
    public static Employee findMostAvailableEmployee(String type){
        
        Employee mostAvailableEmployee = null;
        
        switch (type) {
            case "ENGINEER" -> { mostAvailableEmployee = MostAvailableEmployee(0);}
            case "EDUCATOR" -> { mostAvailableEmployee = MostAvailableEmployee(1);}
            case "ENVIRONMENT_SPECIALIST" -> { mostAvailableEmployee = MostAvailableEmployee(2);}
            case "GENERAL_EXPERT" -> { mostAvailableEmployee = MostAvailableEmployee(3);}
        }
        
        return mostAvailableEmployee;
    }
    
    private static Employee MostAvailableEmployee(int employeeTypeIndex){
        
        int mostAvailable = Integer.MAX_VALUE;
        Employee mostAvailableEmployee = null;
        
        for (Users user : Arstotzkanians) {
                    if (user instanceof Employee employee) {
                        if (employee.getEmployeeType().equals(Employee.EmployeeType[employeeTypeIndex])) {
                            if (employee.ResponsibleReportCount() < mostAvailable) {
                                mostAvailable = employee.ResponsibleReportCount();
                                mostAvailableEmployee = employee;
                            }
                        }
                    }
                }
        return mostAvailableEmployee;
    }
    
    
    public static void InitializeAdminAccount(){
        if (!isAdminInitiated) {
            Admin admin = new Admin.Builder(CitizenIDGenerator(), "Emirhan", "Soylu")
                    .username("admin")
                    .password("GloryToArstotzka!")
                    .emailAddress("admin@arstotzka.glory")
                    .build();
            
            Arstotzkanians.add(admin);
            
            if (Arstotzkanians.get(0) != null) {
                isAdminInitiated = true;
            }
        }
    }
    
    // Print all reports
    public static void ListAllReports(String key_password){
        // key_password Control        
        if (!key_passwordControl(key_password)) {return;}
        // End of key_password Control
        
        for (Report report : allReports) {
            report.WriteReport();
        }
    }
    
    // Print all taxes
    public static void ListAllTaxes(ArrayList<Tax> paidTaxs){
        for (Tax tax : taxes) {
            boolean isPaid = false;
            for (Tax paidTax : paidTaxs) {
                if (paidTax.getTaxID() == tax.getTaxID()) {
                    isPaid = true;
                }
            }
            tax.PrintTax(isPaid);
        }
    }
    
    // Print unpaid taxes
    public static void ListUnpaidTaxes(ArrayList<Tax> paidTaxs){
        for (Tax tax : taxes) {
            boolean isPaid = false;
            for (Tax paidTax : paidTaxs) {
                if (paidTax.getTaxID() == tax.getTaxID()) {
                    isPaid = true;
                }
            }
            if (!isPaid) {
                System.out.println("1: ");
                tax.PrintTax(false);
            }
        }
    }
    
    // Identity Validations
    public static Users IdentityValidation(String username, String password){
        Users user = null;
        for (Users checkedUser : Arstotzkanians) {
            if (checkedUser.GetUsername().equalsIgnoreCase(username) && checkedUser.GetPassword().equalsIgnoreCase(password)) {
                user = checkedUser;
                return user;
            }
        }        
        return user;
    }
    
    // End Of Functions
    
}
