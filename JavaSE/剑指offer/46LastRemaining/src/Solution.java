import java.util.ArrayList;

public class Solution {

    // 圆圈中最后剩下的数

    public static int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<> ();
        for(int i = 0;i < n;i++){
            list.add (i);
        }
        int cur = -1;
        while(list.size () > 1){
            // 一直报m数
            for(int i = 0;i < m;i++){
                cur++;
                if(cur == list.size ()){
                    cur = 0;// 回到顺序表头
                }
            }
            list.remove (cur);
            cur--; // 保证下一次循环是从cur开始的
        }
        return list.get (0);
    }

    public static void main(String[] args) {
        System.out.println (LastRemaining_Solution (5,3));
    }
}