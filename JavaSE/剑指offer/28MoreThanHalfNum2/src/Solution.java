public class Solution {

    // 数组中出现次数超过一半的数字

    public static int MoreThanHalfNum_Solution(int [] array) {
        int num = -1;
        int cnt = 0;
        for(int i = 0; i < array.length;i++){
            if(cnt == 0){
                num = array[i];
                cnt++;
            }else{
                if(array[i] == num){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }

        cnt = 0;
        for(int k : array){
            if(k == num){
                cnt++;
            }
        }

        if(cnt > array.length/2){
            return num;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,1,1,1,2,4};
        System.out.println (MoreThanHalfNum_Solution (arr));
    }
}
