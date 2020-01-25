import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;

import java.util.*;

public class TopKWords {

    //给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    //例：
    //输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    //输出: ["i", "love"]
    //解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    //注意，按字母顺序 "i" 在 "love" 之前。

    public static Map<String,Integer> calcCount(String[] arr){
        //先统计每个单词出现了多少次
        Map<String,Integer> map = new TreeMap<> ();
        for(String words : arr){
            int count = map.getOrDefault (words,0);
            map.put(words,count+1);
        }
        return map;
    }

    //此时的map中key为单词个数，value为个数为key的单词
    public static Map<Integer,List<String>> calcCountOfWords(Map<String,Integer> map){
        Map<Integer,List<String>> ret = new HashMap<> ();

        for(Map.Entry<String,Integer> e : map.entrySet ()) {
            String word = e.getKey ();
            int count = e.getValue ();

            if (!ret.containsKey (count)) {
                ret.put(count,new ArrayList ());//如果ret中没有为count的key，就添加进去，其value为空
            }
            ret.get(count).add(word);//如果ret中有，就把这个单词添加到list中
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
        int k = 3;
        String[] words = {"the" , "day" , "is" , "sunny" , "is" , "the" , "the" , "is" , "is"};

        Map<String,Integer> map = calcCount (words);
        System.out.println (map);

        Map<Integer,List<String>> ret = calcCountOfWords (map);
        System.out.println (ret);

        //将ret中的key取出来排序，作为后序输出的前k个单词
        Set<Integer> counts = ret.keySet ();
        System.out.println (counts);
        List<Integer> sortCounts = new ArrayList<> (counts);
        Collections.sort (sortCounts, new IntegerComparator () );

        List<String> result = new ArrayList<> ();
        int n = 0;
        int i = 0;
        while(n < k){
            //依次取排好序的sortCounts
            int count = sortCounts.get(i);
            i++;

            //ws为每一个单词的数量
            List<String> ws = ret .get(count);
            Collections.sort(ws);

            if (ws.size() <= k - n) {
                // 如果候选人数量小于需要人数，全部录取
                result.addAll(ws);
                n += ws.size();
            } else {
                // 否则，只录取需要的人数
                result.addAll(ws.subList(0, k - n));
                n += (k - n);
            }
        }
        System.out.println(result);

    }

}
