public class MyArrayList {

    private int[] array;
    private int size;

    public MyArrayList(){
        array = new int[2];
        size = 0;
    }

    //头插
    public void pushFront(int v){
        ensureCapacity();
        for(int i=size;i>=1;i--){
            array[i] = array[i-1];
        }
        array[0] = v;
        size++;
    }

    //尾插
    public void pushBack(int v){
        ensureCapacity();
        array[size++] = v;
    }

    //插入
    public void push(int index,int v){
        if(index<0 || index>size){
            System.err.println("error!");
            return;
        }
        ensureCapacity();
        for(int i = size;i>=index;i--){
            array[i] = array[i-1];
        }
        array[index] = v;
        size++;
    }

    //头删
    public void popFront(){
        if(size==0){
            System.err.println("error!");
            return;
        }
        for(int i=0;i<size-1;i++){
            array[i] = array[i+1];
        }
        size--;
    }

    //尾删
    public void popBack(){
        if(size==0){
            System.err.println("error!");
            return;
        }
        array[--size] = 0;

    }

    //删除
    public void delete(int index){
        if(index<0 || index>size){
            System.err.println("error!");
            return;
        }
        for(int i=index;i<size-1;i++){
            array[i] = array[i-1];
        }
        size--;
    }

    //查找
    //1.通过下标返回元素
    public int getV(int index){
        if(index<0 || index>size){
            System.err.println("error!");
            return -1;
        }
        return array[index];
    }

    //2.返回顺序表中v出现的下标，如果出现多次，只返回第一次出现的下标
    public int indexOf(int v){
        for(int i=0;i<size;i++){
            if(array[i] == v){
                return i;
            }
        }
        return -1;
    }

    //修改
    public void set(int index,int v){
        if(index<0 || index>size){
            System.err.println("error!");
            return;
        }
        array[index] = v;
    }

    //删除v，如果出现多次，只删除第一个
    public void remove(int v){
        int index = indexOf(v);
        if(index != -1){
            delete(index);
        }
    }

    //删除v，如果出现多次，全都删除
    public void removeAll(int v){
        int j=0;
        for(int i=0;i<size;i++){
            if(array[i] != v){
                array[j++]=array[i];
            }
        }
        size=j;
    }


    //扩容
    public void ensureCapacity(){
        if(size < array.length){
            return;
        }
        int newSize = size*2;
        int[] newArray = new int[newSize];
        for(int i=0;i<size;i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    //打印
    public void print(){
        System.out.println("顺序表为：");
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        MyArrayList list = new MyArrayList();
        list.pushFront(3);
        list.pushFront(2);
        list.pushFront(1);
        list.pushFront(0);
        list.print();
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(6);
        list.pushBack(7);
        list.print();
        list.popFront();
        list.popBack();
        list.print();
        list.push(3,2);
        list.push(6,2);
        list.print();
        list.removeAll(2);
        list.print();



    }
}
