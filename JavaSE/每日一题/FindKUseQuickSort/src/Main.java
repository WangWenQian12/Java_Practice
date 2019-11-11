import java.util.Scanner;

public class Main {

    //利用快排找到数组中第k大的数字
    //快排：
    //1.我们先以数组的第一个元素为基准值，将小于基准值的元素放到它的左边，大于基准值的放到它的右边
    //2.现在基准值将我们把数组分为俩个部分，左边的是小于基准值的，右边的是大于基准值的
    //3.利用分治的思想，将基准值左右的部分看作俩个新的数组，重复1，2，3的操作
    //4.当分治的数组中只剩下一个元素时，排序完成


    public static int findKth(int[] a, int n, int K) {
        quickSort (a);
        return a[n - K];
    }

    public static void quickSort(int[] arr){
        quickSortInter(arr,0,arr.length-1);
    }

    private static void quickSortInter(int[] arr, int left, int right) {
        while(left >= right){
            return;
        }

        int pivotIndex = partition(arr,left,right);//基准值下标

        quickSortInter (arr,left,pivotIndex-1);
        quickSortInter (arr,pivotIndex+1,right);

    }

    private static int partition(int[] arr, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = arr[left];

        //俩个指针，一个指头，一个指尾，头指针如果小于基准值向后移，尾指针大于基准值向前移动，否则交换
        while(begin < end){
            while(begin < end && arr[end] >= pivot){
                end--;
            }
            while(begin < end && arr[begin] <= pivot){
                begin++;
            }
            swap(arr,begin,end);
        }
        //此时的begin是最后一个小于基准值的元素，将其与基准值交换位置
        //此时基准值左边都是小于它的数字，右边都是大于它的
        swap(arr,left,begin);
        return begin;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n = input.nextInt ();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt ();
        }
        int k = input.nextInt ();
        System.out.println (findKth (arr,n,k));
    }

}
