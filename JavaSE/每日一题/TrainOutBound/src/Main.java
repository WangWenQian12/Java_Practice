import java.util.*;

public class Main {

    //三辆火车进站，求其所有的出站顺序的可能性
    //用栈实现
    //先将所有的出站顺序列出来（可能不合法）
    //再判断这些顺序中合法的序列

    public static ArrayList<int[]> list = new ArrayList<>();//所有序列
    public static ArrayList<String> res = new ArrayList<> ();//合法序列


    //判断序列是否合法
    //将进站序列依次压入栈中，如果栈顶元素和当前出站序列相同，则出栈
    //直到进站序列全部压入栈
    //如果栈为空，则说明合法
    public static boolean legalOrder(int[] in,int[] out,int n){
        Stack<Integer> stack = new Stack<> ();
        int j = 0;
        for(int i = 0; i < n;i++){//控制压栈次数
            stack.add (in[i]);
            while(j < n && !stack.isEmpty ()  && stack.peek () == out[j] ){
                stack.pop ();
                j++;
            }
        }
        return stack.isEmpty ();
    }


    //求出所有可能序列
    public static void allOrder(int n,int[] arr,int begin){
        if(begin == n-1){//只剩下一个元素了，不用交换了
            int[] tmp = arr.clone ();
            list.add(tmp);
            return;
        }
        for(int i = begin;i < n;i++){
            swap(arr,i,begin);
            allOrder (n,arr,begin+1);
            swap(arr,i,begin);
        }

    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //将数组转字符串
    public static String arrToStr(int[] t,int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(t[i]);//附加此字符
            if (i != n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }



    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt ();
        }

        allOrder (n,arr,0);

        //判断序列是否合法，合法的话将其添加进res中
        for(int[] t : list){
            if(legalOrder (arr,t,n)){
                String s = arrToStr(t,n);
                res.add (s);
            }
        }

        Collections.sort(res);
        for (String r : res) {
            System.out.println(r);
        }




    }


}
