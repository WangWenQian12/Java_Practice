import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {


    //一个数组中找到加起来为0的三个数字
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        for(int i = 0;i < nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k && nums[i]+nums[j]+nums[k]<0){
                j++;
            }
            if(j >= k){//j和k相遇
                break;
            }
            if(nums[i]+nums[j]+nums[k]<0){
                List<Integer> e = new ArrayList();
                e.add(i);
                e.add(j);
                e.add(k);
                list.add(e);
            }
         //没写完！！！！！！！！！！！！！！！！！！！！！！！
        }
        return list;

    }

    //实现栈(线性表（数组）)
    public class myStack{
        //Stack stack = new ArrayList();
        Stack<?> stack = new Stack<> ();
        ArrayList<Integer> list = new ArrayList<>();

    }

    //实现队列（链表）
    public class myQueue{
        Queue<String> queue = new LinkedList<>();



    }


    //括号匹配
    //遍历字符串，遇到左括号入栈，遇到右括号（


    //////////////////////////////////////////////////////////////////////////////////////////////////////

    //栈实现队列（先进先出）
    //俩个栈，一个进，一个出

    //用顺序表实现
    ArrayList<Integer> in = new ArrayList<>();
    ArrayList<Integer> out = new ArrayList<>();

    void push(int x){
        in.add(x);
    }

    int pop(){
        if(out.isEmpty()){//out为空时，将in中的元素加入到out中
            for(int i=0;i<in.size();i++){
                int v = in.remove(in.size()-1);
                out.add(v);
            }
        }
        return out.remove(out.size()-1);
    }

    int peek(){//返回栈顶元素
        if(out.isEmpty()){
            for(int i=0;i<in.size();i++){
                int v = in.remove(in.size()-1);
                out.add(v);
            }
        }
        return in.get(in.size()-1);

    }

    boolean isempty(){
        return in.isEmpty() && out.isEmpty();
    }


    //用栈实现顺序表
    

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    //队列实现栈







    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    //返回栈中最小的元素









    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //循环队列












    /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("哈哈哈哈");
        list.addFirst("学不进去了");
        list.addFirst("太瞌睡了");

        System.out.println (list);

        System.out.println (list.element());
        list.pop();
        System.out.println (list);

    }
}
