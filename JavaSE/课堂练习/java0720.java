class Person{
	public String name = null;
	public int gender = 0;//0f 1m
	public int age = 0;
	
	public String toString(){
		return String.format("Person:(%s,%d,%d)",name,gender,age);
	}
	
	//构造方法
	public Person(String n,int g,int a){  //n为引用类型，g和a是基本类型
		name = n;
		gender = g;
		age = a;
	}
}    


/*存储年月日信息，一切从用户出发
功能
   1）初始化
   2）传入年月日
   3）不传，今天
  */
class 



public class java0720{
	public static void main(String[] args){
		Person p = new Person("xiaobite",2,4);
		System.out.println(p.toString());
	}
}	