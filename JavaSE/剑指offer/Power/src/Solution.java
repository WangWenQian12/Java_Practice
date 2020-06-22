public class Solution {

    // 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    // 保证base和exponent不同时为0

    public static double Power(double base, int exponent) {
        if(base == 0.0 && exponent == 0){
            return 0.0;
        }
        if(base == 0.0){
            return 0.0;
        }
        if(exponent == 0){
            return 1.0;
        }

        double result = 1.0;
        for(int i = 0;i < Math.abs (exponent);i++){
            result *= base;
        }
        if(exponent < 0){
            result = 1/result;
        }
        return result;
    }

    public static void main(String[] args) {
        double a = 2;
        int b = -3;
        System.out.println (Power (a,b));
    }
}