import java.util.*;

public class Main {

    // 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
    // 给定一个正整数n，请返回0到n的数字中2出现了几次。

    public int countNumberOf2s(int n) {

        int count = 0;
        int higher = 0;
        int cur = 0;
        int lower = 0;
        int flag = 1;
        while(n / flag != 0){
            higher = n / (flag * 10);
            cur = (n / flag) % 10;
            lower = n -(n/flag)*flag;
            if(cur < 2){
                count += (higher*flag);
            }
            if(cur == 2){
                count += (higher*flag)+lower+1;
            }
            if(cur > 2){
                count += (higher + 1)*flag;
            }
            flag *= 10;
        }
        return count;
    }
}