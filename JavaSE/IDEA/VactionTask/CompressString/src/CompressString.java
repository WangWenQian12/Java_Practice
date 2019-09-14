import java.util.Scanner;

public class CompressString {

    //字符串压缩：“xxxyyyyz”压缩为“3x4yz”，“yyyyy”压缩为“5y”。
    //思路：
    //1.遍历字符串，当第i个等于第i+1个时，计数器count自增
    //2.当第i个不等于第i+1个时，说明前i个都是相等的，将其附加到新字符串中


    public static String compressString(String str, int len){


        //满足第二个if时，第一个if也是执行了的
        //不满足第一个和第二个if，进else


        StringBuilder list = new StringBuilder();

        int count = 1;
        int i =0;

        for(i = 0;i<len-1;i++){
            //计算有几个相等的字符count
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }
            else {
                //不相等时说明将第一个字符全部遍历完毕，将其附加到list
                if (count > 1) {
                    String countstr = count + "";
                    for (int j = 0; j < countstr.length (); j++) {
                        list.append (countstr.charAt (j));
                    }
                }
                list.append (str.charAt (i));

                count = 1;
            }
            //最后一个字符
            if(i == len-2){
                if(count>1) {
                    String countstr = count + "";
                    for (int j = 0; j < countstr.length (); j++) {
                        list.append (countstr.charAt (j));
                    }
                }
                list.append(str.charAt(i+1));

            }

        }
        return list.toString();
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("Please inter the string:");
        String str = input.nextLine();

        System.out.println(CompressString.compressString(str,str.length()));
    }
}
