
package findmin11;

import java.util.Scanner;

public class FindMin11 {
    public static double min(double[] array){
        int i=0;
        double min=array[0];
        for(i=0;i<array.length;i++){           
            if(array[i]<min){
                min=array[i];
            }         
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten numers:");
        double[] array = new double[10];
        int i=0;
        for(i=0;i<array.length;i++){
            array[i] = input.nextDouble();
        }
        double ret = min(array);
        System.out.println("The minimum number is:"+ret);              
    }
    
}
