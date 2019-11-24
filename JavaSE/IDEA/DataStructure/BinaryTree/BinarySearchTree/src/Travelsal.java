public class Travelsal {
    public static void inOrder(BinarySearchTree.Node root) {
        if(root == null){
            return;
        }

        inOrder (root.left);
        System.out.print (root.key + " ");
        inOrder (root.right);
    }

    public static void preOrder(BinarySearchTree.Node root) {
        if(root == null){
            return;
        }

        System.out.print (root.key + " ");
        preOrder (root.left);
        preOrder (root.right);
    }
}
