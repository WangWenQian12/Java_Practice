import java.util.ArrayList;

public class Solution {

    // 顺时针打印矩阵

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<> ();

        int i = 0;
        int j = 0;
        int startX = 0;
        int startY = 0;
        int endX = matrix.length - 1;
        int endY = matrix[0].length - 1;

        while(startX <= endX && startY <= endY){

            // 最后一行
            if(startX == endX){
                while(j <= endY){
                    list.add (matrix[endX][j]);
                    j++;
                }
                return list;
            }

            // 最后一列
            if(startY == endY){
                while(i <= endX){
                    list.add (matrix[i][endY]);
                    i++;
                }
                return list;
            }

            // 从左往右
            while(j < endY){
                list.add (matrix[i][j]);
                j++;
            }

            // 从上往下
            while (i < endX){
                list.add (matrix[i][j]);
                i++;
            }

            // 从左往右
            while (j > startY){
                list.add (matrix[i][j]);
                j--;
            }

            //从下往上
            while (i > startX ){
                list.add (matrix[i][j]);
                i--;
            }

            i++;
            j++;
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return list;
    }
}
