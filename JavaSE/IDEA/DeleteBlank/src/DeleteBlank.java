import java.util.Scanner;

public class DeleteBlank {

    //删除字符串中首尾的空格，中间的连续空格只留一个，原来的字符串顺序不变。
    //思路:
    //1.先分别将字符串数位的空格删除，分别得到字符串首和尾第一个不为空格的字符的下标
    //2.通过substring得到删掉头尾空格的字符串
    //3.遍历新字符串，将字符附加到result中，连续的空格除过第一个其余不附加


    public static StringBuffer deleteBlank(String str){
        int p1=0;
        int p2=str.length()-1;
        int count1 =0;
        int count2=0;
        while(p1<str.length()){
            if(str.charAt(p1)==' '){
                p1++;
                //count1++;
            }
            else{
                break;
            }
        }
        while(p2>=0){
            if(str.charAt(p2)==' '){
                p2--;
                //count2++;
            }
            else{
                break;
            }
        }
        String newStr = str.substring(p1,p2+1
        );//返回源字符串的子字符串，参数分别为起始下标和结束下标

        StringBuffer result = new StringBuffer();
        boolean space = false;//用来记录前一个是否为空格，默认不是
        for(int i=0;i<p2+1-p1;i++){
            if(newStr.charAt(i)!=' '){
                space = false;
                result.append(newStr.charAt(i));
            }else if(space == true){//说明前一个是空格且当前也是空格

            }else{
                result.append(newStr.charAt(i));
                space = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please inter the string:");
        String str = input.nextLine();

        System.out.println(deleteBlank(str));
    }
}
