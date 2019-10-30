import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

//哈希表的key不是有序的

public class test {

    //哈希桶
    private static class Node{
        private int key;
        private int val;
        private Node next;

        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node[] array;
    private int size = 0;

    HashMap<Node,List<Node>> hashbucket = new HashMap<> ();

    public int get(int key){
        int index = key/array.length;
        Node head = array[index];
        for(Node cur = head;cur != null;cur = cur.next){
            if(cur.val == key){
                return cur.val;
            }
        }
        return -1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        test test = (test) o;
        return size == test.size &&
                Arrays.equals (array, test.array) &&
                Objects.equals (hashbucket, test.hashbucket);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash (size, hashbucket);
        result = 31 * result + Arrays.hashCode (array);
        return result;
    }

    public static void main(String[] args) {
        String s = "Hello" + " " + "WWQ";

    }
}
