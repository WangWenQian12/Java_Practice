/*class CNode{
    String name;
    String phone;
    CNode left;
    CNode right;

    CNode(String name,String phone){
        this.name = name;
        this.phone = phone;
    }

}*/

public class Contact {

    private Node root = null;

    public String search(String name,String phone){
        Node cur = root;
        int r = name.compareTo (cur.name);
        while(cur != null){
            if(r == 0){
                return cur.phone;
            }else if(r < 0){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
