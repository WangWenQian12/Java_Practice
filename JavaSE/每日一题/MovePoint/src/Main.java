import java.util.*;

public class Main{

    // 坐标移动
    // 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
    // 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
    // 输入：合法坐标为A(或者D或者W或者S) + 数字（两位以内）坐标之间以;分隔。
    // 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。

    public static void movePoint(String[] arr){
        int x = 0;
        int y = 0;
        for(int i = 0; i < arr.length;i++){
            String s = arr[i];
            if(isLegal(s)){
                if(s.charAt(0) == 'A'){
                    x -= Integer.valueOf(s.substring(1));
                }else if(s.charAt(0) == 'D'){
                    x += Integer.valueOf(s.substring(1));
                }else if(s.charAt(0) == 'W'){
                    y += Integer.valueOf(s.substring(1));
                }else if(s.charAt(0) == 'S'){
                    y -= Integer.valueOf(s.substring(1));
                }
            }
        }
        System.out.println(x + "," + y);
    }

    public static boolean isLegal(String str){
        if(str.length () <= 1){
            return false;
        }
        int flag = 0;
        if(str.charAt(0) == 'A' || str.charAt(0) == 'D' ||
                str.charAt(0) == 'W' || str.charAt(0) == 'S'){
            String s = str.substring(1);
            for(int i = 0; i < s.length();i++){
                if(s.charAt(i)<= '9' && s.charAt(i) >= '0'){
                    flag = 1;
                }else{
                    flag = 2;
                    break;
                }
            }
        }
        return flag == 1 ? true : false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(";");
            movePoint(arr);
        }
    }
}