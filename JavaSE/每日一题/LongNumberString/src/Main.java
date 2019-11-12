import java.util.Scanner;

public class Main {

    //读入一个字符串，输出字符串str中最长的连续数字串
    //思路：
    //1.遍历字符串，当遇到数字字符且下一个也为数字字符，计数并保存此数字字符
    //2.默认遍历到的第一个数字字符串为最长字符串，再截取到的数字串长度如果大于默认数字串长度，则更新最长数字串

    public static String selectNumberString(String str){
        char[] arr = str.toCharArray ();
        String result = "";//用来保存数字串
        int count = 0;//用来记录数字串的长度

        for(int i = 0; i < arr.length;i++){
            if(arr[i] >= '0' && arr[i] <= '9') {
                count = 1;
                int index = i;
                for(int j = i+1;j<arr.length;j++) {
                    if (arr[j] >= '0' && arr[j] <= '9') {
                        count++;
                        index = j;
                    } else {
                        break;
                    }
                }
                if (count > result.length ()) {
                    result = str.substring (i, index + 1); }
                }else{
                    continue;
                }
        }
        return result;

    }


    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String str = input.nextLine ();
        System.out.println (selectNumberString (str));

    }

}
