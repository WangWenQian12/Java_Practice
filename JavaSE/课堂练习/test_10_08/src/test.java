class Node{
    int key;
    int value;
    String name;
    String phone;
    Node left;
    Node right;

    Node(int key){
        this.key = key;
    }

    Node(String name,String phone){
        this.name = name;
        this.phone = phone;
    }
}

public class test {

    //搜索树
    Node root = null;

    //1.查找
    public Node search(int key){
        Node cur = root;
        while(cur != null){
            if(key == cur.key){
                return cur;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }

    //2.插入
    public boolean insert(int key){
        if(root == null){
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;

        while (cur != null) {
            if(key == cur.key){
                return false;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }

        Node root = new Node(key);
        if(key < parent.key){
            parent.left = root;
        }else{
            parent.right = root;
        }
        return true;

    }

    //3.删除
    public boolean remove(int key){
        Node cur = root;
        Node parent = null;
        while(cur != null){

        }
        return false;
    }

    //替换法删除



    public static void main(String[] args) {
        int[] keys = {3,7,5,6,1,8,2};




    }
}
