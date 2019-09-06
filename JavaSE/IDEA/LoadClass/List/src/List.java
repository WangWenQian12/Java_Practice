public class List{
    int size = 0;

    public void insert(int index,int val){
        System.out.println("null");
    }
    public void pushFront(int val){
        insert(0,val);
    }
    public void pushBack(int val){
        insert(size,val);
    }
}