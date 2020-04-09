import java.util.*;

public class Main {

    // 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
    //给定一个二位数组arr及题目中的参数n，请返回结果数组。

    public static int[] arrayPrint(int[][] arr, int n) {
        int[] res = new int[n*n];
        int row = 0;
        int col = n-1;
        int index = 0;
        while(row < n){
            int x = row;
            int y = col;
            while(x < n && y < n){
                res[index++] = arr[x++][y++];
            }
            if(col > 0){
                col--;
            }else{
                row++ ;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = { {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println (Arrays.toString (arrayPrint (arr,4)));
    }
}