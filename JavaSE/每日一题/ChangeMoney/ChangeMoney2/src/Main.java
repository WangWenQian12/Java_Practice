import java.util.*;

public class Main{

    // 哈利波特找钱

    public static String changeMoney(String arr1,String arr2){
        String[] price = arr1.split("\\.");
        String[] pay = arr2.split ("\\.");
        int priceSum = 0;
        int paySum = 0;
        for(int i = 0; i < price.length;i++){
            if(i == 0){
                priceSum += Integer.valueOf (price[i])*17*27;
            }else if(i == 1){
                priceSum += Integer.valueOf (price[i])*27;
            }else{
                priceSum += Integer.valueOf (price[i]);
            }
        }
        for(int i = 0; i < pay.length;i++){
            if(i == 0){
                paySum += Integer.valueOf (pay[i])*17*27;
            }else if(i == 1){
                paySum += Integer.valueOf (pay[i])*27;
            }else{
                paySum += Integer.valueOf (pay[i]);
            }
        }

        String res = "";
        int money = paySum - priceSum;
        int flag = 0;
        if(money < 0){
            money = -money;
            flag = 1;
        }
        for(int i = 0; i < 3;i++){
            if(i == 0){
                int count = money/(17*27);
                res += count;
                res += ".";
                money -= count*27*17;
            }else if(i == 1){
                int count = money/27;
                res += count;
                res += ".";
                money -= count*27;
            }else{
                res += money;
            }
        }
        if(flag == 1){
            res = "-" + res;
            return res;
        }else{
            return res;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            System.out.println(changeMoney(arr[0],arr[1]));
        }
    }
}