public class StringDemo {

    public static void main(String[] args) {
        char[] value ={'w','w','q','t'};
        String s = new String (value);
        System.out.println (s);

        String t = new String (value,1,2);
        System.out.println (t);
    }
}
