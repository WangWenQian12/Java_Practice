import java.util.*;

public class Main{

    // 石头剪刀布

    public static void infoWinningRound(int n ,String[] arr){
        int winA = 0;
        int winB = 0;
        int draw = 0;
        int AcountB = 0;
        int AcountC = 0;
        int AcountJ = 0;
        int BcountB = 0;
        int BcountC = 0;
        int BcountJ = 0;

        for(int i = 0; i < arr.length;i++){
            String[] key = arr[i].split(" ");
            if(key[0].equals(key[1])){
                draw ++;
            }
            if(key[0].equals ("B") && key[1].equals ("C")){
                winA ++;
                AcountB++;
            }
            if(key[0].equals ("J") && key[1].equals ("B")){
                winA ++;
                AcountJ++;
            }
            if(key[0].equals ("C") && key[1].equals ("J")){
                winA++;
                AcountC++;
            }
            if(key[0].equals ("C") && key[1].equals ("B")){
                winB ++;
                BcountB++;
            }
            if(key[0].equals ("B") && key[1].equals ("J")){
                winB ++;
                BcountJ++;
            }
            if(key[0].equals ("J") && key[1].equals ("C")){
                winB++;
                BcountC++;
            }
        }
        System.out.println(winA + " " + draw + " " + (n-winA-draw));
        System.out.println(winB + " " + draw + " " + (n-winB-draw));
        System.out.println (getMost (AcountB,AcountC,AcountJ) + " " + getMost (BcountB,BcountC,BcountJ));

    }

    public static String getMost(int b,int c,int j){
        if(b >= c){
            if(b > j){
                return "B";
            }else{
                return "J";
            }
        }else {
            if(c > j){
                return "C";
            }else{
                return "J";
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNext ()) {
            int n = Integer.valueOf (sc.nextLine ());
            String[] arr = new String[n];
            for(int i = 0; i < n;i++){
                arr[i] = sc.nextLine ();
            }
            infoWinningRound (n, arr);
        }
    }
}