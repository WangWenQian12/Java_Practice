import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //输入一个字符串，求出该字符串包含的字符集合

    public static void charCollection(String str){
        HashMap<Character,Integer> map = new HashMap<> ();
        for(int i = 0; i < str.length ();i++ ){
            int count = map.getOrDefault (str.charAt (i),0);
            //map.put (str.charAt (i),count+1);
            if(count == 0){
                System.out.print (str.charAt (i));
            }
            map.put (str.charAt (i),count+1);
        }
        System.out.println ();

        /*for(Map.Entry<Character,Integer> e : map.entrySet ()){
            System.out.print (e.getKey ());
        }*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            String str = sc.nextLine ();
            charCollection (str);
        }
    }
}
