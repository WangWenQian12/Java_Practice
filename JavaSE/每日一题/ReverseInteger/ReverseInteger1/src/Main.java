import java.util.Scanner;

public class Main {

    //输入一个整数，将这个数字以字符串的形式逆序输出，不考虑负数的问题

    public static String reverseInteger(int num){

        //将数字转换为字符串
        String s = String.valueOf (num);
        //String s = Integer.toString (num);

        //逆转字符串
        char[] arr = s.toCharArray ();
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            swap(arr,i,j);
            i++;
            j--;
        }

        String res = "";
        for(int m = 0;m < arr.length;m++){
            res += arr[m];
        }

        return res;
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt ();
        System.out.println (reverseInteger (num));
    }
}
