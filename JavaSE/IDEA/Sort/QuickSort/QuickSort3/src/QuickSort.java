import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    //用前后遍历法实现partition

    //快速排序：
    //1.在待排序区间内找到一个数字作为基准值
    //2.遍历数组，大于基准值的放到数字右边，小于基准值的数字放到数组左边
    //3.以基准值为分割点，分为左右俩个小区间，以分治的思想，用同样的方式处理左右俩个小区间

    public static void quickSort(int[] arr){
        quickSortInter (arr,0,arr.length-1);
    }

    public static void quickSortInter(int[] arr,int left,int right){
        if(left >= right){//数组长度小于等于1时返回
            return;
        }
        int pivotIndex = partition(arr,left,right);//找到能分割左右区间的分割点

        quickSortInter (arr,left,pivotIndex-1);
        quickSortInter (arr,pivotIndex+1,right);
    }

    public static int partition(int[] arr,int left,int right){
        int pivot = arr[left];
        int d = left+1;
        for(int i = left+1;i <= right;i++){
            //遍历时如果大于，i++，d不动，当遇到小于pivot的值时，将下标为i和d的元素交换，d++
            if(arr[i] < pivot){
                swap(arr,i,d);
                d++;
            }
        }
        swap(arr,d-1,left);
        return d-1;

    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,4,5,8,9,2,4};
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
        System.out.printf ("耗时：%.5f毫秒",time);//约15ms
    }
}
