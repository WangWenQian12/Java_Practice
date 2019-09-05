
public class testList extends test {
    private int[] a = new int[100];

    @Override
    public void insert(int index, int val) {//暂未考虑扩容和下标问题
        for(int i=size;i>index;i--){
            a[i] = a[i-1];
        }
        a[index] = val;
        size++;
    }
}
