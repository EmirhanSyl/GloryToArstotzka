package com.blackflower.glorytoarstotzka;

/**
 *
 * @author emirs
 */
public class Tax {
    private static int taxCount;
    private final int taxID;
    private final String name;
    private final int taxAmount;
    
    // Constractor Starts
    public Tax(Builder builder){
        this.name = builder.name;
        this.taxAmount = builder.taxAmount;
        this.taxID = taxCount;
        taxCount++;
    }
    // End of Encapsulation
    
    
    // Encapsulation Starts
    public int getTaxID() {return taxID;}
    public String getName() {return name;}
    public double getTaxAmount() {return taxAmount;}
    
    // End of Encpsulation
    
    
    // Functions Start
    public void PrintTax(boolean isPaid) {
        String paidText = (isPaid) ? "Tax Paid. Good Job.": "Pay your Tax!";
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Tax ID: " + taxID);
        System.out.println("Tax Name: " + this.name);
        System.out.println("Tax Amount: " + this.taxAmount);
        System.out.println("Is Paid: " + paidText);
        System.out.println("----------------------------------------");
        System.out.println();
    }
    
    // End of Functions
    
    
    // Builder Pattern Starts
    public static class Builder{
        private final String name;
        private final int taxAmount;
        
        public Builder(String name, int taxAmount){
            this.name = name;
            this.taxAmount = taxAmount;
        }
        
        public Tax build(){
            Tax tax = new Tax(this);
            return tax;
        }
    }
    // End Of Builder Pattern
}
