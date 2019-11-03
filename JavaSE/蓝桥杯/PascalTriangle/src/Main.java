
       //杨辉三角形
       //输入包含一个数n。
       //输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。请不要在前面输出多余的空格。

       import java.lang.reflect.Array;
       import java.util.Arrays;
       import java.util.Scanner;

       public class Main {


    public static int[][] pascalTriangle(int n){
        int[][] array = new int[35][35];

        for(int i = 0;i<n;i++) {
            array[i][0] = 1;
            array[i][i] = 1;
        }
        for(int i = 2;i < n;i++){
            for(int j = 1;j < i;j++){
                array[i][j] = array[i-1][j-1] + array[i-1][j];
            }
        }
        return array;

    }

    public static void main(String[] args) {
        int[][] array = new int[35][35];
        Scanner input = new Scanner(System.in);
        int n = input.nextInt ();
        array = pascalTriangle (n);
        for(int i = 0;i< n;i++){
            for(int j = 0;j <= i;j++){
                System.out.print (array[i][j]+" ");
            }
            System.out.println ();
        }



    }


}
