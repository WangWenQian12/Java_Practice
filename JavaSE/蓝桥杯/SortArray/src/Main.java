import java.util.Scanner;
import java.util.Arrays;

public class Main {

    //给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200

    public static int[] sort(int[] a,int len){
        if(len>200){
            return null;
        }
        if(len<1){
            return null;
        }
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
        return a;
    }

    public static void swap(int[] a,int x,int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void print(int[] a,int len){
        for(int i=0;i<len;i++){
            System.out.print (a[i]+" ");
        }
        System.out.println ();
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println ("Please inter the capicity of the array:");
        int n = input.nextInt();
        int[] array = new int[n];
        System.out.println ("Please inter the array:");
        for(int i=0;i<n;i++){
            array[i] = input.nextInt();
        }
        print(sort(array,n),n);


    }
}
