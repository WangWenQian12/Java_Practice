
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //子串判断

    //public static ArrayList<String[]> list = new ArrayList<> ();

    public static  boolean[] chkSubStr(String[] p, int n, String s){
        boolean[] res = new boolean[n];
        for(int i = 0;i < n;i++){
            res[i] = s.contains (p[i]);
        }
        return res;
    }


    /*public static  boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] res = new boolean[n];
        for(int i = 0; i < n;i ++){
            res[i] = false;
        }
        for(int i = 0 ; i < p.length;i++){
            for(int j = 0;j < s.length ();j++ ){
                if(p[i].charAt (0) != s.charAt (j)){
                    continue;
                }
                else{
                    int size = p[i].length ();
                    String str = s.substring (j,j+size);
                    if(p[i].equals (str)){
                        res[i] = true;
                    }
                }
            }
        }
        return res;
    }

    /*public static String arrToStr(int[] t,int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(t[i]);//附加此字符
            if (i != n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }


    public static void allOrder(int n,String[] s,int begin){
        if(begin == n-1){
            String[] ret = s.clone ();
            list.add (ret);
            return;
        }
        for(int i = 0; i < n;i++ ){
            swap(s,i,begin);
            allOrder (n,s,begin+1);
            swap(s,i,begin);
        }

    }

    public static void swap(String[] s,int i,int j){
        String tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }*/


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        int n = sc.nextInt ();
        String[] arr = new String[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.next ();
        }
        System.out.println (Arrays.toString (chkSubStr (arr,n,str)));

    }
}
