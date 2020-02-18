public class Main {

    //镜像二叉树

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }

        public String toString(){
            return String.format ("%d",val);
        }
    }


    public static void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror (root.left);
        Mirror (root.right);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode (8);
        TreeNode h1 = new TreeNode (6);
        TreeNode h2 = new TreeNode (10);
        TreeNode h3 = new TreeNode (5);
        TreeNode h4 = new TreeNode (7);
        TreeNode h5 = new TreeNode (9);
        TreeNode h6 = new TreeNode (11);
        root.left = h1;
        root.right = h2;
        h1.left = h3;
        h1.right = h4;
        h2.left = h5;
        h2.right = h6;

        Mirror(root);



    }
}
