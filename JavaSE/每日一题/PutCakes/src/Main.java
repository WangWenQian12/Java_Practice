import java.util.Scanner;

public class Main {

    //网格盒子放蛋糕，要保证欧几里距离不为2

    public static int calcCakes(int w,int h){
        int count = 0;
        if(w % 4 == 0 || h % 4 == 0 ){
            count = w * h/2;
        }else if(w % 2 == 0 && h % 2 == 0 ){
            count = (w * h/4 +1)*2;
        }else{
            count = w * h/2 +1;
        }
        return count;
    }



    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        int w = input.nextInt ();//行（长）
        int h = input.nextInt ();//列（宽）

        System.out.println (calcCakes (w,h));


    }
}
