public class ReplaceString {

    public static String replaceString(String str){

        return str.replace(" ","%20");

    }

    public static void main(String[] args) {

        System.out.println(replaceString("abc defgx yz"));
    }
}
