import java.util.Arrays;

public class SelectSortOP {

    //双向选择排序
    //1.先将整个数组看作一个无序区间，从中找到最大的和最小的数字
    //2.将最小的数字和数组首元素交换，将最大的数字和数字最后一个元素交换。
    //3.交换之后无序区间对应要缩小。
    //4.如果无序数组首元素就是最大的数字，在和最小的数字交换之后要改变最小的数字的下标

    //无序区间：[low,high]


    public static void selectSort(int[] arr){
        int low = 0;
        int high = arr.length-1;
        while(low<high){
            int min=  low;
            int max = high;
                for(int i = low;i<=high;i++){
                if(arr[i] < arr[min]){
                    min = i;
                }
                if(arr[i] > arr[max]){
                    max = i;
                }
            }
            swap(arr,min,low);
            if(low == max){
                max = min;
            }
            swap(arr,max,high);
            low++;high--;
        }

    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        selectSort (arr);
        System.out.println (Arrays.toString(arr));
    }
}
