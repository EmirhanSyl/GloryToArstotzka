package com.blackflower.glorytoarstotzka;

import java.util.Scanner;

/**
 *
 * @author emirs
 */
public class GloryToArstotzka{
    
    private static Scanner sc = new Scanner(System.in);
    
    public enum AccountType{
            ADMIN, 
            EMPLOYEE, 
            CITIZEN,
        }
    public static AccountType accountType;
    
    private static Admin adminAccount;
    private static Employee employeeAccount;
    private static Citizen citizenAccount;
    
    public static void SetAdminAccount(Admin admin){adminAccount = admin;}
    public static void SetEmployeeAccount(Employee employee){employeeAccount = employee;}
    public static void SetCitizenAccount(Citizen citizen){citizenAccount = citizen;}
    
    public static void main(String[] args) {
        System.out.println("GLORY TO ARSTOTZKA");
        
        Database.InitializeAdminAccount();
        
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        
        Login.TryLogin(username, password);
        
        switch (accountType) {
            case ADMIN -> {AdminDisplay();}
            case EMPLOYEE -> {EmployeeDisplay();}
            case CITIZEN -> {CitizenDisplay();}
            default -> {System.out.println("Account Not Found!");}
        }
    }
    
    private static void AdminDisplay(){
        System.out.println("Welcome Admin!");
    }
    
    private static void EmployeeDisplay(){
        System.out.println("Welcome Veteran From Arstotzka!");
    }
    
    private static void CitizenDisplay(){
        System.out.println("Welcome Citizen of Glorius Arstotzka!");
    }
    
}
