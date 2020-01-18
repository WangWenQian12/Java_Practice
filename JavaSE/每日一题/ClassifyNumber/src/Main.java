import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    //对数字按规则分类

    public static void classifyNumber(int[] arr){
        int sum1 = 0;//余数为0且为偶数的数字之和
        int flag = 0;//余数为1时求和控制加减符号
        int sum2 = 0;
        int count2 = 0;
        int count3 = 0;//余数为3的计数器
        double sum4 = 0.0;
        int count4 = 0;
        int max = 0;//余数为4时最大的数字
        int count5 =0;

        for(int i = 0; i < arr.length;i++){
            int n = arr[i] % 5;
            switch (n){
                case 0:
                    if(arr[i] % 2 == 0){
                        sum1+= arr[i];
                    }
                    break;
                case 1:
                    sum2 += arr[i] * Math.pow (-1,flag);
                    flag++;
                    count2++;
                    break;
                case 2:
                    count3++;
                    break;
                case 3:
                    sum4 += arr[i];
                    count4++;
                    break;
                case 4:
                    if(arr[i] > max){
                        max = arr[i];
                    }
                    count5++;
                    break;
                    default:
                        break;
            }
        }

        if(sum1 == 0){
            System.out.print ("N" + " ");
        }else{
            System.out.print (sum1 + " ");
        }
        if(count2 == 0){
            System.out.print ("N" + " ");
        }else{
            System.out.print (sum2 + " ");
        }
        if(count3 == 0){
            System.out.print ("N" + " ");
        }else{
            System.out.print (count3 + " ");
        }
        if(count4 == 0){
            System.out.print ("N" + " ");
        }else{
            String res = new DecimalFormat ("0.0").format(sum4 / count4);
            System.out.print (res + " ");
        }
        if(count5 == 0){
            System.out.print ("N");
        }else{
            System.out.print (max);
        }
        System.out.println ();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            String str = sc.nextLine ();
            String[] c = str.split (" ");
            int[] arr = new int[Integer.parseInt (c[0])];
            int m = 0;
            for (int i = 1; i < c.length; i++) {
                arr[m++] = Integer.parseInt (c[i]);
            }
            classifyNumber (arr);
        }

    }
}
