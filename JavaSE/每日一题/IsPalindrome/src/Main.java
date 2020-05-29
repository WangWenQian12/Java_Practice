import java.util.*;

public class Main{

    // 给定一个字符串，问是否能通过添加一个字母将其变为回文串。

    public static String judge(String str){
        int i = 0;
        int j = str.length()-1;
        int flag = 0;
        if(i < j){
            while(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }
            str = str.substring(i,j+1);
            if(isPali(str.substring(0,str.length()-1))){
                flag++;
            }
            if(isPali(str.substring(1,str.length()))){
                flag++;
            }
        }
        return flag == 0 ? "NO" : "YES";
    }

    public static boolean isPali(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{
                break;
            }
        }
        return i >= j ? true : false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(judge(str));
        }
    }
}