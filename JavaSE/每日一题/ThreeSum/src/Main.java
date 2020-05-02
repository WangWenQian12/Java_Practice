import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // 求解数组中三数和为零的结果

    public static List threeSum(int[] arr){
        Arrays.sort (arr);
        List<Integer[]> list = new ArrayList<> ();
        for(int k = 0;k < arr.length;k++) {
            if (arr[0] > 0) {
                break;
            }
            if(arr[k] > 0 && arr[k] == arr[k-1]){
                continue;
            }
            int target = 0 - arr[k];
            int i = k+1;
            int j = arr.length - 1;
            while(i < j){
                if(arr[i] + arr[j] < target){
                    i++;
                }else if(arr[i] + arr[j] == target){
                    list.add (new Integer[]{arr[k],arr[i],arr[j]});
                    while(i < j && arr[i] == arr[i+1]){
                        i++;
                    }
                    while(i < j && arr[j] == arr[j-1]){
                        j--;
                    }
                    i++;
                    j--;
                }else{
                    j--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {-6,-4,-2,-5,3,4,1,2,6,5};
        List<Integer[]> list = threeSum (arr);
        for(Integer[] res : list){
            System.out.println (Arrays.toString (res));
        }
    }

}
