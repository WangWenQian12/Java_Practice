import java.util.ArrayList;

public class Solution {

    // 输出所有和为S的连续正数序列

    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        for(int i = 1;i < sum-1;i++){
            ArrayList<Integer> list = new ArrayList<Integer> ();
            int num = i;
            list.add (i);
            for(int j = i+1;j < sum;j++){
                num += j;
                list.add (j);
                if(num == sum){
                    res.add (list);
                    break;
                }else if(num > sum){
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println (FindContinuousSequence (9));
    }
}