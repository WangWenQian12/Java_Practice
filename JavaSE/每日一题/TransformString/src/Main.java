import java.util.Scanner;

public class Main {

    // 字符串变换
    // 我有一个神奇的魔力，可以使字符串中认意位置的任意字符移动至字符串末尾，问目标字符串需要源字符串移动几次

    public static int transform(String sou,String des){
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < sou.length () && j < des.length ()){
            if(sou.charAt (i) == des.charAt (j)){
                i++;
                j++;
            }else{
                i++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()){
            String sou = sc.nextLine ();
            String des = sc.nextLine ();
            System.out.println (transform(sou,des));
        }
    }
}
