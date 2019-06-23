
package person11;

public class Person {
    private String name;
    private String address;
    private String phone;
    private String email;
    
    public Person(){
       
    }
    public Person(String name,String address,String phone,String email){
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.email=email;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    
    @Override
    public String toString(){
        return "name:"+getName()+"\naddress:"+getAddress()
                +"\nphone:"+getPhone()+"\nemail:"+getEmail();
    } 
    
   
    
}
