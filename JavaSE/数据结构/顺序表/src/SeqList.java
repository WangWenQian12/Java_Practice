public class SeqList {

    private int array[];  //属性
    private int size;

    //构造方法
    public SeqList(){
        array = new int[2];  //申请空间
        size = 0;     //初始化数据
    }

    //头插
    public void pushFront(int v){
        ensureCapacity();
        for(int i = size;i > 0;i--){
            array[i] = array[i-1];
        }
        array[0] = v;
        size++;
    }
    //尾插
    public void pushBack(int v){
        ensureCapacity();
        array[size] = v;
        size++;
        //array[size--] = v;
    }
    //插入
    public void push(int index,int v){
        ensureCapacity();
        for(int i = size;i > index;i--){
            array[i] = array[i-1];
        }

        array[index] = v;
        size++;
    }

    //头删
    public  void popFront(){
        if(size==0){
            System.err.println("顺序表为空！");
            return;
        }
        for(int i = 0;i < size-1;i++){
            array[i] = array[i+1];
        }
        size--;
        array[size]=0;
        //a[--size]=0;
    }

    //尾删
    public  void popBack(){
        if(size==0) {
            System.err.println("顺序表为空！");
            return;
        }
        array[--size]=0;
    }

    //删除
    public  void delete(int index){
        if(size==0){
            System.err.println("顺序表为空！");
            return;
        }
        if(index<0 || index>size){
            System.err.println("下标错误！");
            return;
        }
        for(int i = index+1;i < size;i++){
            array[i-1] = array[i];
        }
        /*for(int i = index;i <= size-2;i++){
            array[i] = array[i+1];
        }*/
        array[--size]=0;
    }

    //扩容
    private void ensureCapacity(){
        if(size<array.length){
            return;
        }
        int newSize = array.length * 2;
        int newArray[] = new int[newSize];
        for(int i=0;i<size;i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    //打印
    public void print(){
        System.out.printf("当前容量：%d%n",array.length);
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        SeqList list = new SeqList();
        list.print();
        list.pushFront(3);
        //list.print();
        list.pushFront(2);
        list.pushFront(1);
        list.print();//1,2,3
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        list.print();//1 2 3 666 10 20 30
        list.push(3,666);
        list.print();
        list.popFront();
        list.print();//2 3 666 10 20 30
        list.popBack();
        list.print();//2 3 666 10 20
        list.delete(2);
        list.print();//2 3 10 20
    }

}
