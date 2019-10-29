public class test {

    //泛型(阅读源码时，可以看懂)
    //实现泛型类型的搜索树

    //定义一个泛型类顺序表
    public class MyArrayList<E>{
        private E[] array;
        private int size;

        public MyArrayList(){
            array = (E[])new Object [20];
            size = 0;
        }

        //尾插
        public void add(E e){
            array[size++] = e;
        }

        //尾删
        public E remove(){
            E element = array[size -1];
            array[size -1] = null;
            size--;
            return element;
        }

    }


    public static void main(String[] args) {


    }

}
