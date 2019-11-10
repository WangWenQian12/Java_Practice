import java.util.Scanner;

public class Main {

    //输入俩个字符串str1，str2，要求将str1中包含有str2的字符全部删除

    public static String deleteString(String str1,String str2){
        for(int i = 0;i < str2.length ();i++){
            //从str1中查找是否右str2中的字符，如果有，返回下标，否则返回-1
            int index = str1.indexOf (str2.charAt (i));
            if(index != -1){
                str1 = str1.replace (String.valueOf (str2.charAt (i)),"");
            }
        }
        return str1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String str1 = input.nextLine ();
        String str2 = input.nextLine ();
        System.out.println (deleteString (str1,str2));


    }
}
