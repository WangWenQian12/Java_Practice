public class WrapperClassDemo {

    public static void main(String[] args) {

        //包装类

        int i=10;
        System.out.println (i);

        Integer ii = i;//装箱
        //Integer ii = Integer.valueOf(i);
        System.out.println (ii);

        int j = ii;
        System.out.println (j);
        System.out.println ();

        i=11;
        System.out.println (i);
        //i的值改变，不会影响
        System.out.println (ii);
        System.out.println (j);
    }
}
