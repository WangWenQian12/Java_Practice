public class Solution {

    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    public boolean isPalindrome(int x){
        int res = 0;
        int num = x;
        while(num > 0){
            res = res*10 + num%10;
            num /= 10;
        }
        return res== x;
    }
    
}
