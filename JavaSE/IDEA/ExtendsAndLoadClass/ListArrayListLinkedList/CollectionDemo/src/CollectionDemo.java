import java.util.Collection;
import java.util.ArrayList;

public class CollectionDemo {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();

        list.add("i");
        list.add("love");
        list.add("you");
        System.out.println (list);
        System.out.println (list.size());
        System.out.println (list.isEmpty());
        System.out.println();

        list.remove("i");
        System.out.println (list);
        System.out.println (list.size());
        System.out.println (list.isEmpty());

        list.clear();
        System.out.println (list);
        System.out.println (list.size());
        System.out.println (list.isEmpty());
    }
}
