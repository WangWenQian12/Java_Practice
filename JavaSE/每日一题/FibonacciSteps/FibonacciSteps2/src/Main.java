import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class Main {

    //一个数字n，你想让它变为一个斐波那契数，每一步可以将数字变为n-1或n+1
    //现在给你一个数字n，求最小步数将其变为斐波那契数
    //思路：
    //1.最小的步数肯定是里这个数字最近的左右俩个数字
    //2.先计算斐波那契数，更新它左边的数字（num - 某一斐波那契数），直到此时计算的斐波那契数大于num，算出它右边的数字（斐波那契数 - num）
    //3.在这俩个数中取小的那一个

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt ();

        int f = 0,f0 = 0,f1 = 1;
        int leftSteps = 0;
        int rightSteps = 0;
        //int min = MAX_VALUE;

        while(true){
            f = f0 + f1;
            f0 = f1;
            f1 = f;
            if(f < num){
                leftSteps = num - f;
            }else{
                rightSteps = f - num;
                break;
            }
        }
        System.out.println (min(leftSteps,rightSteps));
    }

    private static int min(int i, int j) {
        return i > j ? j : i;
    }
}
