
//给出一个包含n个整数的数列，问整数a在数列中的第一次出现是第几个。

import java.util.Scanner;

public class Main {


    public static int searchNumber(int[] arr,int key){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == key){
                return i+1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n = input.nextInt ();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length;i++){
            arr[i] = input.nextInt ();
        }
        int key = input.nextInt ();
        System.out.println (searchNumber (arr,key));
    }

}
