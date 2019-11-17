import java.util.Comparator;

public class PriceComparator implements Comparator<Book> {

    boolean as;

    public PriceComparator(boolean as){
        this.as = as;
    }

    @Override
    public int compare(Book o1, Book o2) {
        if(as){
            return (int)((o1.price - o2.price) * 100);//价格从低到高排序
        }else{
            return (int)((o2.price - o1.price) * 100);//价格从高到低排序
        }

    }
}
