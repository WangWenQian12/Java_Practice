import java.util.Scanner;

public class Main {

    //给定一串DNA序列和一个子序列的长度，从中找出GC-Ratio最高的子序列
    //GC-Ratio：G和C的比列是序列中G和C俩个字母总的出现次数除以总的字母字数

    public static String findGC(String str,int n){
        String result = "";
        double maxgc = 0.0;
        int maxIndex = 0;

        for(int i = 0;i <= str.length ()-n;i++){
            int count = 0;
            for(int j = i; j < i+n;j++){
                if(str.charAt (j) == 'G' || str.charAt (j) == 'C'){
                    count++;
                }
            }

            double gc = (double)count/n;
            if(gc > maxgc){
                maxgc = gc;
                maxIndex = i;
            }
            result = str.substring (maxIndex,maxIndex+n);

        }

        return result;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        int n = sc.nextInt ();

        System.out.println (findGC(str,n));
    }
}
