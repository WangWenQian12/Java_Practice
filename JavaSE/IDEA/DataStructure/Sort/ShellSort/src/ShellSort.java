import java.util.Random;

public class ShellSort {

    //希尔排序,希尔排序是对直接插入排序的优化。
    //分组进行插入排序

    public static void shellSort(int[] arr){
        int gap = arr.length;
        while(true){
            gap = (gap/3)+1;
            insertSort(arr,gap);
            if(gap == 1){
                break;
            }
        }

    }

    public static void insertSort(int[] arr,int gap){
        for(int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j = 0;
            for(j = i-gap;j>=0 && arr[j] > key; j-= gap){
                arr[j+gap] = arr[j];
            }
            arr[j+gap] = key;
        }
    }

    public static void main(String[] args) {

        Random random = new Random(20190925);
        int[] arr = new int[10 * 10000];
        for(int i = 0;i<10*10000;i++){
            arr[i] = random.nextInt ();
        }

        long begin = System.nanoTime ();
        shellSort (arr);
        long end = System.nanoTime ();

        double time = (end-begin)*1.0/1000/1000;

        System.out.printf ("耗时：%.5f毫秒%n",time);


    }
}
