
package array_ave11;

import java.util.Scanner;

public class Array_Ave11 {

    public static void main(String[] args) {
        int[] nums1 = new int[10];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten int numbers:");
        int i=0;
        for(i=0;i<nums1.length;i++){
            nums1[i] = input.nextInt();
        }       
    
        double[] nums2 = new double[10];
        System.out.println("Enter ten double numbers:");
        for(i=0;i<nums2.length;i++){
            nums2[i] = input.nextDouble();
        } 
        System.out.println("The average of ten int values is "+average(nums1));
        System.out.println("The average of ten double values is "+average(nums2));
    }
    public static int average(int[] array) {
        int i=0;
        int sum=0;
        for(i=0;i<array.length;i++){
            sum += array[i];
        }
        return sum/array.length;
    }
    public static double average(double[] array) {
        int i=0;
        double sum=0;
        for(i=0;i<array.length;i++){
            sum += array[i];
        }
        return sum/array.length;
    }          
}
