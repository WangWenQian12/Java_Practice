
interface List{
    void pushBack(int element);

    void pushFront(int element);

    void insert(int index,int element);
}

abstract class AbstractList implements List{
    protected int size = 0;

    @Override
    public void pushBack(int element) {
        insert(size,element);
    }

    @Override
    public void pushFront(int element) {
        insert(0,element);
    }
}

class ArrayList extends AbstractList implements List{
    private int[] array = new int[100];

    @Override
    public void insert(int index, int element) {
        for(int i=size;i>index;i--){
            array[i] = array[i-1];
        }
        array[index]=element;
        size++;
    }
}

public class Main {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.pushFront(1);
        a.pushFront(2);
        a.pushFront(3);
        a.pushBack(10);
        a.pushBack(20);
        a.pushBack(30);
        a.insert(3,66);
        System.out.println("hhh");

    }

}
