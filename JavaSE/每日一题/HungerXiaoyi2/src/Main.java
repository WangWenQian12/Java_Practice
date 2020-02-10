import java.util.Scanner;

public class Main {

    //饥饿的小易

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        long n = sc.nextInt ();//初始位置
        long m = 1000_000_007;//被模的数
        long power = 100000;//可移动的能力的次数

        long[] begin = new long[3];//存放每次执行f(x)所移动的位置
        begin[0] = n;
        begin[1] = (4 * begin[0] + 3) % m;
        begin[2] = (4 * begin[1] + 3) % m;

        long minsteps = power;
        long cur = 0;
        int steps = 0;//执行的步数

        for(int i = 0; i < 3;i++){
            cur = begin[i];
            steps = i;
            while(cur != 0 && steps < minsteps){
                cur = (8 * cur + 7) % m;
                steps++;
            }
            minsteps = minsteps < steps ? minsteps : steps;
        }

        if(minsteps < power){
            System.out.println (minsteps);
        }else{
            System.out.println (-1);
        }

    }
}
