public class test {

    //快速排序

    public static void quickSort(int[] arr){
        quickSortInter (arr,0,arr.length-1);
    }

    public static void quickSortInter(int[] arr,int left,int right){

    }

    public static int partition(int[] arr,int left,int right){
        int begin = left;
        int end = right;
        int pivot = arr[left];
        while(begin < end){
            while(begin < end && arr[end] >= pivot) {
                end--;
            }
            while(begin < end && arr[begin] <= pivot){
                begin++;
            }
            swap(arr,begin,end);
        }
        swap(arr,begin,left);
        return begin;
    }

    public static int partition2(int[] arr,int left,int right){
        int pivot = arr[left];
        int begin = left;
        int end = right;

        while(begin < right){
            if(begin < right && arr[begin] >= pivot){
                end--;
            }
            arr[begin] = arr[end];

            if(begin < right && arr[begin] <= pivot){
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = pivot;
        return begin;

    }


    public static int partition3(int[] arr,int left,int right){

    }



    public static void swap(int[] arr,int i,int j){

    }



    public static void main(String[] args) {

    }
}
