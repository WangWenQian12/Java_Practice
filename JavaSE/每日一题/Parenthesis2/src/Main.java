import java.util.Scanner;

public class Main {

    //判断输入字符是否为合法的括号匹配的字符串
    //思路：
    //1.遍历字符串，设置计数器count，遇到左括号，count++，遇到右括号，count--
    //2.遍历结束后，如果count=0，说明匹配，反之不匹配

    public static boolean isParenthesis(String str){
        int count = 0;
        for(int i = 0;i < str.length ();i++){
            if(str.charAt (i) == '('){
                count++;
            }else if(str.charAt (i) == ')'){
                count--;
            }else{
                continue;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String str = input.nextLine ();
        System.out.println (isParenthesis (str));
    }
}
