import java.util.Arrays;
import java.util.Random;

public class SelectSort {

    //选择排序
    //每一次从无序区间选出最大（或最小）的一个元素，存放在无序区间的最后（或最前），直到全部待排序的数据元素排完 。

    //时间复杂度：O(n^2)

    //无序区间[0 , arr.length-i)
    //有序区间[arr.length-i , arr.length)

    public static void selectSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            int max = 0;//将数组首元素看作是当前最大的元素
            for(int j = 1;j<arr.length-i;j++){
                if(arr[j] > arr[max]){//在无序期间中找到了最大的数字
                    max = j;//调整最大数字的下标
                }
            }
            swap(arr,max,arr.length-i-1);//将最大的数字放到数组的最后
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Random random = new Random(20190925);
        int[] arr = new int[10 *10000];
        for(int i = 0;i<10*10000;i++){
            arr[i] = random.nextInt ();
        }

        long begin = System.nanoTime ();
        selectSort (arr);
        long end = System.nanoTime ();
        double time = (end - begin)*1.0/1000/1000;

        System.out.printf ("耗时：%.5f毫秒%n",time);//5000ms

    }
}
