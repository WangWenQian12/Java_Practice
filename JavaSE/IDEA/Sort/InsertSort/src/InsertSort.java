import java.util.Random;

public class InsertSort {


    //直接插入排序
    //时间复杂度：
    //最差：O(n^2).....数据逆序
    //平均：O(n^2)
    //最好：O(n)......数据有序


    public static void insertSort(int[] arr){

        //有序：[0,i)  (第一个数字永远有序)
        //无序：[i,arr.length)

        if(arr.length == 0){
            return;
        }
        //外层循环表示共比较多少次
        for(int i = 1;i < arr.length;i++){
            int key = arr[i];
            int j = 0;
            for(j = i-1;j>=0 && arr[j]>key;j--){
                arr[j+1] = arr[j];
            }
            /*for(j = i-1;j>=0;j--){//在有序区间内找大于key的元素
                if(arr[j] <= key){
                    break;
                }else{
                    arr[j+1] = arr[j];//将数字整体往后移
                }
            }*/
            arr[j+1] = key;
        }
    }



    public static void main(String[] args) {
        Random random = new Random (20190925);
        int[] arr = new int[10 *10000];
        for(int i = 0;i<10*10000;i++){
            arr[i] = random.nextInt ();
        }


        long begin = System.nanoTime ();
        insertSort (arr);
        long end = System.nanoTime ();

        double time = (end-begin)*1.0/1000/1000;

        System.out.printf ("%.5f毫秒%n",time);//约1000ms

    }
}
