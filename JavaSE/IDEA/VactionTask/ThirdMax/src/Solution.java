import static java.lang.Integer.MIN_VALUE;

public class Solution {

    //给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
    //遍历数组，维护三个最大的数

    public static int thirdMax(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max (nums[0],nums[1]);
        }

        int one = MIN_VALUE;
        int two = MIN_VALUE;
        int three = MIN_VALUE;

        boolean f = true;
        int flag = 0;

        for(int i = 0; i < nums.length;i++){
            //用于解决值为 MIN_VALUE 的元素
            if(nums[i] == MIN_VALUE  && f){
                flag++;
                f = false;
            }

            if(nums[i] > one){
                flag++;
                three = two;
                two = one;
                one = nums[i];
            }else if(nums[i] > two && nums[i] < one){
                flag++;
                three = two;
                two = nums[i];
            }else if(nums[i] > three && nums[i] < two){
                flag++;
                three = nums[i];
            }
        }

        if(flag >= 3){
            return three;
        }else{
            return one;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,-2147483648};
        System.out.println (thirdMax (arr));
    }


}
