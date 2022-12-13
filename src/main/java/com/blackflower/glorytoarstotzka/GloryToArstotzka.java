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
    
    private static int userInput = 0;
    
    public static void SetAdminAccount(Admin admin){adminAccount = admin;}
    public static void SetEmployeeAccount(Employee employee){employeeAccount = employee;}
    public static void SetCitizenAccount(Citizen citizen){citizenAccount = citizen;}
    
    public static void main(String[] args) {
        System.out.println("GLORY TO ARSTOTZKA");
        
        Database.InitializeAdminAccount();
        TestUsersCreator.CreateCitizens();
        TestUsersCreator.CreateEmployees();
        
        Login();
    }
    
    private static void Login(){
        sc.nextLine(); // Error
        System.out.print("Username: ");
        String username = sc.nextLine();         
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        Login.TryLogin(username, password);
        
        if (accountType == null) {
            System.out.println("Account Not Found!");
            return;
        }
        
        switch (accountType) {
            case ADMIN -> {AdminDisplay();}
            case EMPLOYEE -> {EmployeeDisplay();}
            case CITIZEN -> {CitizenDisplay();}
        }
    }
    
    private static void AdminDisplay(){
        System.out.println("Welcome Admin!");
        
        
        
        try {
            while (true) {                
                System.out.println("""
                                   Press 1 to add employee
                                   Press 2 to add citizen
                                   Press 3 to list all reports
                                   Press 4 to log out""");
                
                userInput = TakeInput(4);
                
                switch (userInput) {
                    case 1:                        
                        System.out.print("Employee First Name: ");
                        String employeeFirstName = sc.nextLine();
                        employeeFirstName = sc.nextLine(); // Error
                        System.out.print("Employee Last Name: ");
                        String employeeLastName = sc.nextLine();
                        System.out.print("Employee Username: ");
                        String employeeUsername = sc.nextLine();
                        System.out.print("Employee Password: ");
                        String employeePassword = sc.nextLine();
                        System.out.print("Employee E-Mail Address: ");
                        String employeeEMailAddress = sc.nextLine();
                        
                        System.out.println("Select Employee Type");
                        System.out.println("1 - ENGINEER /t 2 - EDUCATOR /t 3 - ENVIRONMENT EXPERT /t 4 - GENERAL EXPERT");
                        userInput = TakeInput(4);
                        Employee.EmployeeType type = null;
                        switch(userInput){
                            case 1 -> type = Employee.EmployeeType.ENGINEER;
                            case 2 -> type = Employee.EmployeeType.EDUCATOR;
                            case 3 -> type = Employee.EmployeeType.ENVIRONMENT_SPECIALIST;
                            case 4 -> type = Employee.EmployeeType.GENERAL_EXPERT;
                        }
                        
                        adminAccount.CreateEmployee(employeeFirstName, employeeLastName, type, employeeUsername, employeePassword, employeeEMailAddress);
                        continue;
                    case 2:
                        System.out.print("Employee First Name: ");
                        String citizenFirstName = sc.nextLine();
                        System.out.print("Employee Last Name: ");
                        String citizenLastName = sc.nextLine();
                        System.out.print("Employee Username: ");
                        String citizenUsername = sc.nextLine();
                        System.out.print("Employee Password: ");
                        String citizenPassword = sc.nextLine();
                        System.out.print("Employee E-Mail Address: ");
                        String citizenEMailAddress = sc.nextLine();
                        
                        adminAccount.CreateCitizen(citizenFirstName, citizenLastName, citizenUsername, citizenPassword, citizenEMailAddress);
                        continue;
                    case 3:
                        adminAccount.ListAllReports();
                        continue;
                    case 4:
                        adminAccount = null;
                        accountType = null;
                        Login();
                        continue;
                    default:
                        System.out.println("An error occured! Try again");
                        return;
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Exception Occured");
            AdminDisplay();
        }
    }
    
    private static void EmployeeDisplay(){
        System.out.println("Welcome Veteran From Arstotzka!");
        
        try {
            while (true) {                
                System.out.println("""
                                   Press 1 to list responsible reports
                                   Press 2 to list resolved reports
                                   Press 3 to list all reports
                                   Press 4 to log out""");
                
                userInput = TakeInput(4);
                
                switch (userInput) {
                    case 1:                        
                        employeeAccount.ListResponsibleReports();                        
                        continue;
                    case 2:
                        employeeAccount.ListSolvedReports();
                        continue;
                    case 3:
                        employeeAccount.ListAllReports();
                        continue;
                    case 4:
                        employeeAccount = null;
                        accountType = null;
                        Login();
                        continue;
                    default:
                        System.out.println("An error occured! Try again");
                        return;
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Exception Occured");
            EmployeeDisplay();
        }
    }
    
    private static void CitizenDisplay(){
        System.out.println("Welcome Citizen of Glorius Arstotzka!");
        
        try {
            while (true) {                
                System.out.println("""
                                   Press 2 to list responsible reports
                                   Press 2 to list responsible reports
                                   Press 3 to list resolved reports
                                   Press 4 to list all reports
                                   Press 5 to log out""");
                
                userInput = TakeInput(5);
                
                switch (userInput) {
                    case 1:
                        System.out.println("Select Report Type");
                        System.out.println("1 - EDUCATION /t 2 - ELECTRICAL ISSUES /t 3 - WATER SUPPLY /t 4 - OTHER");
                        userInput = TakeInput(4);
                        Report.ReportType type = null;
                        switch(userInput){
                            case 1 -> type = Report.ReportType.EDUCATION;
                            case 2 -> type = Report.ReportType.ELECTRICAL;
                            case 3 -> type = Report.ReportType.WATER_SUPPLY;
                            case 4 -> type = Report.ReportType.OTHER;
                        }
                        
                        System.out.print("Report Subject: ");
                        String reportSubject = sc.nextLine();
                        
                        citizenAccount.CreateReport(reportSubject, type);
                        continue;
                    case 2:
                        citizenAccount.ListCreatedReports();
                        continue;
                    case 3:
                        citizenAccount.ListSolvedReports();
                        continue;
                    case 4:
                        citizenAccount.ListAllReports();
                    case 5:
                        citizenAccount = null;
                        accountType = null;
                        Login();
                        return;
                    default:
                        System.out.println("An error occured! Try again");
                        return;
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Exception Occured");
            CitizenDisplay();
        }
    }
    
    private static int TakeInput(int limit){
        int input;
        
        do {
           input = sc.nextInt();
        } while (input <= 0 && input > limit);
        
        return input;
    }
    
}
