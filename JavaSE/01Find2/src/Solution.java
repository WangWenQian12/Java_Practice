public class Solution {

    // 杨氏矩阵

    public boolean Find(int target, int[][] array) {
        int i = 0;
        int j = array[0].length-1;
        while(i < array.length && j >=0 ) {
            if(array[i][j] == target){
                return true;
            }else if (target > array[i][j]) {
                i++;
            } else if(target < array[i][j]){
                j--;
            }
        }
        return false;
    }
}