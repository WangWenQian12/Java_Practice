import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BrokenKeyBoard {

    //旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
    // 现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键的大写。


    public static void brokenKeyBoard(String input,String output){
        Set<Character> set = new TreeSet<> ();

        //先将输出的字符放进set中
        for(char n : output.toCharArray ()){
            set.add(n);
        }

        //遍历输入字符串，如果没出现在输出字符中，说明这个键是坏的
        //再下黄健一个集合用来存放坏的键
        //在要注意大小写区分，因为要求输出坏掉的键的大写，所有先将不存在输出字符串中的数字转换为大写输出，然后将其坏键列表中
        Set<Character> written = new TreeSet<> ();
        for(char s : input.toCharArray ()){
            if(!set.contains (s)) {
                s = Character.toUpperCase (s);//将所有字母转换为大写
                if (!written.contains (s)) {
                    System.out.print (s + " ");
                    written.add (s);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println ("Please inter the true sentence:");
        String in = input.nextLine ();
        System.out.println ("Please inter the wrong sentence:");
        String out = input.nextLine ();

        brokenKeyBoard (in,out);
    }
}
