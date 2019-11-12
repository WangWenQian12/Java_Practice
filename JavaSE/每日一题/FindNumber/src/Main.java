import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //输入n个整数，输出出现次数大于等于数组长度一半的数字

    public static HashMap<Integer, Integer> calcCountsOfNumber(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<> ();
        for(int num :arr ){
            int count = map.getOrDefault (num,0);//在map中查找key是否白含有num，没有返回0，有返回其value
            map.put (num,count+1);//更新key对应的value
        }
        return map;
    }

    public static int findNumber(HashMap<Integer,Integer> map,int n){

        HashMap<Integer,Integer> res = new HashMap<> ();

        for(Map.Entry<Integer,Integer> e : map.entrySet ()){
            int count = e.getValue ();
            int num = e.getKey ();

            if(!res.containsKey (count)){
                res.put (count,num);
            }
        }

        for(Map.Entry<Integer,Integer> e : res.entrySet ()){
            if(e.getKey () >= n/2){
                return e.getValue ();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        //未知长度的数组
        //先将其当作一个字符串接收，再根据空格进行分割，此时字符串的长度即为数组的长度
        String s = input.nextLine ();
        String[] c = s.split (" ");
        int[] arr = new int[c.length];
        for(int i = 0; i < c.length;i++){
            arr[i] = Integer.parseInt (c[i]);//将string类型转换为int类型
        }
        System.out.println (findNumber (calcCountsOfNumber (arr),arr.length));
    }

}
