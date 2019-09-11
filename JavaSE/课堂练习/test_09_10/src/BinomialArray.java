import java.util.List;
import java.util.ArrayList;

public class BinomialArray {

    //杨辉三角形

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            list.add(new ArrayList<>());//构建整个大框架，每一行都是一个ArrayList
        }
        //每层的ArrayList里的元素用1占位
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                list.get(i).add(1);
            }
        }

        //计算特殊位置
        for(int i=2;i<numRows;i++){
            for(int j=1;j<i;j++){
                int a = list.get(i-1).get(j-1);//左上角的数字
                int b = list.get(i-1).get(j);//头上的数字
                list.get(i).set(j,a+b);//把计算的结果放进去
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new BinomialArray().generate(8));;
    }
}
