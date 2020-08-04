public class Solution {

    //杨氏矩阵暴力法

    public boolean Find(int target, int[][] array) {
        for(int i = 0;i < array.length;i++){
            for(int j = 0;j < array[0].length;j++){
                if(target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}