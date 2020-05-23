public class Solution {

    // 用 2*1 的矩形 覆盖 2*n 的 大矩形

    public int RectCover(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
}