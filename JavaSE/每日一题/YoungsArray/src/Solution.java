public class Solution {

    // 杨氏数组

    public static boolean Find(int target, int [][] array) {
        int x = 0;
        int y = array[0].length - 1;
        while(x < array.length && y >= 0){
            if(target == array[x][y]){
                return true;
            }else if(target > array[x][y]){
                x++;
            }else if(target < array[x][y]){
                y--;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        int[][] arr = {
            { 1, 2, 3 },
            { 2, 3, 4 },
            { 3, 4, 5 }
        };
        System.out.println (Find(3,arr));
    }
}