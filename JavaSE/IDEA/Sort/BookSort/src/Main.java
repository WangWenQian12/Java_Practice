import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Book> list = new ArrayList ();

        list.add (new Book ("0342420170928", "路遥", "平凡的世界", 39.9, 500000, 76345));
        list.add (new Book ("0190923764298", "余华", "活着", 49.9, 570000, 56345));
        list.add (new Book ("9787201151304", "从一到无穷大", "[美] 乔治·伽莫夫", 16.0, 400, 26));
        list.add (new Book ("9787020147465", "应物兄", "李洱", 79.0, 1668, 300));
        list.add (new Book ("9787220107085", "如何写甲骨文", "日本文字文化机构", 18.0, 23, 6));
        list.add (new Book ("9787521706635", "敌人与邻居", "[英]伊恩·布莱克", 34.5, 3, 0));
        list.add (new Book ("9787301280751", "法国大革命 (第2版)", "布兰宁(T.C.W.Blanning)", 45.2, 1993, 188));

        List<Book> copy;//要进行多次排序，用copy排序，这样不会改变原list的顺序

        //自然顺序
        System.out.println ("按ISBN排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy);
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按作者排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy,new AuthorComparator());
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按题目排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy,new TitleComparator());
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按从低到高的价格排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy,new PriceComparator(true));
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按从高到低的价格排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy,new PriceComparator(false));
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按从低到高的销量排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy,new SaleComparator(true));
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按从高到低的销量排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy,new SaleComparator(false));
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按从低到高的评论数排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy,new RemarkComparator(true));
        System.out.println (copy);

        System.out.println ();
        System.out.println ("按从高到低的评论数排序：");
        copy = new ArrayList<> (list);
        Sort.insertSort(copy,new RemarkComparator(false));
        System.out.println (copy);
    }
}
