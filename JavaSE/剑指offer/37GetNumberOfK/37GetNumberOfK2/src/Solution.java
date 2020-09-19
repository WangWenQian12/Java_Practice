public class Solution {

    // 数字在升序数组中出现的次数
    // 二分查找

    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        int index = -1;
        int left = 0;
        int right = array.length-1;
        int mid = -1;
        while(left < right) {
            mid = (left + right)/2;
            if (array[mid] > k) {
                right = mid - 1;
            }else if(array[mid] < k){
                left = mid + 1;
            }else{
                count++;
                index = mid;
                break;
            }
        }
        for(int i = index -1;i >= 0;i--){
            if(array[i] == k){
                count++;
            }else{
                break;
            }
        }
        for(int j = index + 1;j < array.length;j++){
            if(array[j] == k){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
