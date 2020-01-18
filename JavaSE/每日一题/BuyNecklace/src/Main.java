import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //买珠子
    //小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
    //下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
    //如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。


    public static void buyNecklace(String str1,String str2){
        HashMap<Character,Integer> map = new HashMap<> ();
        for(int i = 0;i < str1.length ();i++){
            int count = map.getOrDefault (str1.charAt (i),0);
            map.put (str1.charAt (i),count + 1);
        }

        int lost = 0;
        for(int i = 0;i < str2.length ();i++){
            int res = map.getOrDefault (str2.charAt (i),0);
            if(res <= 0){
                lost++;
            }
            map.put (str2.charAt (i),res-1);
        }

        if(lost == 0){
            System.out.println ("YES " + (str1.length ()-str2.length ()));
        }else{
            System.out.println ("NO " + lost);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            String str1 = sc.nextLine ();
            String str2 = sc.nextLine ();
            buyNecklace (str1, str2);
        }

    }
}
