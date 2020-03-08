import java.util.Scanner;

public class Main {

    //小易打怪

    public static int game(int power,int[] arr){
        for(int i = 0; i < arr.length;i++){
            if(arr[i] <= power){
                power += arr[i];
            }else{
                int both = gcd(arr[i],power);
                power += both;
            }
        }
        return power;
    }

    public static int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            int n = sc.nextInt ();
            int power = sc.nextInt ();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt ();
            }
            System.out.println (game(power,arr));
        }
    }
}
