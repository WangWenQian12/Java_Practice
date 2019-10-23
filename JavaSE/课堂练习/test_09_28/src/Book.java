import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class AuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.author.compareTo (o2.author);
    }
}

class TitleComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o1.title.compareTo (o2.title);
    }
}

class PriceComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return (int)((o1.price - o2.price)*100);
    }
}

class SaleComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o1.sale - o2.sale;
    }
}

class RemarkComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o1.remark - o2.remark;
    }
}

public class Book implements Comparable<Book> {

    String ISBN;
    String author;
    String title;
    double price;
    int sale;
    int remark;

    public Book(){}

    public Book(String ISBN, String author, String title, double price, int sale, int remark) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.price = price;
        this.sale = sale;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return  "\r\n"+
                "ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", remark=" + remark ;

    }

    @Override
    public int compareTo(Book o) {
        return ISBN.compareTo (o.ISBN);
    }

    public static void main(String[] args) {

        List<Book> book = new ArrayList<> ();
        book.add(new Book("0170928","路遥","平凡的世界",39.9,500000,76345));
        book.add(new Book("0190928","余华","活着",49.9,570000,56345));
        book.add(new Book("9787201151304", "从一到无穷大", "[美] 乔治·伽莫夫", 1600, 400, 26));
        book.add(new Book("9787020147465", "应物兄", "李洱", 7900, 1668, 300));
        book.add(new Book("9787220107085", "如何写甲骨文", "日本文字文化机构", 8800, 23, 6));
        book.add(new Book("9787521706635", "敌人与邻居", "[英]伊恩·布莱克", 10800, 3, 0));
        book.add(new Book("9787301280751", "法国大革命 (第2版)", "布兰宁(T.C.W.Blanning)", 4500, 1993, 188));

        List<Book> copy;

        System.out.println ("按ISBN排序：" + " ");
        copy = new ArrayList<> (book);
        Sort.sort(copy);
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按作者排序：" + " ");
        copy = new ArrayList<> (book);
        Sort.sort(copy,new AuthorComparator());
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按题目排序：" + " ");
        copy = new ArrayList<> (book);
        Sort.sort(copy,new TitleComparator());
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按价格排序：" + " ");
        copy = new ArrayList<> (book);
        Sort.sort(copy,new PriceComparator());
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按销售量排序：" + " ");
        copy = new ArrayList<> (book);
        Sort.sort(copy,new SaleComparator());
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按评论量排序：" + " ");
        copy = new ArrayList<> (book);
        Sort.sort(copy,new RemarkComparator());
        System.out.println (copy);




        /*Book p = new Book ();
        p.ISBN = 20170928; p.author = "路遥";  p.title = "平凡的世界"; p.price = 39.9; p.sale = 500000; p.remark = 76345;
        Book q = new Book ();
        q.ISBN = 20190928; q.author = "余华";  q.title = "活着"; p.price = 49.9; p.sale = 700000; p.remark = 86345;

        System.out.printf ("用ISBN比较："+" ");
        int i = p.compareTo(q);
        if(i > 0){
            System.out.println ("p的ISBN大");
        }else if(i == 0){
            System.out.println ("一样大");
        }else{
            System.out.println ("q的ISBN大");
        }

        Comparator<Book> author = new AuthorComparator();
        System.out.printf ("用作者比较："+" ");
        int a= author.compare (p,q);
        if(a > 0){
            System.out.println ("p的作者");
        }else if(a == 0){
            System.out.println ("一样");
        }else{
            System.out.println ("q的作者");
        }

        Comparator<Book> name = new TitleComparator();
        System.out.printf ("用书名比较："+" ");
        int n = name.compare (p,q);
        if(n > 0){
            System.out.println ("p的书名");
        }else if(n == 0){
            System.out.println ("一样");
        }else{
            System.out.println ("q的书名");
        }

        Comparator<Book> price = new AuthorComparator();
        System.out.printf ("用价格比较："+" ");
        int pr = price.compare (p,q);
        if(pr > 0){
            System.out.println ("p的价格贵");
        }else if(pr == 0){
            System.out.println ("一样");
        }else{
            System.out.println ("q的价格贵");
        }
        */


    }
}
