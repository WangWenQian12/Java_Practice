import java.util.Arrays;

public class test {


    //归并排序
    //时间复杂度：log(n)*O(n)
    //空间复杂度：O(n)
    //调用栈占用空间O(log(n)),在O(n)面前被忽略
    public static void mergeSort(int[] arr){
        mergeSortInter (arr,0,arr.length);
    }

    private static void mergeSortInter(int[] arr, int low, int high) {
        if(low >= high-1){
            return;
        }
        //[low,mid)
        //[mid,high)
        int mid = (low + high)/2;
        mergeSortInter (arr,low,mid);
        mergeSortInter (arr,mid,high);
        merge(arr,low,mid,high);//调用了log(n)个merge
    }

    //merge:时间复杂度O(n)
    private static void merge(int[] arr, int low, int mid, int high) {
        int length = high - low;
        int[] extra = new int[length];

        int i = low;
        int j = mid;
        int k = 0;

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

        //搬移
        for(int x = 0;x < length;x++){
            arr[low + x] = extra[x];
        }
    }

    //优化（每次merge共用一个数组（提前申请））

    //非递归归并排序
    public static void mergeSort3(int[] arr){
        for(int i = 1;i<arr.length;i = i*2){//mergr外层循环log(n)次
            for(int j = 0;j<arr.length;j = j+2*i){
                int low = j;
                int mid = j + i;
                if(mid >= arr.length){
                    continue;
                }
                int high = mid + i;
                if(high > arr.length){
                    high = arr.length;
                }

                merge(arr,low,mid,high);
            }
        }
    }

    //m路归并（排序海量数据）

     //Lab

    //比较引用数据类型




    public static void main(String[] args) {
        int[] arr = {6,4,5,2,38,7,1};
        mergeSort (arr);
        System.out.println (Arrays.toString(arr));

    }

}
