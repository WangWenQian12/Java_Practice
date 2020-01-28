import java.util.Arrays;

public class Soultion {

    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    //思路：
    //1.根据k值将数组分为俩部分，俩个部分的数据反转
    //2.将整个数组反转

    public static void rotate(int[] nums,int k){
        int len = nums.length;
        k = k%len;
        if(len <= k){
            revolve(0,0,nums);
        }else{
            int kk = len-k;
            revolve(0,kk-1,nums);
            revolve(kk,len-1,nums);
            revolve (0,len-1,nums);
        }
    }

    public static void revolve(int i,int j,int[] arr){
        while(i < j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int k = 2;
        rotate(a,k);
        System.out.println (Arrays.toString (a));
    }
}
