import java.util.Scanner;

public class Main {

    //输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
    //思路：先判断是否为回文数字，如果是，再判断是否为5位数和6位数

    public static void printPlain(int n){

        for(int i=10000;i<=999999;i++){//求的是五位数和六位数，可通过控制n降低时间复杂度
            int sum=0;
            int len=0;
            int tmp=i;
            while(tmp != 0) {//先判断是否为回文数
                sum = sum*10 + tmp%10;
                tmp /= 10;
                len++;//用来记录是几位数
            }
            if(sum==i){
                int a = i%10;//i的各位
                int b = i/10%10;//i的十位
                int c = i/100%10;//i的百位

                if(len==5){
                    if(n==(2*a +2*b +c)){//利用回文数的特点来求i的各位和
                        System.out.println (i);
                    }
                }
                if(len==6){
                    if(n==(2*a +2*b +2*c)){
                        System.out.println (i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        printPlain(n);
    }
}
