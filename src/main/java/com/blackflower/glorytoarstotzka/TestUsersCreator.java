    package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class TestUsersCreator {
    
    private static final String[] citizenFirstNames = {"Citizen1", "Citizen2", "Citizen3", "Citizen4"};
    private static final String[] citizenLastNames = {"Citizen1", "Citizen2", "Citizen3", "Citizen4"};
    
    private static final String[] citizenUsernames = {"Citizen1", "Citizen2", "Citizen3", "Citizen4"};
    private static final String[] citizenPasswords = {"Citizen1Pass", "Citizen2Pass", "Citizen3Pass", "Citizen4Pass"};
    private static final String[] citizenEmailAddresses = {"Citizen1", "Citizen2", "Citizen3", "Citizen4"};
    
    
    private static final String[] employeeFirstNames = {"Employee1", "Employee2", "Employee3", "Employee4"};
    private static final String[] employeeLastNames = {"Employee1", "Employee2", "Employee3", "Employee4"};
    
    private static final String[] employeeUsernames = {"Employee1", "Employee2", "Employee3", "Employee4"};
    private static final String[] employeePasswords = {"Employee1Pass", "Employee2Pass", "Employee3Pass", "Employee4Pass"};
    private static final String[] employeeEmailAddresses = {"Employee1", "Employee2", "Employee3", "Employee4"};
    
    public static void CreateCitizens() {

        for (int i = 0; i < citizenFirstNames.length; i++) {
            Database.CreateCitizen("GloryToArstotzka!", citizenFirstNames[i], citizenLastNames[i], citizenUsernames[i], citizenPasswords[i], citizenEmailAddresses[i]);
        }
    }
    
    public static void CreateEmployees(){
        
        for (int i = 0; i < citizenFirstNames.length; i++) {
            Employee.EmployeeType type = null;
            
            int typer = i % 4;
            switch (typer) {
                case 0 -> type = Employee.EmployeeType.EDUCATOR;
                case 1 -> type = Employee.EmployeeType.ENGINEER;
                case 2 -> type = Employee.EmployeeType.ENVIRONMENT_SPECIALIST;
                case 3 -> type = Employee.EmployeeType.GENERAL_EXPERT;
            }
            
            Database.CreateEmployee("GloryToArstotzka!", type, employeeFirstNames[i], employeeLastNames[i], employeeUsernames[i], employeePasswords[i], employeeEmailAddresses[i]);
        }        
    }
}
