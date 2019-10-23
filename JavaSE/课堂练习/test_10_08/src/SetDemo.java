import java.util.Set;
import java.util.TreeSet;

public class SetDemo {



    public static void main(String[] args) {
        Set<String> bucket = new TreeSet<> ();
        bucket.add("苹果");
        bucket.add("香蕉");
        bucket.add("橘子");
        bucket.add("草莓");
        bucket.add("柚子");

        System.out.println (bucket);




    }
}
