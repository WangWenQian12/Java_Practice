public class Solution {

    //给定两个二进制字符串，返回他们的和（用二进制表示）。
    //输入为非空字符串且只包含数字 1 和 0

    public static String addBinary(String a, String b) {
        String res = "";
        String addend = ""; //加数
        String augend = ""; //被加数

        //较长字符串为加数，较短字符串为被加数
        if(a.length () > b.length ()){
            addend = a;
            augend = b;
        }else{
            addend = b;
            augend = a;
        }

        //被加数前补0，直至长度和加数相等
        int len = addend.length () - augend.length ();
        for(int i = 0; i < len;i++){
            augend = "0" + augend;
        }

        int flag = 0;//如果同位相加需要进位时将flag置为1
        for(int i = addend.length ()-1;i>=0;i--){
            char add = addend.charAt (i);
            char aug = augend.charAt (i);

            int sum = (add - 48) + (aug -48);//将字符转为数字相加

            int r = sum + flag;
            if(r >= 2){
                flag = 1;
                res = String.valueOf (r%2) + res;
            }else{
                flag = 0;
                res = String.valueOf (r) + res;
            }
        }

        //最高位进位
        if(flag == 1){
            res = String.valueOf (1) + res;
        }

        return res;
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println (addBinary (a,b));
    }
}
