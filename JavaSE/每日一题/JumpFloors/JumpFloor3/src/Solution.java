public class Solution {

    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
    // 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    // 自底向上型循环：时间复杂度为O(n)

    public int JumpFloor(int target) {
        int a = 1, b = 1;
        for (int i = 1; i < target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}