import java.util.Scanner;
import java.util.Stack;

public class Main {

    // 给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。
    // 利用栈，如果新插入的数字小于栈顶元素时，记录（全程用数组下标记录）

    public static int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<> ();

        for(int i = 0; i < arr.length;i++){
            // 出现小于当前位置的数字了
            while(!stack.isEmpty () && arr[stack.peek ()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push (i);
        }
        while(!stack.isEmpty ()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt ();
        }
        int[][] res = getNearLessNoRepeat(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i][0]).append(" ").append(res[i][1]).append('\n');
        }
        System.out.print(sb);
    }
}
