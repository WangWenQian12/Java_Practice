

public class BinarySearchTree {

    //二叉搜索树
    public static class Node{
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }

    }

    private Node root = null;

    //二叉搜索树的查找，找到返回该结点，找不到返回null
    public Node search(int key){
        Node cur = root;
        while(cur != null){
            if(cur.key == key){
                return cur;
            }else if(cur.key < key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;//找不到返回null
    }

    //二叉搜索树的插入，插入成功返回true，失败返回false
    public boolean insert(int key){
        //如果二叉树为空，此节点插入为头结点
        if(root == null){
            root = new Node(key);
            return true;
        }

        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(key == cur.key){
                return false;//如果要插入的数字和二叉树内的结点值相同，则拒绝插入，直接返回false
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }

        Node node = new Node(key);
        if(key < parent.key){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return true;
    }

    //二叉树的删除
    public boolean remove(int key){
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(key == cur.key){
                //找到该结点，删除
                removeNode(parent,cur);
                return true;
            }else if(key <cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        return false;//没找到
    }

    //删除结点，分情况讨论
    private void removeNode(Node parent, Node cur) {
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
        }else{//cur的左右结点均不为空，则用替代法，找一个替罪羊，而这个最合适的替罪羊为根结点的右孩子的最深层的左孩子
            Node goatParent = cur;
            Node goat = cur.right;
            while(goat.left != null){
                goatParent = goat;
                goat = goat.left;
            }

            cur.key = goat.key;//替罪羊的值替换要删掉的结点

            //替罪羊去替代删除的值，替罪羊肯定是没有左孩子的，所以通过判断goat是parent的左右孩子来处理后面的结点
            if(goat == goatParent.left){
                goatParent.left = goat.right;
            }else{
                //说明要删除的结点的右孩子没有左孩子
                goatParent.right = goat.right;
            }
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree ();
        int[] keys = {7,4,9,3,5,1,8,10,12};
        for(int key : keys){
            System.out.print (tree.insert (key)+" ");//插入成功返回true
        }
        System.out.println ();

        //通过前中遍历得到二叉树，看是否为二叉搜索树
        System.out.println ();
        System.out.println ("前序遍历：");
        Travelsal.preOrder(tree.root);

        System.out.println ();
        System.out.println ("中序遍历：");
        Travelsal.inOrder(tree.root);

        //查找一个不存在的数字
        System.out.println ();
        System.out.println ("查找不存在的结点：");
        System.out.println (tree.search (2));//false

        //查找存在的数字
        System.out.println ();
        System.out.println ("查找存在的结点");
        System.out.println (tree.search (7).key);//true

        //插入一个存在的数字
        System.out.println ();
        System.out.println ("插入存在的结点：");
        System.out.println (tree.insert (7));

        //插入一个不存在的数字
        System.out.println ();
        System.out.println ("插入不存在的结点：");
        System.out.println(tree.insert (11));

        System.out.println ();
        System.out.println ("前序遍历：");
        Travelsal.preOrder(tree.root);

        System.out.println ();
        System.out.println ("中序遍历：");
        Travelsal.inOrder(tree.root);


        System.out.println ();
        System.out.println ("删除9：");
        System.out.println (tree.remove (9));

        System.out.println ();
        System.out.println ("删除不存在的结点：");
        System.out.println (tree.remove (15));

        System.out.println ();
        System.out.println ("前序遍历：");
        Travelsal.preOrder(tree.root);

        System.out.println ();
        System.out.println ("中序遍历：");
        Travelsal.inOrder(tree.root);



    }

}
