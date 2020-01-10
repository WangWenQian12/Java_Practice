import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //给定一个k为整数，求它每一位上的数字出现的次数
    //按照每一位上的数字的升序输出

    public static HashMap<Integer,Integer> countNum(String num){
        HashMap<Integer,Integer> map = new HashMap<> ();

        String[] c = num.split ("");
        for(int i = 0; i< c.length ;i++){
            int n = Integer.parseInt (c[i]);//转为整型
            int x = map.getOrDefault (n,0);
            map.put (n,x+1);
        }

        return map;
    }

    public static void upSort(HashMap<Integer,Integer> map){
        for(Map.Entry<Integer,Integer> e : map.entrySet ()){
            int keys = e.getKey ();
            int count = e.getValue ();
            System.out.println (keys + ":" + count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        //int n = sc.nextInt ();
        //数字过大时用字符串接收
        String s = sc.nextLine();
        upSort (countNum (s));
    }

}
