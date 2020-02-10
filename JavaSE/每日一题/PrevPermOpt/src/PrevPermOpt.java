import java.util.Arrays;

public class PrevPermOpt {


    //给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、
    // 按字典序排列小于 A 的最大可能排列。如果无法这么操作，就请返回原数组。
    //例：
    // [9,4,3,8,2,3,4,5,6,7,7,8]  那么交换的是下标为3和9的元素
    //1.从后向前找第一个降序的数字，记录下标
    //2.找到该数字后，从该数字的右侧找第一个小于该数字的元素
    //3，交换找到的这俩个数字


    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static int[] prevPermOpt(int arr[]) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {//逆序找到第一个降序的元素
                //向右找第一个最大的小于arr[i]的元素
                int max = Integer.MIN_VALUE;
                int maxIndex = -1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j] && arr[j] > max) {
                        max = arr[j];
                        maxIndex = j;
                    }
                }
                int tmp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmp;
                return arr;//注意：只排序一次，所以此处就要return结果，否则会再次循环排序
            }
        }
        return arr;

    }

        public static void main (String[]args){
            int[] arr = {9,4,3,8,2,3,4,5,6,7,7,8};
            System.out.println (Arrays.toString(prevPermOpt (arr)));
        }
    }
