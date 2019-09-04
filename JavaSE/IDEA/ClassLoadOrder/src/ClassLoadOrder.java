class A{
    static{
        System.out.println("这是A的静态代码块！");
    }
}

class B extends A{
    static{
        System.out.println("这是B的静态代码块！");
    }
}

public class ClassLoadOrder {

    public static void main(String[] args) {
        System.out.println("start!");
        new B();
        System.out.println("end!");
    }
}
