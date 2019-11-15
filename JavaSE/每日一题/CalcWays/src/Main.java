import java.util.Scanner;

public class Main {

    //一个x*y的网格，机器人站在左上角，目标地址右下角
    //机器人只能向右向下走，问有多少种走法

    //动态规划

    public static int calcWays(int x,int y){
        int[][] dp = new int[x][y];
        for(int i = 0;i < x;i++){
            dp[i][0] = 1;
        }

        for(int j = 0;j < y;j++){
            dp[0][j] = 1;
        }

        for(int i = 1;i < x;i++){
            for(int j = 1;j < y;j++){
                dp[i][j] = dp[i - 1][j] +dp[i][j - 1];
            }
        }

        return dp[x-1][y-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int x = sc.nextInt ();
        int y = sc.nextInt ();
        System.out.println (calcWays(x,y));
    }
}
