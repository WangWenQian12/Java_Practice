
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyTreeMap {

    public static class MyEntry{
        private int key;
        private int val;
        private MyEntry left;
        private MyEntry right;

        MyEntry(int key,int val){
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return val;
        }

        @Override
        public String toString() {
            return String.format("%d=%d",key,val);
        }
    }

    private static MyEntry root = null;

    //查找,找到返回值，找不到返回-1
    public static int get(int key){
        MyEntry cur = root;
        while(cur != null){
            if(key == cur.key){
                return cur.val;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return -1;
    }

    //查找，找不到返回缺省值
    public static int gerOrDefault(int key,int defaultValue){
        MyEntry cur = root;
        while(cur != null){
            if(key == cur.key){
                return cur.val;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return defaultValue;
    }

    //修改，修改成功返回原key来的value
    public static int set(int key,int value){
        if(root == null){
            root = new MyEntry (key,value);
            return -1;
        }

        MyEntry parent = null;
        MyEntry cur = root;
        while(cur != null){
            if(key == cur.key){
                int oldValue = cur.val;
                cur.val = value;
                return oldValue;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }

        if(cur == parent.left){
            parent.left = new MyEntry (key,value);
        }else{
            parent.right = new MyEntry (key,value);
        }

        return -1;
    }

    //删除结点
    public static int remove(int key){
        MyEntry parent = null;
        MyEntry cur = root;
        while(cur != null){
            if(key == cur.key){
                removeEntry(parent,cur);
                return cur.val;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        return -1;
    }

    private static void removeEntry(MyEntry parent,MyEntry cur) {
        //分情况讨论

        if(cur.left == null){
            if(cur == root){
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        }else{
            //cur的左右结点均不为空，则用替代法，找一个替罪羊，而这个最合适的替罪羊为根结点的右孩子的最深层的左孩子
            MyEntry goatParent = cur;
            MyEntry goat = cur.right;

            while(goat.left != null){
                goatParent = goat;
                goat = goat.left;
            }

            cur.key = goat.key;
            cur.val = goat.val;

            if(goat == goatParent.left){
                goatParent.left = goat.right;
            }else{
                goatParent.right = goat.right;
            }

        }
    }

    //获取二叉树的所有的key
    //Set:不包含重复元素的集合
    public static Set<Integer> keySet(){
        return inorderKeySet(root);
    }

    private static Set<Integer> inorderKeySet(MyEntry node) {
        Set<Integer> set = new HashSet<> ();
        if(node != null){
            Set<Integer> left = inorderKeySet (node.left);
            Set<Integer> right = inorderKeySet (node.right);
            set.addAll (left);
            set.add(node.key);
            set.addAll (right);
        }
        return set;
    }


    //查找是否存在key
    public boolean containsKey(int key){
        return get(key) != -1;
    }

    public static void main(String[] args) {
        System.out.println (set(1,1));
        System.out.println (set(2,2));
        System.out.println (set(3,3));
        System.out.println (set(4,4));
        System.out.println (set(5,5));

        System.out.println ();
        System.out.println ("查找不存在的值，期待返回缺省值-1：");
        System.out.println (gerOrDefault (6,-1));

        System.out.println ();
        System.out.println ("修改key为3的value，期待返回3：");
        System.out.println (set(3,30));

        System.out.println ();
        System.out.println ("期待返回所有的key值:");
        System.out.println (keySet ());

        System.out.println ();
        System.out.println ("删除key为3的结点,期待返回30：");
        System.out.println (remove (3));

        System.out.println ();
        System.out.println ("期待返回所有的key值:");
        System.out.println (keySet ());

        System.out.println (root.right.right);






    }
}
