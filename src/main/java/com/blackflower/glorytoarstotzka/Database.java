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
    
    private final static ArrayList<Report> allReports  = new ArrayList<>();
    private final static ArrayList<Tax> taxes = new ArrayList<>();
    
    private static boolean isAdminInitiated = false;
    
    // Encapsulation Starts
    public static void AddReport(Report report){allReports.add(report);}
    // End Of Encapsulation
    
    
    // Functions Start
    public static void CreateEmployee(String key_password, Employee.EmployeeType type,
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
        
        allEmployeesOfArstotszka.add(createdEmployee);
        switch (type) {
            case ENGINEER -> engineersOfArstotszka.add(createdEmployee);
            case EDUCATOR -> educatorsOfArstotszka.add(createdEmployee);
            case ENVIRONMENT_SPECIALIST -> environmentExpertsOfArstotszka.add(createdEmployee);
            case GENERAL_EXPERT -> generalExpertsOfArstotszka.add(createdEmployee);
        }        
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
        
        citizensOfArstotszka.add(createdCitizen);        
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
    
    private static boolean key_passwordControl(String key_password){        
        boolean isPasswordCorrect = false;
        for (Admin admin : adminsOfArstotszka) {
            if (admin.GetPassword().equals(key_password)) {
                isPasswordCorrect = true;
            }
        }
        return isPasswordCorrect;
    }
    
    public static Employee findMostAvailableEmployee(Employee.EmployeeType type){
        int mostAvailable = Integer.MAX_VALUE;
        Employee mostAvailableEmployee = null;
        
        switch (type) {
            case ENGINEER -> {
                for (Employee engineer : engineersOfArstotszka) {
                    if (engineer.ResponsibleReportCount() < mostAvailable) {
                        mostAvailable = engineer.ResponsibleReportCount();
                        mostAvailableEmployee = engineer;
                    }
                }
            }
            case EDUCATOR -> {
                for (Employee educator : educatorsOfArstotszka) {
                    if (educator.ResponsibleReportCount() < mostAvailable) {
                        mostAvailable = educator.ResponsibleReportCount();
                        mostAvailableEmployee = educator;
                    }
                }
            }
            case ENVIRONMENT_SPECIALIST -> {
                for (Employee environmentExpert : environmentExpertsOfArstotszka) {
                    if (environmentExpert.ResponsibleReportCount() < mostAvailable) {
                        mostAvailable = environmentExpert.ResponsibleReportCount();
                        mostAvailableEmployee = environmentExpert;
                    }
                }
            }
            case GENERAL_EXPERT -> {
                for (Employee generalExpert : generalExpertsOfArstotszka) {
                    if (generalExpert.ResponsibleReportCount() < mostAvailable) {
                        mostAvailable = generalExpert.ResponsibleReportCount();
                        mostAvailableEmployee = generalExpert;
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
            
            adminsOfArstotszka.add(admin);
            
            if (adminsOfArstotszka.get(0) != null) {
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
        for (Admin checkedAdmin : adminsOfArstotszka) {
            if (checkedAdmin.GetUsername().equalsIgnoreCase(username) && checkedAdmin.GetPassword().equalsIgnoreCase(password)) {
                user = checkedAdmin;
                return user;
            }
        }
        
        for (Employee checkedEmployee : allEmployeesOfArstotszka) {
            if (checkedEmployee.GetUsername().equalsIgnoreCase(username) && checkedEmployee.GetPassword().equalsIgnoreCase(password)) {
                user = checkedEmployee;
                return user;
            }
        }
        
        for (Citizen checkedCitizen : citizensOfArstotszka) {
            if (checkedCitizen.GetUsername().equalsIgnoreCase(username) && checkedCitizen.GetPassword().equalsIgnoreCase(password)) {
                user = checkedCitizen;
                return user;
            }
        }
        
        return user;
    }
    
    // End Of Functions
    
}
