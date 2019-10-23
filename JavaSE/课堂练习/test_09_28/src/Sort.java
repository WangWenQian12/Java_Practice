import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void sort(List<Book> list){
        for(int i = 1;i<list.size();i++){
            Book book = list.get(i);
            int j = i - 1;
            for(;j >= 0 && list.get(j).compareTo (book) > 0;j--){
                list.set(j+1,list.get(j));
            }
            list.set(j+1,book);
        }
    }


    public static void sort(List<Book> list, Comparator<Book> comparator){
        for(int i = 1;i < list.size();i++){
            Book book = list.get(i);
            int j = i - 1;
            for(;j >= 0 && comparator.compare (list.get(j),book) > 0;j--){
                list.set(j+1,list.get(j));
            }
            list.set(j+1,book);
        }
    }

}
