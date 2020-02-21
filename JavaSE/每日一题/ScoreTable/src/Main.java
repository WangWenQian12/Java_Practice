import java.util.Scanner;

public class Main {

    //对成绩表进行查询和操作
    //每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
    //学生ID编号从1编到N。
    //第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
    //接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,
    //当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
    //当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

    public static void operate(String c,int a,int b,int[] arr){
        if(c.equals ("Q")){
            int max = 0;
            if(a > b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            for(int i = a-1;i <= b-1;i++){
                if(arr[i] > max){
                    max = arr[i];
                }
            }
            System.out.println (max);
        }
        if(c.equals ("U")){
            arr[a-1] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            int n = sc.nextInt ();
            int operateNum = sc.nextInt ();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt ();
            }

            for (int i = 0; sc.hasNext () && i < operateNum; i++) {
                String c = sc.next();
                int a = sc.nextInt ();
                int b = sc.nextInt ();
                operate (c,a,b, arr);
            }
        }


    }
}
