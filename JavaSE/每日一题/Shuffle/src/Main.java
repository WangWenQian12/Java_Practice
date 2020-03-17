import java.util.*;

public class Main {

    //给出牌的原始序列，按照规则洗牌

    //递归洗牌
    public static int[] shuffle(int[] arr,int times,int[] tmp){
        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length/2];
        if(times == 0){
            return tmp;
        }else {
            --times;
            for (int i = 0; i < arr.length / 2; i++) {
                left[i] = arr[i];
            }
            int m = 0;
            for (int i = arr.length / 2; i < arr.length; i++) {
                right[m++] = arr[i];
            }


            int j = 0;
            for(int i = arr.length/2-1;i >= 0;i--){
                tmp[j++] = right[i];
                tmp[j++] = left[i];

            }
            if(times != 0) {
                reverse (tmp);
            }
            shuffle (tmp,times,tmp);
        }
        return tmp;

    }

    //反转数组
    public static void reverse(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int groupNum = sc.nextInt ();

        ArrayList<Integer> list = new ArrayList<> ();
        while(sc.hasNext ()) {
            int x = sc.nextInt ();//待排序的个数的一半
            int y = sc.nextInt ();
            int[] arr = new int[2 * x];
            int[] tmp = new int[arr.length];
            for (int i = 0; i < 2 * x; i++) {
                arr[i] = sc.nextInt ();
            }
            //int[] res = new int[2 * x];
            arr = shuffle (arr, y, tmp);
            reverse(arr);
            for(int i = 0;i < arr.length;i++){
                System.out.print (arr[i]);
                if(i != arr.length-1){
                    System.out.print (" ");
                }
            }
            System.out.println ();
        }
    }

}
