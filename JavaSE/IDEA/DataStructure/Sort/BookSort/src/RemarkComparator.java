import java.util.Comparator;

public class RemarkComparator implements Comparator<Book> {

    boolean as;

    public RemarkComparator(boolean as){
        this.as = as;
    }

    @Override
    public int compare(Book o1, Book o2) {
        if(as) {
            return o1.remark - o2.remark;//从低到高排序
        }else{
            return o2.remark - o1.remark;//从高到底排序
        }
    }
}
