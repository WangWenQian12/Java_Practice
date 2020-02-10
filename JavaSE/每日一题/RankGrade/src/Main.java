
import java.util.*;

public class Main {

    //成绩排序

    public static List<Map.Entry<String,Integer>> list = new ArrayList<> ();

    public static void sort(HashMap<String,Integer> map,int sortType){
        list.addAll (map.entrySet ());
        if(sortType == 1) {
            Collections.sort (list, new UpValueComparator ());
        }else{
            Collections.sort (list, new DownValueComparator ());
        }
    }

    private static class UpValueComparator implements Comparator<Map.Entry<String,Integer>> {
        @Override
        public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2) {
            return o1.getValue () - o2.getValue ();
        }
    }

    private static class DownValueComparator implements Comparator<Map.Entry<String,Integer>> {
        @Override
        public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2) {
            return o2.getValue () - o1.getValue ();
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<> ();
        Scanner sc= new Scanner (System.in);
        while (sc.hasNext ()) {
            int n = Integer.parseInt (sc.nextLine ());
            int sortType = Integer.parseInt (sc.nextLine ());//排序规则，0为降序，1为升序


            for (int i = 0; i < n; i++) {
                String line = sc.nextLine ();
                String[] arr = line.split (" ");
                String name = arr[0];
                int socre = Integer.parseInt (arr[1]);
                map.put (name, socre);
            }

            sort (map, sortType);

            for (Map.Entry<String, Integer> m : list) {
                System.out.println (m.getKey () + " " + m.getValue ());
            }
        }


    }

}
