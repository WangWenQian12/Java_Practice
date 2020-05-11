import java.util.Scanner;

public class Main {

    // 找出两个字符串中的最长公共子串
    // 动态规划

    public static String sameString(String s1,String s2) {
        String max = s1.length () > s2.length () ? s1 : s2;
        String min = s1.length () > s2.length () ? s2 : s1;

        int[][] dp = new int[min.length ()][max.length ()];
        int end_index = -1;
        int maxLength = -1;
        for (int i = 0; i < min.length (); i++) {
            for (int j = 0; j < max.length (); j++) {
                if (min.charAt (i) == max.charAt (j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        end_index = j;
                    }
                }
            }
        }
        for(int i = 0;i < s1.length ();i++){
            for(int j = 0;j < s2.length ();j++){
                System.out.print (dp[i][j] + " ");
            }
            System.out.println ();
        }

        end_index = end_index + 1;
        String res = max.substring (end_index - maxLength, end_index);
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s1 = sc.nextLine ();
        String s2 = sc.nextLine ();
        System.out.println (sameString(s1,s2));
        // sameString (s1,s2);
    }

}
