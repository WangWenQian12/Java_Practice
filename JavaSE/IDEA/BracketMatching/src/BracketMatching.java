import java.util.ArrayList;

public class BracketMatching {

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //	左括号必须用相同类型的右括号闭合。
    //	左括号必须以正确的顺序闭合。
    //注意空字符串可被认为是有效字符串。
    //输入: "()[]{}"
    //输出: true
    //输入: "([)]"
    //输出: false

    //解题思路：
    //1.遍历字符串，如果是左括号，入栈
    //2.左括号全部入栈结束后，遍历遇到右括号，左括号出栈，判断是否匹配
    //3.如果在遍历过程中，放左括号的栈为空，说明右括号多，不匹配
    //4.如果遍历结束，放左括号的栈为空，说明匹配。如果不为空，说明左括号多


    public static boolean bracketMatching(String s){
        ArrayList<Character> stack = new ArrayList();
        //<>尖括号为泛型，直接收括号内类型的对象，即只接收char类型的对象


        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            //读取s字符串对应下标的元素
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.add(c);//入栈
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {//栈为空，说明右括号多
                        return false;
                    }
                    char left = stack.remove(stack.size() - 1);//依次出栈和右括号进行判断
                    if (!((left == '(' && c == ')')
                            || (left == '[' && c == ']')
                            || (left == '{' && c == '}'))) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else{//栈不为空，说明左括号多
            return false;
        }

    }


    public static void main(String[] args) {
        String s1 = "(([{}]))";
        String s2 = "([{}]))";
        if(bracketMatching(s2)){
            System.out.println("匹配");
        }
        else{
            System.out.println("不匹配");
        }
    }
}
