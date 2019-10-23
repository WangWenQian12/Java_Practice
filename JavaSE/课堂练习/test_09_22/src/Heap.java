import java.util.Arrays;

public class Heap {


    //向下调整
    public static void shiftDown(int[] arr,int index,int size){
        int left = 2 * index+1;
        while(left<size){
            int min = left;
            int right = 0;
            if(left+1 < size) {
                right = left + 1;
            }
            if(arr[left] > arr[right]){
                min = right;
            }

            if(arr[index] >arr[min]){
                swap(arr,index,min);
                index = min;
                left = 2*index +1;
            }else{
                break;
            }
        }

    }

    //大堆
    public static void shiftDownBig(int[] arr,int index,int size){
        int left = 2 * index +1;
        while(left < size){
            int max = left;
            int right = 0;
            if(left+1<size) {
                right = left + 1;
            }
            if(arr[left] < arr[right]){
                max = right;
            }

            if(arr[index] < arr[max]){
                swap(arr,index,max);
                index = max;
                left = 2*index+1;
            }else{
                break;
            }
        }
    }

    //向上调整（小堆）
    public static void shiftUpSmall(int[] arr,int size){
        while(size != 0){
            int parent = (size-1)/2;
            if(arr[parent] > arr[size]){
                swap(arr,parent,size);
                size = parent;
            }else{
                break;
            }
        }
    }


    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //建堆
    //时间复杂度：n * log（n）
     public static void creatHeap(int[] a,int size){
        for(int i = (size-2)/2;i>=0;i--){
            shiftDown (a,i,size);
        }
     }

        public static void creatHeapBig(int[] arr,int size){

        }


    public static void main(String[] args) {
        int[] small = {39,15,3,18,40,5,6,51,52,70};
        shiftDown (small,0,small.length);
        System.out.println (Arrays.toString(small));

        int[] big = {100,50,30,25,40,80,70,10,5,20,30,60,70,60,70,5};
        shiftDownBig (big,2,big.length);
        System.out.println (Arrays.toString(big));
    }
}
