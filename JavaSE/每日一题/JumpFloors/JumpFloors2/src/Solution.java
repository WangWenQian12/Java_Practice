public class Solution {

    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    // 求该青蛙跳上一个n级的台阶总共有多少种跳法。

    // f(n) = f(n-1) + f(n-2) + …… + f(0)
    // f(n-1) = f(n-2) + …… + f(0)
    // 转移方程：f(n) = 2f(n-1)

    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }
}