import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    // 把数组排成最小的数

    public static String PrintMinNumber(int [] numbers){
        ArrayList<Integer> list = new ArrayList<> ();
        for(int n : numbers){
            list.add (n);
        }

        Collections.sort(list, new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                int s = s1.compareTo (s2);
                return s1.compareTo (s2);
            }
        });

        String result = "";
        for(int n : list){
            result += n;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,32,321};
        System.out.println (PrintMinNumber (arr));
    }
}