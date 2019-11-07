import java.util.Scanner;

public class BuySodaWater {

    //3个空汽水瓶可以换一瓶汽水，当你最后只剩俩个空汽水瓶时，支持向老板借一瓶，喝完后刚好三个空气水瓶，换一瓶汽水还给老板

    public static int buySodaWater(int empty_bottle,int x){
        int count = 0;
        while(empty_bottle > 2){
            count += empty_bottle/x;
            empty_bottle = empty_bottle/x + empty_bottle%x;
        }
        if(empty_bottle == 2){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int[] result = new int[10];
        int input;
        int i = 0;
        int count = 0;

        while(sc.hasNext ()){
            int num = sc.nextInt();
            if(num == 0) break;
            result[i++] = (buySodaWater (num,3));
            count++;
        }
        for(int j = 0;j < count;j++){
            System.out.println (result[j]);
        }


    }
}
