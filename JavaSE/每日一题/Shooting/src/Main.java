import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //小仓酷爱射击运动。今天的小仓想挑战自我。小仓有N颗子弹，接下来小仓每次会自由选择K颗子弹进行连续射击，全中靶心的概率为p[k]。
    // 如果成功小仓将获得a[k]的得分，并且可以使用余下子弹继续射击，否则今天的挑战结束。小仓想知道在最佳策略下，自己能得到的最高期望分数是多少。

    public static double maxSocre(int n,double[] prob,int[] socre){
        double[] arr = new double[n];
        for(int i = 0; i < n;i++){
            double sum = 0.0;
            int count = n;
            while(count > 0){
             sum += socre[i] * (Math.pow (prob[i], count));
             count -= i+1;
            }
            arr[i] = sum;
        }
        Arrays.sort (arr);
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        double[] prob = new double[n];
        for(int i = 0;i < n;i++){
            prob[i] = sc.nextDouble ();
        }
        int[] socre = new int[n];
        for(int i = 0; i < n;i++){
            socre[i] = sc.nextInt ();
        }
        System.out.printf ("%.2f",maxSocre(n,prob,socre));
    }
}
