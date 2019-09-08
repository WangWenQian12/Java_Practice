import java.util.Map;
import java.util.HashMap;

public class MapDemo {

    //键值映射集合

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<> ();
        System.out.println (map);
        System.out.println (map.size());
        System.out.println (map.getOrDefault("作者","佚名"));
        System.out.println (map.containsKey("作者"));
        System.out.println (map.containsValue("佚名"));
        System.out.println ();

        map.put("作者","路遥");
        map.put("书名","平凡的世界");
        System.out.println (map);
        System.out.println (map.size());
        System.out.println (map.isEmpty());
        System.out.println (map.containsKey("作者"));
        System.out.println (map.containsValue("佚名"));
        System.out.println ();

        for(Map.Entry<String,String> m : map.entrySet()){
            System.out.println (m);
            System.out.println (m.getKey()+":"+m.getValue());
        }


    }
}
