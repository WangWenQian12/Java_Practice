import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class JewelsInStones {

    //给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
    // S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
    //J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
    //例： J = "aA", S = "aAAbbbb"，  其中bbb都是石头
    //要求输出有几块宝石

    public static int numJewelsInStons(String J,String S){
        //把所有宝石放进jewels
        Set<Character> jewels = new TreeSet<> ();
        for(char j : J.toCharArray ()){
            jewels.add (j);
        }

        //遍历J，如果jewels中包含J,宝石数量+1
        int count = 0;
        for(char s : S.toCharArray ()){
            if(jewels.contains (s)){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String J = "ABcd";
        String S = "AABBCcddeeee";
        System.out.println (numJewelsInStons (J,S));
    }
}
