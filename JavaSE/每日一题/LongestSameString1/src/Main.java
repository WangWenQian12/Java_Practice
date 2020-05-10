import java.util.Scanner;

public class Main {

    // 找出两个字符串中长度最长的公共子串
    // 返回最长的公共子串，如果没有，返回-1

    public static void sameString(String s1,String s2){
        String max = s1.length () > s2.length () ? s1 : s2;
        String min = s1.length () > s2.length () ? s2 : s1;
        String res = "";
        int maxLength = -1;
        for(int i = 0;i < min.length ();i++){
            for(int j = i + 1;j <= min.length ();j++){
                if(max.contains (min.substring (i,j)) && j-i > maxLength){
                    maxLength = j - i;
                    res = min.substring (i,j);
                }
            }
        }
        if(maxLength == -1){
            System.out.println ("-1");
        }else{
            System.out.println (res);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s1 = sc.nextLine ();
        String s2 = sc.nextLine ();
        sameString (s1,s2);
    }
}

