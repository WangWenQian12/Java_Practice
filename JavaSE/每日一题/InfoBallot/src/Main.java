import java.util.*;

public class Main{

    // 统计投票

    public static void info(String[] name,String[] ballot){
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < name.length;i++){
            int n = map.getOrDefault(name[i],0);
            map.put(name[i],n);
        }
        map.put ("Invalid",0);
        int count = 0;
        for(int i = 0; i < ballot.length;i++){
            if(map.containsKey (ballot[i])){
                map.put (ballot[i],map.get(ballot[i])+1);
            }else{
                map.put ("Invalid",map.get ("Invalid")+1);
            }
        }

        for(Map.Entry<String,Integer> e : map.entrySet ()){
            System.out.println (e.getKey () + "：" + e.getValue ());
        }


    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext ()) {
            int n = sc.nextInt ();
            String[] name = new String[n];
            for(int i = 0; i < n;i++){
                name[i] = sc.next ();
            }
            int m = sc.nextInt ();
            String[] ballot = new String[m];
            for(int i = 0; i < m;i++){
                ballot[i] = sc.next ();
            }
            info (name, ballot);
        }
    }
}