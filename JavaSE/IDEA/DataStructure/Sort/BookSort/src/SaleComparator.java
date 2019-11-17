import java.util.Comparator;

public class SaleComparator implements Comparator<Book> {

    boolean as;

    public SaleComparator(boolean as){
        this.as = as;
    }

    @Override
    public int compare(Book o1, Book o2) {
        if(as) {
            return o1.sale - o2.sale;//从低到高排序
        }else{
            return o2.sale - o1.sale;//从高到低排序
        }
    }
}
