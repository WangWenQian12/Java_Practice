import java.util.Arrays;
import java.util.Random;

public class SelectSort {

    //选择排序，从无序区间中找到最小的数字放到有序区间中

    public static void selectSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr,min,i);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10 *10000];
        Random random = new Random (20190925);
        for(int i = 0;i<10*10000;i++){
            arr[i] = random.nextInt();
        }

        long begin = System.nanoTime ();
        selectSort (arr);
        long end = System.nanoTime ();

        double time = (end-begin)*1.0/1000/1000;
        System.out.printf ("耗时：%.5f毫秒",time);//5000ms

    }
}
