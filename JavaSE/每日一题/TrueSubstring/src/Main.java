import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    // 给出一个字符串 和 数字k，找出 ABA 式的字串，要求A的长度大于等于k
    // 例如：abcab,其中 ab为A , c为B

    public static void calc(String[] arr,int k){
        Set<String> set = new HashSet<> ();
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i].length () >= 2*k+1){
                if(judge(arr[i])){
                    count++;
                    set.add (arr[i]);
                }
            }
        }
        System.out.println (set);
        //return count;
    }

    public static boolean judge(String str){
        int i = 2;
        int j = str.length ()-2;
        while(i <= j){
            String str1 = str.substring (0,i);
            String str2 = str.substring (j,str.length ());
            if(str1 .equals ( str2) && i < j){
                return true;
            }else{
                i++;
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        int k = sc.nextInt ();
        String[] arr = new String[(str.length ()*(str.length ()+1))/2];
        int index = 0;
        for(int i = 0;i < str.length ();i++){
            for(int j = i+1;j <= str.length ();j++){
                arr[index++] = str.substring (i,j);
            }
        }
        //System.out.println (calc(arr,k));
        calc (arr,k);
    }

}
