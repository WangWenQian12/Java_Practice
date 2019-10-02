import java.util.Arrays;

public class HeapSort {

    //堆排序
    //注意：排升序建大堆，排降序建小堆

    public static void heapSort(int[] arr){
        createHeapBig(arr,arr.length);
        for(int i = 0;i<arr.length-1;i++){
            swap(arr,0,arr.length-1-i);
            shiftDownBig(arr,0,arr.length-i-1);
        }
    }

    public static void createHeapBig(int[] arr,int size){
        for(int i = (size-2)/2;i>=0;i--){
            shiftDownBig(arr,i,size);
        }
    }

    public static void shiftDownBig(int[] arr,int index,int size){
        int left = (index*2)+1;
        while(left<size){
            int max = left;
            int right = left+1;
            if(right < size){
                if(arr[right]>arr[left]){
                    max = right;
                }
            }
            if(arr[index] < arr[max]){
                swap(arr,index,max);
                index = max;
                left = (index * 2) +1;
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,32,1};
        heapSort (arr);
        System.out.println (Arrays.toString(arr));

    }
}
