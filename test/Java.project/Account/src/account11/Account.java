
package account11;

import java.util.*;

public class Account {
    
    private int id;
    private double balance;
    private double annualInterstRate;
    Date dateCreated = new Date(); 
    
    Account(){     
    }
    
    Account(int newId,double newBalance){
        id = newId;
        balance = newBalance;
    }
    
    public void setId(int newId){
        id=newId;
    }
    public int getId(){
        return id;
    }
    public void setBalance(double newBalance){
        balance = newBalance; 
    }
    public double getBalance(){
        return balance;
    }
    public void setAnnualInterstRate(double newAnnualInterstRate){
        annualInterstRate = newAnnualInterstRate;
    }
    public double getAnnualInterstRate(){
        return annualInterstRate;
    }
    public String getDateCreated(){
        return dateCreated.toString();
    }
    public double getMonthlyInterestRate(){
        return annualInterstRate/12.0;
    }
    
    public void withDraw(double withDraw){
        balance -= withDraw;
    }
    public void deposit(double deposit){
        balance += deposit;
    }
    public double MontlyInterst(){
        return balance*(annualInterstRate/12.0);
    }    
    
    public static void main(String[] args) {
        Account a = new Account(1122,20000);
        a.setAnnualInterstRate(0.045);
        a.withDraw(2500);
        a.deposit(3000);
        System.out.println("The balance is "+a.getBalance());
        System.out.println("The MontlyInterst is "+a.MontlyInterst());
        System.out.println("The date of opening an account is "+a.getDateCreated());               
    }
    
}