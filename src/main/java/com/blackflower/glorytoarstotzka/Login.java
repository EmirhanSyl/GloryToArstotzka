package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Login {
    
    public static void TryLogin(String username, String password){
        Employee employee = Database.EmployeeIdentityValidation(username, password);
        Admin admin = Database.AdminIdentityValidation(username, password);
        Citizen citizen = Database.CitizenIdentityValidation(username, password);
        
        if (admin != null) {
            System.out.println("Admin");
            GloryToArstotzka.accountType = GloryToArstotzka.AccountType.ADMIN;
            GloryToArstotzka.SetAdminAccount(admin);
        }
        else if (employee != null) {
            System.out.println("Emp");
            GloryToArstotzka.accountType = GloryToArstotzka.AccountType.EMPLOYEE;
            GloryToArstotzka.SetEmployeeAccount(employee);
        }
        else if(citizen != null){
            System.out.println("Citizen");
            GloryToArstotzka.accountType = GloryToArstotzka.AccountType.CITIZEN;
            GloryToArstotzka.SetCitizenAccount(citizen);
        }
    }
}
