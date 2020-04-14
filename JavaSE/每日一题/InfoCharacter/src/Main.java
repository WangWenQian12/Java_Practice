import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{

    // 判断一个字符串中有几个的A-Z

    public static void calc(String str){
        HashMap<Character,Integer> map = new HashMap<> ();
        for(char i = 0;i < 26;i++){
            map.put((char)(i + 'A'),0);
        }

        for(int i = 0; i < str.length();i++){
            if(str.charAt (i) <= 'Z' && str.charAt (i) >= 'A'){
                int count = map.get (str.charAt (i));
                map.put (str.charAt (i),count+1);
            }
        }

        for(Map.Entry<Character,Integer> e : map.entrySet ()){
            if(e.getValue () == 0){
                System.out.println (e.getKey ()+ ":0" );
            }else{
                System.out.println (e.getKey () + ":" + e.getValue ());
            }

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            calc(str);
        }
    }
}