public class BubbleSort {

    // 冒泡排序
    public static void bubbleSort(int[] arr){
        boolean flag = true;
        for(int i = 0; i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[i]){
                    swap(arr,i,j);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
