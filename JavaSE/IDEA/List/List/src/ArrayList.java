import java.util.Arrays;

public class ArrayList extends List {
    private int[] a = new int[100];

    @Override
    public void insert(int index, int val) {
        for(int i=size;i>index;i--){
            a[i] = a[i-1];
        }
        a[index] = val;
        size++;

        System.out.println(Arrays.toString(Arrays.copyOfRange(a,0,size)));
    }

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.pushBack(1);
        a.pushBack(2);
        a.pushBack(3);
        a.pushFront(10);
        a.pushFront(20);
        a.pushFront(30);
        a.insert(3,11);
    }
}

