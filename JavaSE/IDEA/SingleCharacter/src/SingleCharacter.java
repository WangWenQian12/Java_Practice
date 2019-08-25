import java.util.Scanner;

public class SingleCharacter {

    //在字符串中找出第一个只出现一次的字符。如输入“abaccdeff”,则输出‘b’，要求时间复杂度为O(n).
    //思路：
    //1.空间换取时间，HashMap(时间复杂度为1)
    //2.一个数组a用来记录每一个字符出现的次数，比如1出现俩次，那么a[1]=2;
    //3.遍历数组，得到值为1的元素，记录下标，break
    //4.输出a[pos]

    public static char getSingleChar(String str){

        int[] a = new int[200];//依照ASCII码设置数组大小，用来做映射数组

        for(int i=0;i<str.length();i++){
            a[str.charAt(i)]++;
        }

        int pos = 0;
        for(int i=0;i<a.length;i++){
            if(a[str.charAt(i)]==1){
                pos = i;
                break;
            }
        }
        return str.charAt(pos);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please inter the string:");
        String str = input.nextLine();

        System.out.println(getSingleChar(str));
    }
}
