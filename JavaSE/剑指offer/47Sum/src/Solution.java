public class Solution {

    // 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    // 等差数列和 （a1 + an）n/2
    // 除以二等一右移一位

    public int Sum_Solution(int n) {
        int res =(int)( n + Math.pow (n,2));
        return res >>1;
    }
}