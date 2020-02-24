import java.util.Scanner;

public class KthMin {

    //求数组中前k个最小的数字
    //思路：
    //1.冒泡排序，将数组从小到大排好序
    //2.输出数组的前k个

    public static void swap(int[] arr,int k1,int k2){
       int tmp = arr[k1];
       arr[k1] = arr[k2];
       arr[k2] = tmp;
    }

    public static void getKthMin(int[] a,int k){
        if(k>a.length){
            System.err.println("error!");
        }
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
        for(int i = 0;i<k;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please inter the number of array:");
        int n = input.nextInt();

        int[] array = new int[n];
        System.out.println("Please inter the array:");
        for(int i=0;i<n;i++){
            array[i] = input.nextInt();
        }

        System.out.println("Please inter the value of k:");
        int k = input.nextInt();

        getKthMin(array,k);
    }
}
