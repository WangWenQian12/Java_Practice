public class Solution {

    // 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
    // 数值为0或者字符串不是一个合法的数值则返回0

    public static int StrToInt(String str) {
        int res = 0;
        int flag = 0;
        for(int i = 0;i < str.length ();i++){
            if(!isLegal(str.charAt (i))){
                return 0;
            }
            if(str.charAt (i) == '+'){
                flag = 1;
            }else if(str.charAt (i) == '-'){
                flag = 2;
            }else {
                int tmp = str.charAt (i) - '0';
                res = res * 10 + tmp;
            }
        }
        if(flag == 1){
            return res;
        }else if(flag == 2){
            return -res;
        }else {
            return res;
        }
    }

    public static boolean isLegal(char c){
        if(c == '+'){
            return true;
        }
        if(c == '-'){
            return true;
        }
        if(c == '0' || c == '1'|| c == '2' || c == '3'
                || c == '4'|| c == '5'|| c == '6'
                || c == '7'|| c == '8'|| c == '9'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println (StrToInt ("+123"));
    }
}
