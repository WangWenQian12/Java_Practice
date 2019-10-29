


public class HashMap {

    //哈希桶

    private static class Node{
        private int key;
        private int value;
        Node next;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }

    }

    private Node[] array;
    private int size;
    //private static final LOAD_FACTOR =

    //负载因子
    private double loadFactor(){
        return size * 1.0 / array.length;
    }

    //public HashBucket(){

    //}

    public int get(int key){
        return -1;
    }

    public int put(int key,int value){
        //将关键字转为合法下标
        int index = key % array.length;

       // 遍历链表，找到修改
        for(Node cur = array[index]; cur != null;cur = cur.next) {
            if (key == cur.key) {
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
        }
        //始终没找到，直接将该结点进行头插
        Node node = new Node (key, value);
        node.next = array[index];
        array[index] = node;
        size++;

        return -1;
    }


    //扩容(所有结点重新hash，在链表中做头插)
    /*private void resize(){
        Node[] newArray = new Node[array.length * 2];
        for(int i = 0;i<array.length;i++){
            Node next;
            for(Node cur = array[i]; cur != null; cur = next){
                int newIndex = cur.key % newArray.length;
                cur.next = array[i];
                cur = newArray[i];
            }
        }
    }*/


}
