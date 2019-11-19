import java.util.Arrays;
import java.util.Random;

public class Heap {


    //向下调整（小堆）

    public static void shiftDownSmall(int[] arr,int size,int index){
        int left = 2 * index + 1;//找到需要调整的结点的左孩子
        while(left < size){
            int min = left;
            int right = left+1;
            if(right < size){
                if(arr[left] > arr[right]){
                    min = right;
                }
            }
            if(arr[index] > arr[min]){
                swap(arr,index,min);
                index = min;//更新需要调整的位置和其左孩子的位置
                left = 2*index+1;
            }
        }
    }

    //向下调整（大堆）
    public static void shiftDownBig(int[] arr,int size,int index){
        int left = 2*index+1;
        while(left < size){
            int max = left;
            int right = left+1;
            if(right < size){
                if(arr[left] < arr[right]){
                    max = right;
                }
            }
            if(arr[index] < arr[max]){
                swap(arr,index,max);
                index = max;
                left = 2*index +1;
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //创建小堆
    //从最后一个非叶子结点的结点开始向下调整，直至堆首
    public static void createHeapSamll(int[] arr,int size){
        for(int i = (size-1)/2;i>=0;i--){
            shiftDownSmall (arr,size,i);
        }
    }

    //创建大堆
    //从最后一个非叶子结点的结点开始向下调整
    public static void createHeapBig(int[] arr,int size){
        for(int i = (size-1)/2;i>=0;i--){
            shiftDownBig (arr,size,i);
        }
    }

    //向上调整（小堆）
     public static void shiftUpSmall(int[] arr,int index){
        while(index != 0){
            int parent = (index-1)/2;//找到双亲结点
            if(arr[index] >= arr[parent]){
               break;
            }
            swap(arr,index,parent);
            index = parent;
        }

     }


     //向上调整（大堆）
    public static void shiftUpBig(int[] arr,int index){
        while(index != 0){
            int parent = (index-1)/2;
            if(arr[index] <= arr[parent]){
                break;
            }
            swap(arr,index,parent);
            index = parent;
        }
    }


    public static void main(String[] args){
       int[] small = { 39, 15, 3, 18, 40, 5, 6, 51, 52, 70 };
        shiftDownSmall(small, small.length, 0);
        System.out.println(Arrays.toString(small));//[3, 15, 5, 18, 40, 39, 6, 51, 52, 70]

        int[] big = { 100, 50, 30, 25, 40, 80, 70, 10, 5, 20, 30, 60, 70, 60, 70, 5 };
        shiftDownBig(big, big.length, 2);
        System.out.println(Arrays.toString(big));//[100, 50, 80, 25, 40, 70, 70, 10, 5, 20, 30, 60, 30, 60, 70, 5]

        int[] smallUp = { 39, 15, 3, 18, 40, 5, 6, 51, 52, 70 };
        shiftUpSmall (smallUp, smallUp.length-1);
        System.out.println(Arrays.toString(smallUp));//[39, 15, 3, 18, 40, 5, 6, 51, 52, 70]

        int[] bigUp = { 39, 15, 3, 18, 40, 5, 6, 51, 52, 70 };
        shiftUpBig (bigUp, bigUp.length-1);
        System.out.println(Arrays.toString(bigUp));//[70, 39, 3, 18, 15, 5, 6, 51, 52, 40]


    }
}
