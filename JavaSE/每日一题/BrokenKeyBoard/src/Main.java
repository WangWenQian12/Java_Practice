import java.util.*;

public class Main{

    public static String brokenKeyBoard(String str1,String str2){
        String res = "";
        Set<Character> set = new TreeSet<>();
        for(char n : str2.toCharArray()){
            set.add(n);
        }

        Set<Character> broken = new TreeSet<>();
        for(char c : str1.toCharArray()){
            if(!set.contains(c)){
                c = Character.toUpperCase(c);
                if(!broken.contains(c)){
                    res += c;
                    broken.add(c);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(brokenKeyBoard(str1,str2));
        }
    }
}