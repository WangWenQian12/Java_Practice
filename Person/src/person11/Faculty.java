
package person11;

public class Faculty extends Employee{
    private String worktime;
    private String rank;
    
    public Faculty(String name,String address,String phone,String email,int office,double salary,String worktime,String rank){
        super(name,address,phone,email,office,salary);
        this.worktime = worktime;
        this.rank = rank;
    }
    
    public void setWorkTime(String worktime){
        this.worktime = worktime;
    }
    public String getWorkTime(){
        return worktime;
    }
    public void setRank(String rank){
        this.rank = rank;
    }
    public String getRank(){
        return rank;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nWorktime:"+getWorkTime()
                +"\nRank:"+getRank();
    }
    
}
