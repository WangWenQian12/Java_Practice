import java.util.Scanner;
//错排算法（排列组合）
//我们拿5来说事，首先5个人来进行抽奖，有多少种抽法？
//因为是不放回抽，所以第一个人有5种抽法，
//第二个人有4种抽法，依次类推
//总共就是5！ 对有5的阶乘种抽法。这是分母
//那可想而知分子就是存在多少种情况每个人拿不到自己的名字。
//这里要应用错排算法。
//简单的做个介绍
//当n个编号元素放在n个编号位置，元素编号与位置编号各不对应的方法数用D(n)表示，
//那么D(n-1)就表示n-1个编号元素放在n-1个编号位置，各不对应的方法数，其它类推.
//第一步，把第n个元素放在一个位置，比如位置k，一共有n-1种方法；
//第二步，放编号为k的元素，这时有两种情况：把它放到位置n，那么，对于剩下的n-1个元素，
//由于第k个元素放到了位置n，剩下n-2个元素就有D(n-2)种方法；
//第k个元素不把它放到位置n，这时，对于这n-1个元素，有D(n-1)种方法；
//综上得到递推公式，可以发现可以用递归来做；
//D(n) = (n-1) [D(n-2) + D(n-1)]
//特殊地，D(1) = 0, D(2) = 1.
//那么D(5)=4*[D(3)+D(4)]；依次求得D(3)、D(4),最后D(5)=44
//所以5个人拿不到奖的概率就是44/120=36.67%

public class Main{

    // 有多少种可能，每个人拿不到自己的名字（分子）
    public static float count(int n) {
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        return (n-1)*(count(n-1)+count(n-2));

    }
    //下面的函数用来求阶乘，也是递归（分母）
    public static float probability(int n){
        if(n==0){
            return 1; // 0的阶乘为1
        }else{
            return n*probability(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            float result = (count(n)/probability(n))*100;
            System.out.println(String.format("%.2f", result) + "%");
        }
    }
}