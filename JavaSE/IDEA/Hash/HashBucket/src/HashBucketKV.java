import java.util.Objects;

import static java.lang.Object.*;

class Person{
    String sn;
    Person(String sn){
        this.sn = sn;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        //如果obj不是Person类型
        if(!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return sn.equals (person.sn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sn);
    }
}


public class HashBucketKV<K,V> {

    //自定义类型的哈希桶

    private static class Node<K,V>{
        private K key;
        private V val;
        private Node<K,V> next = null;

        @Override
        public String toString() {
            return String.format ("%s,%s",key,val);
        }
    }

    //不能直接定义泛型数组，所以将其强转
    private Node<K,V>[] array = (Node<K,V>[])new Node[8];
    private int size;


    public V get(K key){
        //先将key转换为int型，再转换为合法下标
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> head = array[index];
        for(Node<K,V> cur = head;cur != null;cur = cur.next){
            if(key.equals (cur.key)){
                return cur.val;
            }
        }
        return null;
    }

    public V put(K key,V val){
        int hash = key.hashCode ();
        int index = hash % array.length;
        Node<K,V> head = array[index];
        for(Node<K,V> cur = head;cur != null; cur = cur.next){
            if(key.equals (cur.val)){
                V oldVal = cur.val;
                cur.val = val;
                return oldVal;
            }

            Node<K,V> node = new Node<> ();
            node.key = key;
            node.val = val;

            node.next = array[index];
            array[index] = node;
            size++;
        }
        return null;
    }

    public static void main(String[] args) {
        HashBucketKV<Person,String> hash = new HashBucketKV<> ();
        Person p = new Person("11233");
        Person q = new Person ("11233");
        System.out.println (p.hashCode ());
        System.out.println (q.hashCode ());
        hash.put (p,"wwq");
        System.out.println (p);
    }
}
