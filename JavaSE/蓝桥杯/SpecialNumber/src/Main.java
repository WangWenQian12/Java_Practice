
//153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。

public class Main {

    public static void main(String[] args) {
        for(int i = 100;i < 1000;i++){
            int n1 = i /100;
            int n2 = (i % 100)/10;
            int n3 = i % 10;
            if(i == n1*n1*n1 + n2*n2*n2 + n3*n3*n3){
                System.out.println (i);
            }
        }
    }
}
