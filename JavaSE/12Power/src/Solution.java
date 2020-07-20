public class Solution {

    // 数值的整数次方
    // 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方

    public double Power(double base, int exponent) {
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
        if(exponent > 0){
            return result;
        }else{
            return 1/result;
        }
    }
}
