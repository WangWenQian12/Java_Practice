public class Solution {

    // 从 1-n 中 1 出现的次数

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i = 1; i <= n;i++){
            String str = i+"";
            for(int j = 0;j < str.length();j++){
                if(str.charAt (j) == '1'){
                    count++;
                }
            }
        }
        return count;
    }
}