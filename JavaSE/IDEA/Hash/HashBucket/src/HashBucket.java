public class HashBucket {

    //哈希桶
    //哈希桶的底层是哈希表，哈希表的底层是数组

    private static class Node{
        private int key;
        private int val;
        Node next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node[] array;
    private int size;
    private static final double LOAD_FACTOR = 0.75;//负载因子

    public int put(int key,int value){
        //先将key转换int型
        //再转换为合法的数组下标
        int index = key % array.length;

        //遍历链表，查找key所在的结点
        //如果找到了，更新其val值
        //如果所有结点都不是key，插入一个新的结点
        for(Node cur = array[index];cur != null; cur = cur.next){
            if(key == cur.key){
                int oldVal = cur.val;
                cur.val = value;
                return oldVal;

            }
        }

        //找不到将其头插入链表
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        size++;

        //扩容
        if(loadFactor() >= LOAD_FACTOR){
            resize();
        }

        return -1;
    }


    //扩容
    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for(int i = 0;i<array.length;i++){
            Node next;
            for(Node cur = array[i]; cur != null; cur = next){
                next = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }

    //求负载因子
    private double loadFactor() {
        return size * 1.0 /array.length;
    }

    //获取
    public int get(int key){
        int index = key % array.length;

        Node head = array[index];
        for(Node cur = head; cur != null;cur = cur.next){
            if(key == cur.key){
                return cur.val;
            }
        }
        return -1;
    }

    //删除
    public int remove(int key){
        int index = key % array.length;
        Node head = array[index];
        //如果第一个结点就是需要删除的结点，直接让head等于第一个结点的next
        if(head != null && key == head.key){
            array[index] = array[index].next;
            return array[index].val;
        }
        Node prev = null;
        for(Node cur = head;cur != null;cur = cur.next){
            if(key == cur.key){
                prev.next = cur;
                return cur.val;
            }
            prev = cur;
        }
        return -1;
    }


    public static void main(String[] args) {
        HashBucketKV hash = new HashBucketKV ();

        hash.put (1,1);
        hash.put (2,2);
        hash.put (3,3);

        System.out.println (hash);
    }
}
