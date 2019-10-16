import java.util.Arrays;

public class HeapSort {

    //升序
    public static void heapSortUp(int[] arr){
        Heap.createHeapBig(arr,arr.length);//先将大数字放到堆首
        for(int i = 0;i<arr.length-1;i++){
            // 无序 [0, array.length - i)
            // 有序 [array.length - i, array.length)
            Heap.swap(arr,0,arr.length-1-i);
            // 无序 [0, array.length - i - 1)
            // 长度 [array.length - i - 1)
            Heap.shiftDownBig (arr,arr.length-1-i,0);
        }

    }

    //降序
    public static void heapSortDown(int[] arr){
        Heap.createHeapSamll (arr,arr.length);//先将小数字放到堆首
        for(int i = 0;i<arr.length-1;i++){
            Heap.swap(arr,0,arr.length-1-i);
            Heap.shiftDownSmall(arr,arr.length-1-i,0);
        }

    }

    public static void main(String[] args) {
        int[] a = { 9, 4, 1, 3, 7, 1, 2, 2, 9, 8 };
        heapSortUp(a);
        System.out.println(Arrays.toString(a));

        //int[] b = { 9, 4, 1, 3, 7, 1, 2, 2, 9, 8 };
        //heapSortDown(b);
        //System.out.println(Arrays.toString(b));
    }
}
