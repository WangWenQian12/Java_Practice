import java.util.Scanner;

public class Main {

    // 给定 n 个矩形，要求能覆盖这 n 个矩形的大矩形的最小面积

    public static int calcMax(String[] arr){
        int maxI = 0;
        int maxJ = 0;
        int m = 0;
        int n = 0;
        for(int i = 0; i < arr.length;i++){
            String[] s = (arr[i].split (" "));
            int[] sum = new int[4];
            int index = 0;
            for(String str : s){
                int x = Integer.parseInt (str);
                sum[index++] = x;
            }
            if(sum[0] < 0){
                if(sum[0] < m){
                    m = sum[0];
                }
            }
            if(sum[1] < 0){
                if(sum[1] < n){
                    n = sum[1];
                }
            }
            if(sum[sum.length-2] > maxI){
                maxI = sum[sum.length-2];
            }
            if(sum[sum.length-1] > maxJ){
                maxJ = sum[sum.length-1];
            }
        }

        int length = maxI - m;
        int width = maxJ -n;
        return length * width;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            int n = Integer.valueOf (sc.nextLine ());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine ();
            }
            System.out.println (calcMax (arr));
        }
    }
}
