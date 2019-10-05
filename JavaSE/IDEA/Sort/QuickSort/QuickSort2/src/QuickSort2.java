import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

    //挖坑法实现partition

    //快速排序：
    //1.在待排序区间中选一个数字当作基准值
    //2.遍历数组，将大于基准值的数字放到右边，小于基准值的数字放到左边
    //3.以基准值为分割点，将数组分为左右俩个区间，用分治的思想，以同样的方式处理左右小区间

    //和hoare的区别就是，hoare是交换，挖坑法是赋值

    public static void quickSort(int[] arr){
        quickSortInter(arr,0,arr.length-1);
    }

    public static void quickSortInter(int[] arr,int left,int right){
        if(left >= right){//数组长度小于等于1是返回
            return;
        }

        int pivotIndex = partition(arr,left,right);//找到分割大小区间的分割点

        quickSortInter (arr,left,pivotIndex-1);
        quickSortInter (arr,pivotIndex+1,right);
    }

    public static int partition(int[] arr,int left,int right){
        int begin = left;
        int end = right;
        int pivot = arr[left];//基准值
        while(begin < end){
            while(begin < end && arr[end] >= pivot){
                end--;
            }
            arr[begin] = arr[end];
            while(begin < end && arr[begin] <= pivot){
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = pivot;
        return begin;
    }


    public static void main(String[] args) {
        int[] arr = {7,4,5,2,6,3,2,8};
        quickSort (arr);
        System.out.println (Arrays.toString(arr));

        int[] a = new int[10*10000];
        Random random = new Random(20190927);
        for(int i = 0;i<10*10000;i++){
            a[i] = random.nextInt ();
        }

        long begin = System.nanoTime ();
        quickSort (a);
        long end = System.nanoTime ();

        double time = (end - begin)*1.0/1000/1000;
        System.out.printf ("耗时：%.5f毫秒",time);//约30ms
    }
}
