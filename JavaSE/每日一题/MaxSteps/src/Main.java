import java.util.Scanner;

public class Main {

    // 空间回廊
    // 这个游戏的最终目的是为了在这些房间中留下尽可能多的烙印，
    // 在每个房间里留下烙印所花费的法力值是不相同的，已知他共有m点法力值，这些法力是不可恢复的。
    // 小明刚接触这款游戏，所以只会耿直的玩，所以他的每一个行动都是可以预料的：
    // 1. 一开始小明位于1号房间。
    // 2. 如果他剩余的法力能在当前的房间中留下一个烙印，那么他就会毫不犹豫的花费法力值。
    // 3. 无论是否留下了烙印，下一个时刻他都会进入下一个房间，如果当前位于i房间，则会进入i+1房间，如果在n号房间则会进入1号房间。
    // 4. 当重复经过某一个房间时，可以再次留下烙印。
    // 很显然，这个游戏是会终止的，即剩余的法力值不能在任何房间留下烙印的时候，游戏终止。请问他共能留下多少个烙印。

    public static int calc(int[] arr,int m){
        int steps = 0;
        int flag = 0;
        while(m > 0){
            for(int i = 0;i < arr.length ;i++){
                if(m >= arr[i]){
                    m -= arr[i];
                    steps++;
                    flag++;
                }
            }
            if(flag == 0){
                break;
            }else{
                flag = 0;
            }
        }
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == m){
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt ();
        }
        System.out.println (calc(arr,m));
    }
}
