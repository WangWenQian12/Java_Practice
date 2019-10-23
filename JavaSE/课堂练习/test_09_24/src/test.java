import java.util.Random;

public class test {


    //直接插入排序
    //时间复杂度：最好：有序O(n),最坏：逆序O(n^2),中间：O(n^2)
    public static void insertSort(int[] arr){

    }

    //希尔排序
    public static void shellSort(int[] arr){
        int gap = arr.length;
        while(true){
            gap = (gap/3)+1;
            //gap = gap/2;
            insertSortGap(arr,gap);
            if(gap == 1){
                break;
            }
        }
    }

    public static void insertSortGap(int[] arr,int gap){
        for(int i = gap;i<arr.length;i++){
            int key = arr[i];
            int j;
            for(j = i-gap;j>=0 && arr[j]>key;j -= gap){
                arr[j+gap] = arr[j];
            }
            arr[j+gap] = key;
        }
    }


    //选择排序

    public static void selectSort1(int arr){

    }

    public static void selectSort2(int[] arr){
        //有序【0，i）
        //无序【i，arr.length)
        for(int i = 0;i<arr.length-1;i++){
            int min = i;//一定要从无序区间找
            for(int j = i+1;j<arr.length ;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr,0,min);
        }
    }

    //双向选择排序
    public static void selectSort3(int[] arr){
        //无序：[begin,end]
        int begin = 0;
        int end = arr.length-1;
    }

    //堆排序（升序）
    public static void heapSort(int[] arr){
        //建大堆，将最后一个结点和头交换，向下调整

        createHeapBig(arr);//建大堆
        for(int i = 0;i<arr.length-1;i++){
            swap(arr,0,arr.length-1-i);
            shiftDownBig(arr,0,arr.length-i-1);
        }

    }

    public static void createHeapBig(int[] arr){
        for(int i = (arr.length-1-1)/2;i>=0;i--){
            shiftDownBig(arr,i,arr.length);
        }
    }

    public static void shiftDownBig(int[] arr,int index,int size){
        int left = 2*index+1;
        while(left<size){
            int max = left;
            int right = left+1;
            if(right < size){
                if(arr[right] > arr[left]){
                    max = right;
                }
            }
            if(arr[index] < arr[max]){
                swap(arr,index,max);
            }
        }
    }


    //冒泡排序(最大的数冒到最后)
    public static void bubbleSort(int[] arr){
        //有序[0,arr.length-i-1）
        //无序[arr.length-i，arr.length-1）
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }



    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Random random = new Random(20190924);
        int[] a = new int[10 *10000];
        for(int i = 0;i < 10*10000;i++){
            a[i] = random.nextInt ();
        }
        long begin = System.nanoTime ();
        bubbleSort (a);
        long end = System.nanoTime ();

        long time = end - begin;

        System.out.printf ("%.5fms%n",time);
    }
}

