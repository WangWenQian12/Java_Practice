
public class Solution {

    //你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
    //你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        char[] n = name.toCharArray ();
        char[] t = typed.toCharArray ();
        while(i < name.length () && j < typed.length ()){
            if(n[i] == t[j]){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(i == name.length ()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String name = "kikcxmvzi";
        String typed = "kiikcxxmmvvzz";
        System.out.println (isLongPressedName (name,typed));
    }
}
