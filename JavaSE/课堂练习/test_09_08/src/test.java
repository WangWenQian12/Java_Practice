import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class test {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList();
        System.out.println (list);
        System.out.println (list.size());
        System.out.println (list.isEmpty());
        System.out.println ();

        list.add("i");
        list.add("love");
        list.add("you");
        Object[] array = list.toArray();
        System.out.println (Arrays.toString(array));
        System.out.println (list.size());
        System.out.println (list.isEmpty());
        for(String s:list){
            System.out.println (s);
        }
        System.out.println ();

        list.remove("i");
        System.out.println (list);
        System.out.println (list.size());
        System.out.println (list.isEmpty());
        System.out.println ();

        list.clear();
        System.out.println (list.size());
        System.out.println (list.isEmpty());



        Map<String,String> map = new HashMap<>();
        System.out.println (map.size());
        System.out.println (map.isEmpty());
        System.out.println (map.get("作者"));
        System.out.println (map.getOrDefault("作者","佚名"));
        System.out.println (map.containsKey("作者"));
        System.out.println (map.containsValue("佚名"));
        System.out.println ();

        map.put("作者","路遥");
        map.put("书名","平凡的世界");
        System.out.println (map.size());
        System.out.println (map.isEmpty());
        System.out.println (map.get("作者"));
        System.out.println (map.get("书名"));
        System.out.println (map.getOrDefault("作者","佚名"));
        System.out.println (map.containsValue("佚名"));
        System.out.println ();

        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println (entry);
            System.out.println (entry.getKey()+":"+entry.getValue());
        }
    }
}
