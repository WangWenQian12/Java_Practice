public class Solution {

    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
    // 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    // 迭代（时间复杂度O(n)）

    public int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        int pre1 = 1;
        int pre2 = 2;
        for(int i = 3;i <= target;i++){
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}