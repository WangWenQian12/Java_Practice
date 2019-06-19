
package sum4.pkg4.pkg11;

import java.util.Scanner;

public class Sum4411 {
    public static double sumMajorDiagonal (double[][] m){
        double sum=0;
        sum=m[0][0]+m[1][1]+m[2][2]+m[3][3];
        return sum;
    }
    public static void main(String[] args) {
        double[][] array = new double[4][4];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 4-by-4 matrix row by row:");
        int i=0; int j=0;
        for(i=0;i<array.length;i++){
            for(j=0;j<array[i].length;j++){
               array[i][j] = input.nextDouble();
            }
        }
       System.out.println("Sum of the elements in the major diagonal is "+sumMajorDiagonal(array));      
    }   
}
