import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //打印一个 n*n 螺旋矩阵
    //当n为偶数时，打印 n/2 圈。当n为奇数时，打印 n/2+1 圈

    public static int[][] helixMatrix(int n){
        int[][] arr = new int[n][n];

        int i = 0,j = 0;//数组下标
        int num = 1;//螺旋矩阵第一个打印的数字
        int steps = 0;//控制打印圈数

        int times = (n%2)==1 ? (n/2)+1 : n/2;//打印的圈数

        for(int t = times ; t >= 0;t--){

            while(j < n - steps){
                arr[i][j] = num++;
                j++;
            }
            j--;//最后一次循环的判断条件j++多加了一次，j--之后是数组的最后一列
            i++;//第二行

            while(i < n - steps){
                arr[i][j] = num++;
                i++;
            }
            i--;//同上
            j--;//j回到倒数第二列

            while(j >= steps){
                arr[i][j] = num++;
                j--;
            }
            j++;
            i--;//倒数第二行

            //当打印第一圈，即steps等于0时，左侧打印到steps+1 = 2行（第一圈打印）
            //当打印第一圈，即steps等于1时，左侧打印到steps+2 = 3行（第二圈打印）
            while(i >= steps + 1){
                arr[i][j] = num++;
                i--;
            }
            i++;
            j++;//第二列

            steps++;//控制打印圈数

        }
        return arr;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[][] res = helixMatrix(n);
        for(int i = 0;i < res.length;i++){
            for(int j = 0;j < res[i].length;j++){
                System.out.print (res[i][j]+" ");
            }
            System.out.println ();
        }


    }


}
