import java.util.*;

public class Main {

    // 顺时针内旋数组

    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] arr = new int[n*m];
        int i = 0;
        int j = 0;
        int k = 0;
        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = m - 1;

        while(startX <= endX && startY <= endY){
            // 最后一行
            if(startX == endX){
                for(;j <= endY;j++){
                    arr[k++] = mat[endX][j];
                }
                return arr;
            }
            // 最后一列
            if(startY == endY){
                for(;i <= endX;i++){
                    arr[k++] = mat[i][endY];
                }
                return arr;
            }

            // 从左往右
            for(;j < endY;j++){
                arr[k++] = mat[i][j];
            }
            // 从上往下
            for(;i < endX;i++){
                arr[k++] = mat[i][j];
            }
            // 从右往左
            for(;j > startX;j--){
                arr[k++] = mat[i][j];
            }
            // 从下往上
            for(;i > startY;i--){
                arr[k++] = mat[i][j];
            }
            i++;
            j++;
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {98,30,17},
                {38,96,90},
                {17,0,50},{44,12,67},
                {12,79,43},
                {43,63,40},
                {19,93,48}};
        System.out.println (Arrays.toString (clockwisePrint (arr,7,3)));
    }
}