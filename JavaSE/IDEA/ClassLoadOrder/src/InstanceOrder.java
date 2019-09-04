class AA{
    int a = initA();
    private int initA(){
        System.out.println("AA初始化a");
        return 0;
    }
    static{
        System.out.println("aaaa");
    }

    {
        System.out.println("AA的构造代码块");
    }
    AA(int x){
        System.out.println("AA的有参构造方法");
    }
}

class BB extends AA{

    int b = initB();
    private int initB(){
        System.out.println("BB初始化b");
        return 0;
    }
    static{
        System.out.println("bbbb");
    }

    {
        System.out.println("BB的构造代码块");
    }
    BB(int x){
        super(x);
        System.out.println("BB的有参构造方法");
    }
    BB(){
        this(100);
        System.out.println("BB的无参构造方法");
    }
}


public class InstanceOrder {

    //类加载的顺序
    //1.静态代码块
    //2.初始化代码块
    //3.构造代码块
    //4.构造方法代码块

    public static void main(String[] args) {
        new BB();
    }
}


