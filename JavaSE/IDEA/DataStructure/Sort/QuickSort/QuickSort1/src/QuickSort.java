import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    //Hoare 法完成 partition

    //快速排序：
    //1.在排序区间内取一个基准值
    //2.遍历数组，把比基准值大的数字放到右边，比基准值小的放到左边
    //3.此时以基准值为分割点，将数组分为俩个小区间，利用分治的思想，对左右的小区间用同样的方式处理

    public static void quickSort(int[] arr){
        quickSortInter (arr,0,arr.length-1);
    }

    public static void quickSortInter(int[] arr,int left,int right){
        if(left >= right){//当数组长度小于等于1时return
            return;
        }
        int pivotIndex = partition(arr,left,right);//基准值下标

        //递归方法，用partition将数组分为左右俩个小数组，用同样的方法将小数组分割，直至小数组元素个数小于等于1
        quickSortInter (arr,left,pivotIndex-1);
        quickSortInter (arr,pivotIndex+1,right);

    }

    public static int partition(int[] arr,int left,int right){
        int begin = left;
        int end = right;
        int pivot = arr[left];
        //遍历整个数字，以基准值为标准分割数组
        while(begin < end) {
            while (begin < end && arr[end] >= pivot) {
                end--;
            }
            while (begin < end && arr[begin] <= pivot) {
                begin++;
            }
            swap(arr,begin,end);
        }
        // 遍历完整个数组后，begin的位置是小于pivot的最后一个数字，将其与left（基准值）的值交换
        // 此时begin左边的都是小于基准值的数字，右边都是大于基准值的数字，成功将数字分割
        swap(arr,begin,left);
        return begin;
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        /*int[] arr = {6,3,7,5,8,9,2,4};
        quickSort (arr);
        System.out.println (Arrays.toString(arr));*/

        int[] a = new int[10*10000];
        Random random = new Random(20190927);
        for(int i = 0;i<10*10000;i++){
            a[i] = random.nextInt ();
        }

        long begin = System.nanoTime ();
        quickSort (a);
        long end = System.nanoTime ();

        double time = (end - begin)*1.0/1000/1000;
        System.out.printf ("耗时：%.5f毫秒",time);//30ms左右

    }
}
