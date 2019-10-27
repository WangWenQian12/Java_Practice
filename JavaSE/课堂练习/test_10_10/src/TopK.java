
import java.util.*;

public class TopK {

    //一组单词 返回前k个出现次数的单词
    public static Map<String,Integer> calcCount(String[] words){
        //先统计每个单词出现了多少次
        Map<String,Integer> map = new TreeMap<> ();
        for(String w : words){
            int count = map.getOrDefault (w,0);
            map.put(w,count + 1);
        }

        return map;
    }

    public static Map<Integer,List<String>> calcCountOfWords(Map<String,Integer> map){
        Map<Integer,List<String>> ret = new HashMap<> ();
        for(Map.Entry<String,Integer> e : map.entrySet ()) {
            String word = e.getKey ();
            int count = e.getValue ();

            //此时的key为单词的数量，value为一个List类型的顺序表
            if (!ret.containsKey (count)) {
                ret.put (count,new ArrayList ());//没有这个个数的单词表，创建一个这个数量的单词表，然后装进去一个空单词
            }
            ret.get(count).add(word);//找到了个数为3的单词表，把这个单词数也为3的单词放进去
        }
        return ret;
    }

    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        int key = 3;
        String[] words = {"the" , "day" , "is" , "sunny" , "is" , "the" , "the" , "is" , "is"};

        Map<String,Integer> wordCount = calcCount(words);
        System.out.println (wordCount);

        Map<Integer,List<String>> countToWordList = calcCountOfWords (wordCount);
        System.out.println (countToWordList);

        //把countToWordList中的key取出来排序，sort之后用作后续的取前k个单词
        Set<Integer> counts = countToWordList.keySet ();
        System.out.println (counts);
        List<Integer> countList = new ArrayList<> (counts);
        Collections.sort(countList, new IntegerComparator ());

        System.out.println (countList);

        /*匿名类(比较器)
        Collection.sort(countsList,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - 01;
            }
        });
        */
    }
}
