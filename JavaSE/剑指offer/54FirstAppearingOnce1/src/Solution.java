import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    LinkedHashMap<Character,Integer> map = new LinkedHashMap<> ();

    //Insert one char from stringstream
    public void Insert(char ch){
        if(map.containsKey (ch)){
            map.put (ch,-1);
        }else{
            map.put (ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        for(Map.Entry<Character,Integer> m : map.entrySet ()){
            if(m.getValue () == 1){
                return m.getKey ();
            }
        }
        return '#';
    }
}