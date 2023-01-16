package ApplicationPackage;

import UserPackage.Users;
import UserPackage.Employee;
import UserPackage.Admin;
import UserPackage.Citizen;
import com.blackflower.glorytoarstotzka.ConsoleColors;
import ReportPackage.Report;
import com.blackflower.glorytoarstotzka.TestUsersCreator;
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
        //TestUsersCreator.CreateCitizens();
        //TestUsersCreator.CreateEmployees();
        
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
        sc.nextLine();
        System.out.print("\nUsername: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        userAccount = Database.IdentityValidation(username, password);
        
        if (userAccount == null) {
            System.out.println(ConsoleColors.RED + "Account Not Found!" + ConsoleColors.RESET);
        }
    }
    
    
    private static void AdminDisplay(){
        System.out.println();
        
        try {
            Admin adminAccount = (Admin)userAccount;
            
            while (adminAccount != null) {    
                System.out.println(ConsoleColors.GREEN + "\n\n --------------Welcome " + adminAccount.GetUsername() + " From Arstotzka--------------" + ConsoleColors.RESET);
                System.out.println("""
                                   Press 1 to add new tax
                                   Press 2 to add employee
                                   Press 3 to add citizen
                                   Press 4 to list all reports
                                   Press 5 to log out""");
                
                userInput = TakeInput(5);     
                
                switch (userInput) {
                    case 1:
                        System.out.print("\n Tax Name: ");
                        String taxName = sc.nextLine();
                        taxName = sc.nextLine();
                        System.out.print("Tax Amount: ");
                        int taxAmount = sc.nextInt();
                        
                        adminAccount.CreateTax(taxName, taxAmount);
                        continue;
                    case 2:                        
                        System.out.print("\n\nEmployee First Name: ");
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
                        System.out.println("1 - ENGINEER \t 2 - EDUCATOR \t 3 - ENVIRONMENT EXPERT \t 4 - GENERAL EXPERT");
                        userInput = TakeInput(4);
                        String type;
                        type = Employee.EmployeeType[userInput - 1];
                        
                        adminAccount.CreateEmployee(employeeFirstName, employeeLastName, type, employeeUsername, employeePassword, employeeEMailAddress);
                        continue;
                    case 3:
                        System.out.print("\nCitizen First Name: ");
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
            System.out.println(ConsoleColors.RED + "Exception Occured" + ConsoleColors.RESET);
            Login();
        }
    }
    
    private static void EmployeeDisplay(){
        
        try {
            Employee employeeAccount = (Employee)userAccount;
            while (employeeAccount != null) {                
            System.out.println(ConsoleColors.GREEN + "\n\n --------------Welcome " + employeeAccount.GetCitizenFirstName()+ " " + employeeAccount.GetCitizenLastName()+ ", Veteran From Arstotzka--------------" + ConsoleColors.RESET);
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
                            System.out.println(ConsoleColors.RED + "There is no respondible report!");
                            continue;
                        }
                        else{
                            employeeAccount.ReportSelection();
                            int reportNum = TakeInput(employeeAccount.GetResponsibleReports().size());
                            System.out.println("Type Respond:");
                            String respond = sc.nextLine();
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
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Exception Occured");
            Login();
        }
    }
    
    private static void CitizenDisplay(){
        
        try {
            Citizen citizenAccount = (Citizen)userAccount;
            while (citizenAccount != null) {
            System.out.println(ConsoleColors.GREEN + "\n\n --------------Welcome " + citizenAccount.GetCitizenFirstName()+ " " + citizenAccount.GetCitizenLastName()+ ", Citizen From Arstotzka--------------" + ConsoleColors.RESET);                
                System.out.println("""
                                   Press 1 to list taxes
                                   Press 2 to report something
                                   Press 3 to list unresolved reports
                                   Press 4 to list resolved reports
                                   Press 5 to list all reports
                                   Press 6 to log out""");
                
                userInput = TakeInput(7);
                
                switch (userInput) {
                    case 1:
                        citizenAccount.ListTaxes();
                        continue;
                    case 2:
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
                    case 3:
                        citizenAccount.ListCreatedReports();
                        continue;
                    case 4:
                        citizenAccount.ListSolvedReports();
                        continue;
                    case 5:
                        citizenAccount.ListAllReports();
                        continue;
                    case 6:
                        userAccount = null;
                        citizenAccount = null;
                         break;
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
        
        System.out.print(ConsoleColors.GREEN + "\nEnter your choise: " + ConsoleColors.RESET);
        input = sc.nextInt();
        
        while (input <= 0 || input > limit) {
           System.out.println(ConsoleColors.RED + "\nPlease enter a valid number!!!" + ConsoleColors.RESET);
           System.out.print(ConsoleColors.GREEN + "\nEnter your choise: " + ConsoleColors.RESET);
           input = sc.nextInt();
        }
        
        return input;
    }
    
}