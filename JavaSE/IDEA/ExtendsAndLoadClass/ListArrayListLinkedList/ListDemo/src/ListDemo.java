import java.util.List;
import java.util.ArrayList;

public class ListDemo {

    //线性表

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        //添加
        a.add("你");
        a.add("真棒");
        a.add("你就是");
        a.add("小天才");
        //按照添加顺序打印
        System.out.println (a);
        //类似于数组下标访问
        System.out.println (a.get(3));

        //修改
        a.set(3,"代码");
        a.add("小天才");
        System.out.println (a);

        //截取部分[2,5）
        List<String> sub = a.subList(2,5);
        System.out.println (sub);

        //重新构造
        List<String> b = new ArrayList<>(a);
        System.out.println (b);
    }
}
