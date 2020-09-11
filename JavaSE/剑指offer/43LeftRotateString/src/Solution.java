public class Solution {

    // 左旋转数组

    public static String LeftRotateString(String str,int n) {
        if(str.length () == 0 ){
            return "";
        }
        if(str.length () == n){
            return str;
        }
        n = n % str.length ();
        return str.substring (n) + str.substring (0,n);

    }

    public static void main(String[] args) {
        String str = "123456";
        System.out.println (LeftRotateString(str,8));
    }
}