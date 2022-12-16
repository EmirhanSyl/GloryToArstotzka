package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Login {

    public static void TryLogin(String username, String password) {
        Users user = Database.IdentityValidation(username, password);

        if (user != null) {
            if (user.getClass().equals(Admin.class)) {
                GloryToArstotzka.accountType = GloryToArstotzka.AccountType.ADMIN;
                GloryToArstotzka.SetUserAccount(user);
            } else if (user.getClass().equals(Employee.class)) {
                GloryToArstotzka.accountType = GloryToArstotzka.AccountType.EMPLOYEE;
                GloryToArstotzka.SetUserAccount(user);
            } else if (user.getClass().equals(Citizen.class)) {
                GloryToArstotzka.accountType = GloryToArstotzka.AccountType.CITIZEN;
                GloryToArstotzka.SetUserAccount(user);
            }
        }
    }
}
