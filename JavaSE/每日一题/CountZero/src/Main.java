import java.util.Scanner;

public class Main {

    // 输入一个正整数n，求n！（n的阶乘）末尾有多少个0
    // 思路：
    // 1.正常递归求阶乘，发现n过大时，其结果会溢出，所以放弃这种做法
    // 2.求末尾有几个0，其实是求这串阶乘中有几个10
    // 比如 10! = 10*9*8*7*6*5*4*3*2*1,其中一个10，还有一个5，它可以和任意一个数字凑一个因子2，2*5 = 10，那么我们就可以说10！结果中有俩个0
    // 3.所以我们的问题转换到了这列阶乘公式中有几个5（因子2肯定是多余5的个数的，找到5的个数，我们随时都可以将它凑为10）
    // 4.再注意25，625这种数字，25 = 5*5，625 = 5*5*5*5，所以我们在遍历阶乘公式时要除以5


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int count = 0;
        for(int i = 0;i < n;i++){
            n /= 5;
            count += n;
        }
        System.out.println (count);
    }


}
