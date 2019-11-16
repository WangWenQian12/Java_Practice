import java.util.Scanner;

public class PlalindromeString {

    //俩个字符串，将字符串2插入到字符串1中得到新的字符串，看新的字符串中有几个是回文字符串

    public static boolean plalindromeString(String str){
        String newString = "";
        //System.out.println (str);
        for(int i = str.length ()-1; i >= 0;i--){
            newString += str.charAt (i);
        }
        if(newString.equals (str)){
            return true;
        }
        return false;
    }

    public static String[] mergeString(String str1,String str2){
        String[] str = new String[str1.length ()];
        String s1 = "";
        int j = 0;
        for(int i = 0;i < str1.length ();i++){
            String newStr = "";

            s1 += str1.charAt(i);
            String s2 = "";
            s2 += str1.substring (i+1);
            newStr += s1;
            newStr += str2;
            newStr += s2;
            str[j++] = newStr;
        }
        return str;
    }

    public static int countPlalindromeString(String[] str){
        int count = 0;
        for(int i = 0;i < str.length;i++){
            if(plalindromeString(str[i])){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String str1 = input.nextLine ();
        String str2 = input.nextLine ();
        //plalindromeString (str1);
        //System.out.println (plalindromeString (str1));
        //System.out.println (str1);
        //System.out.println (str2);
        String[] result = mergeString (str1,str2);
        System.out.println (countPlalindromeString (result));



    }

}
