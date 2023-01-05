package com.blackflower.glorytoarstotzka;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

/**
 *
 * @author emirs
 */
public class GloryToArstotzka{
    
    private static Scanner sc = new Scanner(System.in);
    private static int userInput = 0;
      
    private static Users userAccount;
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println(ConsoleColors.RED_BOLD+ 
                "GLORY TO ARSTOTZKA️" 
                +ConsoleColors.RESET);
        
        Database.InitializeAdminAccount();
        TestUsersCreator.CreateCitizens();
        TestUsersCreator.CreateEmployees();
        
        while (true) {
            if (userAccount == null) {
                Login();
            }
            else{
                if (userAccount instanceof Admin) { AdminDisplay(); }
                else if (userAccount instanceof Employee) { EmployeeDisplay(); } 
                else if (userAccount instanceof Citizen) { CitizenDisplay(); }
            }
        }
    }
    
    private static void Login(){
        sc.nextLine(); // Error
        System.out.print("Username: ");
        String username = sc.nextLine();         
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        userAccount = Database.IdentityValidation(username, password);
        
        if (userAccount == null) {
            System.out.println("Account Not Found!");
        }
    }
    
    
    private static void AdminDisplay(){
        System.out.println("Welcome Admin!");
        
        try {
            Admin adminAccount = (Admin)userAccount;
            
            while (adminAccount != null) {                
                System.out.println("""
                                   Press 1 to add new tax
                                   Press 1 to add employee
                                   Press 2 to add citizen
                                   Press 3 to list all reports
                                   Press 4 to log out""");
                
                userInput = TakeInput(5);     
                
                switch (userInput) {
                    case 1:
                        System.out.print("Tax Name: ");
                        String taxName = sc.nextLine();
                        taxName = sc.nextLine();
                        System.out.print("Tax Amount: ");
                        int taxAmount = sc.nextInt();
                        
                        adminAccount.CreateTax(taxName, taxAmount);
                        continue;
                    case 2:                        
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
                        String type;
                        type = Employee.EmployeeType[userInput - 1];
                        
                        adminAccount.CreateEmployee(employeeFirstName, employeeLastName, type, employeeUsername, employeePassword, employeeEMailAddress);
                        continue;
                    case 3:
                        System.out.print("Citizen First Name: ");
                        String citizenFirstName = sc.nextLine();
                        citizenFirstName = sc.nextLine(); // Error
                        System.out.print("Citizen Last Name: ");
                        String citizenLastName = sc.nextLine();
                        System.out.print("Citizen Username: ");
                        String citizenUsername = sc.nextLine();
                        System.out.print("Citizen Password: ");
                        String citizenPassword = sc.nextLine();
                        System.out.print("Citizen E-Mail Address: ");
                        String citizenEMailAddress = sc.nextLine();
                        
                        adminAccount.CreateCitizen(citizenFirstName, citizenLastName, citizenUsername, citizenPassword, citizenEMailAddress);
                        continue;
                    case 4:
                        adminAccount.ListAllReports();
                        continue;
                    case 5:
                        userAccount = null;
                        adminAccount = null;
                        return;
                    default:
                        System.out.println("An error occured! Try again");
                        return;
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Exception Occured");
            Login();
        }
    }
    
    private static void EmployeeDisplay(){
        System.out.println("Welcome Veteran From Arstotzka!");
        
        try {
            Employee employeeAccount = (Employee)userAccount;
            while (employeeAccount != null) {                
                System.out.println("""
                                   Press 1 to respond a report
                                   Press 2 to list responsible reports
                                   Press 3 to list resolved reports
                                   Press 4 to list all reports
                                   Press 5 to log out
                                   """);
                
                userInput = TakeInput(5);
                
                switch (userInput) {
                    case 1:
                        if (employeeAccount.GetResponsibleReports().isEmpty()) {
                            System.out.println("There is no respondible report!");
                            continue;
                        }
                        else{
                            employeeAccount.ReportSelection();
                            int reportNum = TakeInput(employeeAccount.GetResponsibleReports().size());
                            System.out.println("Type Respond:");
                            String respond = sc.next();
                            respond = sc.nextLine();
                            employeeAccount.SolveReport(reportNum, respond);
                        }                        
                        continue;
                    case 2:                        
                        employeeAccount.ListResponsibleReports();                        
                        continue;
                    case 3:
                        employeeAccount.ListSolvedReports();
                        continue;
                    case 4:
                        employeeAccount.ListAllReports();
                        continue;
                    case 5:
                        userAccount = null;
                        employeeAccount = null;
                        return;
                    default:
                        System.out.println("An error occured! Try again");
                        return;
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Exception Occured");
            Login();
        }
    }
    
    private static void CitizenDisplay(){
        System.out.println("Welcome Citizen of Glorius Arstotzka!");
        
        try {
            Citizen citizenAccount = (Citizen)userAccount;
            while (citizenAccount != null) {                
                System.out.println("""
                                   Press 1 to list taxes
                                   press 2 to pay tax
                                   Press 3 to report something
                                   Press 4 to list responsible reports
                                   Press 5 to list resolved reports
                                   Press 6 to list all reports
                                   Press 7 to log out""");
                
                userInput = TakeInput(7);
                
                switch (userInput) {
                    case 1:
                        citizenAccount.ListTaxes();
                        continue;
                    case 2:
                        citizenAccount.PayTax();
                        continue;
                    case 3:
                        System.out.println("Select Report Type");
                        System.out.println("1 - EDUCATION /t 2 - ELECTRICAL ISSUES /t 3 - WATER SUPPLY /t 4 - OTHER");
                        userInput = TakeInput(4);
                        String type;
                        type = Report.ReportType[userInput - 1];
                        
                        System.out.print("Report Subject: ");
                        String reportSubject = sc.nextLine();
                        reportSubject = sc.nextLine();
                        
                        citizenAccount.CreateReport(reportSubject, type);
                        continue;
                    case 4:
                        citizenAccount.ListCreatedReports();
                        continue;
                    case 5:
                        citizenAccount.ListSolvedReports();
                        continue;
                    case 6:
                        citizenAccount.ListAllReports();
                    case 7:
                        userAccount = null;
                        citizenAccount = null;
                        return;
                    default:
                        System.out.println("An error occured! Try again");
                        return;
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Exception Occured");
            Login();
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