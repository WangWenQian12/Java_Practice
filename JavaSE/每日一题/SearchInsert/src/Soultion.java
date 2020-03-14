public class Soultion {

    // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    public static int searchInsert(int[] nums, int target) {
        int i;
        for(i = 0;i < nums.length;i++){
            if(nums[i] <= target){
                if(nums[i] == target){
                    return i;
                }else{
                    continue;
                }
            }else{
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,6};
        System.out.println (searchInsert (arr,5));
    }
}
