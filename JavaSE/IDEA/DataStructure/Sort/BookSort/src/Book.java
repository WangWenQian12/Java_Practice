public class Book implements Comparable<Book> {

    //属性
    String ISBN;
    String author;
    String title;
    double price;
    int sale;
    int remark;

    //无参构造方法
    public Book(){}

    //构造方法
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
        return "\r\n" +
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
}
