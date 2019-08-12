import java.util.ArrayList;

public class FindTwoSingleNumber {

    //一个整型数组里除了俩个数字以外，其他的数字都出现了俩次。请写程序找出这俩个只出现一次的数字
    //思路：
    //1.将数组中所有元素一次异或，最后的结果就是俩个单独出现的数字异或的结果
    //2.找出异或结果的第一个为1的比特位并记为pos，结果中第一个为1的比特位必为俩个数字第一个不同的比特位
    //3.将数组中所有元素右移pos位并&1，结果为1的放入一个数组中，结果为0的放入另一个数组中
    //4.根据3将元素分为俩组，可以保证俩个单独的数字分别在俩个数组中，且这俩个数组中其他元素都是成对的
    //5.将一个数组有俩个单独数字的问题转换为俩个数组中每个数字只有一个单独的数字，通过异或得到结果


    //找到第一个为1的比特位
    public static int getBit(int[] a){
        int result = 0;
        for(int i=0;i<a.length;i++){
            result ^= a[i];//全部元素异或的结果
        }

        int pos = 0;
        for(int i=0;i<32;i++){
            int j=1;
            if(((result>>i)&1)==1){
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static void findTwoSingleNumber(int[] arr){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();

        //划分到俩个数组中
        int pos = getBit(arr);
        for(int i=0;i<arr.length;i++) {
            if (((arr[i] >> pos) & 1) == 1) {
                a1.add(arr[i]);
            }
            else{
                a2.add(arr[i]);
            }
        }

        //俩个数组分别异或
        int result = 0;
        for(int i:a1){
            result ^= i;
        }
        System.out.println(result);

        result = 0;
        for(int i:a2){
            result ^= i;
        }
        System.out.println(result);

    }



    public static void main(String[] args) {
        int arr[] = {1,3,5,7,1,3,5,9,7,4,2,9};
        findTwoSingleNumber(arr);
    }
}
