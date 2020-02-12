import java.util.Scanner;

public class Main {

    //统计同成绩的人数
    //输入要求：
    //第一行：人数N
    //第二行：成绩
    //第三行：给定成绩
    //要求连续输入，当读到N=0时输入结束

    public static int infoGrade(int[] arr,int socre){
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == socre){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = -1;
        while((n = sc.nextInt ()) != 0){
            int[] arr = new int[n];
            for(int i = 0 ;i< n;i++){
                arr[i] = sc.nextInt ();
            }
            int socre = sc.nextInt ();
            System.out.println (infoGrade (arr,socre));
        }
    }
}
