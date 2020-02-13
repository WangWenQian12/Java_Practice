import java.util.Arrays;

public class Soultion {

    //给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == val){

            }else{
                nums[count++] = nums[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {4,5};
        System.out.println (removeElement (arr,4));
        //System.out.println (Arrays.toString (removeElement (arr,2)));
    }
}
