import java.util.*;

public class Main{

    // 判断一个字符对应的 ASCII 码 ，是奇数还是偶数

    public static void checkout(String str){
        char[] arr = str.toCharArray ();
        int[] res = new int[8];
        for(int i = 0; i < arr.length; i++) {
            int count = 0;
            int checkNum = 0x01;
            int index = 7;
            while (index > 0) {
                res[index] = ((arr[i] & checkNum) == 0) ? 0 : 1;
                if (res[index] == 1) {
                    count++;
                }
                checkNum <<= 1;
                index--;
            }
            if (count % 2 == 0) {
                res[0] = 1;
            }
            for (int k = 0; k < 8; k++) {
                System.out.print (res[k]);
            }
            System.out.println ();
            res[0] = 0;// 更新
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            checkout(str);
        }
    }
}