
package person11;

public class Student extends Person{
    private int grade;
    public static int ONE = 1;
    public static int TWO = 2;
    public static int THREE = 3;
    public static int FOUR = 4;
    
    public Student(String name,String address,
            String phone,String email,int grade){
        super(name, address, phone, email);
        this.grade = grade;
     }
     public void setGrade(int grade){
         this.grade = grade;
     }
     public int getGrade(){
         return grade;
     }
     public String toString(){
         return super.toString()+"\nGrade is:"+getGrade();
     }
    
    
}
