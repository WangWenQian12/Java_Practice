import java.util.Scanner;

public class Main {

    //给定0-9内的是个数字，不能全为0，
    //例：
    //2 2 0 0 0 3 0 0 1 0 表示需要用 2个0，2个1，0个2、3、4，3个5，0个6、7，1个8，0个9 组成最小的数字

    public static String minNumber(int[] nums){

        String res = "";

        //由于接收数组的特殊性，先找到第一个不为0的数字
        //将其作为结果字符的首部，将数量减一，然后跳出循环
        for(int i = 1; i<10;i++){
            if(nums[i] != 0){
                res += i;
                nums[i] --;
                break;
            }
        }

        //然后按照顺序把其他字符一个一个添进去
        for(int i = 0;i<10;i++){
            while(nums[i] != 0){
                res += i;
                nums[i] --;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            int[] arr = new int[10];
            for(int i = 0;i < 10;i++) {
                arr[i] = sc.nextInt ();
            }


            System.out.println (minNumber (arr));
        }
    }
}
