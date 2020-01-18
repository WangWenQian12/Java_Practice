import java.util.HashMap;
import java.util.Map;

public class Main {


    //找出数组中元素个数超过数组长度一半的元素

    public static int getValue(int[] gifts, int n) {
        // write code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < gifts.length;i++){
            int count = map.getOrDefault (gifts[i],0);
            map.put(gifts[i],count+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key = e.getKey();
            int value = e.getValue();
            if(value > n/2){
                return key;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,5};
        System.out.println (getValue (arr,6));
    }
}
