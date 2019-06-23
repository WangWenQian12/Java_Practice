
package person11;

import java.util.*;

public class Employee extends Person{
    private int office;
    private double salary;
    private Date dateHired;
    
    public Employee(String name,String address,String phone,String email,
            int office,double salary ){
        super(name,address,phone,email);
        this.office=office;
        this.salary=salary;
        this.dateHired=new Date();
    }
    
    public void setOffice(int office){
        this.office = office; 
    }
    public int getOffice(){
        return office;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }
    public Date getDateHired(){
        return dateHired;
    }
    
    public String toSting(){
        return super.toString()+"\noffice:"+getOffice()
                +"\nsalary:"+getSalary()+"\ndateHired:"+getDateHired();
    }
  
            
}
