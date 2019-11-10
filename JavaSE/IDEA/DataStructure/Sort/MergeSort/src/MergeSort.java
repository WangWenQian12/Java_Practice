import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    //归并排序
    //采用分治的思想，将数组分为若干个小数组进行排序，小序列有序后再一一合并为有序的序列

    //核心：合并俩个有序数组
    //思路：
    //1.创建一个数组来存放结果，因为我们的数组在物理上是一个整体不可分割，所以分割的若干个小数组也只是在大数组内部进行比较然后排序
    //2.数组首元素记为low，尾元素记为high，找到数组的最中间元素，记为mid
    //3.指针i指向low，指针j指向mid，在 i<mid且j<high 的前提下循环
    //4.如果arr[i] <= arr[j],则将其插入结果数组的末尾，反之将arr[j]插入结果数组的末尾
    //5.循环退出后，如果i<mid,说明前半部分数组还没有遍历结束，直接将剩余元素全部插入到结果数组中，反之同理
    //注：以上所说的“插入”是便于理解，实则是用赋值的方式

    public static void mergeSort(int[] arr){
        int[] extra = new int[arr.length];
        mergeSortInter(arr,0,arr.length,extra);
    }

    private static void mergeSortInter(int[] arr, int low, int high,int[] extra) {
        if(low >= high - 1){
            return;
        }

        int mid = (low + high)/2;
        mergeSortInter (arr,low,mid,extra);
        mergeSortInter (arr,mid,high,extra);

        merge(arr,low,mid,high,extra);

    }

    private static void merge(int[] arr, int low, int mid, int high,int[] extra) {
        int length = high - low;
        int k = 0;

        int i = low;
        int j = mid;
        while(i < mid && j < high){
            if(arr[i] <= arr[j]){
                extra[k++] = arr[i++];
            }else{
                extra[k++] = arr[j++];
            }
        }

        while(i < mid){
            extra[k++] = arr[i++];
        }

        while(j < high){
            extra[k++] = arr[j++];
        }

        //再将排好序的extra数组搬回到arr数组中
        for(int m = 0;m < length;m++){
            arr[low+m] = extra[m];
        }

    }


    public static void main(String[] args) {
        int[] arr = {7,3,5,1,6,10,22,3,9};
        mergeSort (arr);
        System.out.println (Arrays.toString (arr));
    }
}
