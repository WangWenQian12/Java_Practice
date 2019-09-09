public class Main {

    //1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。

    public static boolean judgePlalin(int n){
        int sum=0;
        int tmp = n;
        while(tmp != 0) {
            sum = sum * 10 + tmp % 10;
            tmp /= 10;
        }
        if(sum == n){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        for(int i=1000;i<=9999;i++){
            if(judgePlalin(i)==true){
                System.out.print (i+" ");
            }
        }

    }
}
