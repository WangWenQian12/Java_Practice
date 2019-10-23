import java.util.Comparator;

//复杂比较器
class ComplexComparator implements  Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.height - o2.height > 0){
            return 1;
        }else if(o1.height - o2.height == 0){
            return -1;
        }
        return 0;
    }
}

class PersonNameComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo (o2.name);
    }
}

class PersonHeightComparator implements  Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return (int)((o1.height - o2.height) * 100);
    }
}

public class Person implements Comparable<Person> {

    String name;
    int age;
    double height;
    int weight;
    String sex;



    @Override
    public int compareTo(Person o) {
        return age - o.age;

        /*if(age < o.age){
            return -1;
        }else if(age == o.age){
            return 0;
        }else{
            return 1;
        }*/
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Tom"; p.age = 18;p.height = 1.80;
        Person q = new Person();
        q.name = "James"; q.age = 20;q.height = 1.83;

        System.out.print ("按照年龄比较:" + " ");
        int r = p.compareTo (q);
        if(r>0){
            System.out.println ("Tom");
        }else if(r == 0){
            System.out.println ("一样");
        }else{
            System.out.println ("James");
        }

        //比较器
        Comparator<Person> comparator = new PersonNameComparator ();
        System.out.printf ("按照姓名比较:" + " ");
        int s = comparator.compare (p,q);
        if(s > 0){
            System.out.println ("Tom");
        }else if(s == 0){
            System.out.println ("相等");
        }else{
            System.out.println ("James");
        }

        Comparator<Person> comparatorheight = new PersonHeightComparator ();
        System.out.print ("按照身高比较:" + " ");
        int h = comparatorheight.compare (p,q);
        if(h > 0){
            System.out.println ("Tom高");
        }else if(h == 0){
            System.out.println ("一样");
        }else{
            System.out.println ("James高");
        }
    }
}
