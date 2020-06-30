import java.util.*;

public class Solution {

    // 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

    Stack<Integer> in = new Stack<> ();
    Stack<Integer> out = new Stack<> ();

    public void push(int node){
        in.add (node);
    }

    public int pop(){
        if(out.isEmpty ()){
            int size = in.size ();
            for(int i = 0;i < size;i++){
                int tmp = in.pop ();
                out.add (tmp);
            }
        }
        return out.pop ();
    }
}
