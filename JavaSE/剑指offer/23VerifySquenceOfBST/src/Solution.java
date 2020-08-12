public class Solution {

    // 二叉搜索树的后续遍历序列
    // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    // 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
    // 思路：
    // （1）发现后序遍历的最后一个结点为根结点
    // （2）分治，用根结点把序列分为左右区间
    // （3）只需要不断地确定出左子树区间和右子树区间，
    // 并且判断：左子树区间的所有结点值 < 根结点值 < 右子树区间所有结点值，这个条件是否满足即可

    public static boolean isBST(int[] sequence,int start,int root){
        if(start >= root){
            return true;
        }
        int key = sequence[root]; // 根结点
        int i;
        for(i = start;i < root;i++){
            // 找到左右区间分界点
            if(sequence[i] > key){
                break;
            }
        }
        for(int j = i;j < root;j++){
            // 右区间内如果有结点小于根结点，那就必定不是，返回false
            if(sequence[j] < key){
                return false;
            }
        }
        return isBST (sequence,start,i-1) && isBST (sequence,i,root-1);
    }


    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return isBST(sequence,0,sequence.length-1);
    }
}