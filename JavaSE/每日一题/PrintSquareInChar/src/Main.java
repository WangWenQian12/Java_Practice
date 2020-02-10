import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //跟奥巴马一起编程
    //用给定字符画正方形，要求行数是列数的%50(行数四舍五入)

    public static void printSquare(int n,char c){

        int x = 0;//打印的行数
        if(n % 2 == 1){
            x = n/2 +1;
        }else{
            x = n/2;
        }
        char[][] arr = new char[x][n];

        for(int i = 0;i < x;i++){
            for(int j = 0; j < n;j++){
                arr[i][j] = ' ';
            }
        }
        for(int i = 0;i < x;i++){
           arr[i][0] = c;
           arr[i][n-1] = c;
        }
        for(int j = 0;j < n;j++){
            arr[0][j] = c;
            arr[x-1][j] = c;
        }

        for(int i = 0;i < x;i++){
            for(int j = 0;j < n;j++){
                System.out.print (arr[i][j]);
            }
            System.out.println ();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext ()) {
            String input = sc.nextLine ();//字符
            String[] in = input.split (" ");
            int n = Integer.parseInt (in[0]);
            String s = in[1];
            char c = s.charAt (0);

            printSquare (n, c);
        }

    }
}
