import java.util.Scanner;

public class Main {
    // 整除

    public static int calc(String str,int key){
        int count = 0;
        for(int i = 0;i < str.length() - 1;i++){
            for(int j = i + 1;j < str.length();j++){
                String s1 = str.substring (i,j);
                String s2 = str.substring (j,str.length ());
                calc(s2,key);
                long num1 = Integer.parseInt (s1);
                long num2 = Integer.parseInt (s2);

                if(num1 % key == 0 && num2 % key == 0){
                    count++;
                }
            }
        }
        return count % 1000000007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = Integer.parseInt (sc.nextLine ());
        int[] res = new int[n];
        for(int i = 0; i < n;i++) {
            String s = sc.nextLine ();
            String[] arr = s.split (" ");
            int m = Integer.parseInt (arr[0]);
            int key = Integer.parseInt (arr[1]);
            String str = sc.nextLine ();
            res[i] = calc (str,key);
        }
        for(int r : res){
            System.out.println (r);
        }
    }
}
