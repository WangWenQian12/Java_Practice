import java.util.Stack;

public class Main {

    //检测输入字符串括号是否匹配
    //思路：
    //1.遍历字符串，左括号入栈，当遇到右括号时，栈顶元素出栈，看是否与当前右括号匹配

    public static boolean chkParenthesis(String str){
        Stack<Character> stack = new Stack<> ();
        for(int i = 0;i < str.length ();i++){
            char c = str.charAt (i);
            switch(c){
                case '(':
                    stack.add (c);
                    break;
                case ')':
                    if(stack.isEmpty ()){
                        return false;
                    }
                    if(stack.remove (stack.size ()-1) != '('){
                        return flase;
                    }
                    break;
                    default:
                        break;

            }
        }
        if(stack.isEmpty ()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
         Scanner input = new Scanner (System.in);
        String str = input.nextLine ();
        System.out.println (chkParenthesis (str));
    }
}
