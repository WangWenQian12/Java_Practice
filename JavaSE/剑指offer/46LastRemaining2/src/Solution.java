public class Solution {

    // 圆圈中最后剩下的数

    public static int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % n;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println (LastRemaining_Solution (5,3));
    }
}
