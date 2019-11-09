import java.util.Scanner;

public class Main {

    //小易去附近的商店买苹果,奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
    //可是小易现在只想购买恰好n个苹果，小易想购买尽少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。

    public static int buyApple(int n){
        if(n % 2 != 0 || n < 6 || n ==10){
            return -1;
        }
        if(n % 8 == 0){
            return n/8;
        }else if((n % 8 == 6) || (n % 8 == 4)){
            //如果要买的苹果数对8求余结果为6，直接再拿一袋6个装的
            //如果余数为4，直接将八个装的换为俩袋6个装的，8+4=6+6
            return 1+n/8;
        } else if(n % 6 == 0){
            return n / 6;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n = input.nextInt ();
        System.out.println (buyApple (n));
    }
}
