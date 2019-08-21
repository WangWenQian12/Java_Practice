public class ReplaceSpace {

    //要求写一个函数，将字符串中的所有的空格替换为%20
    //思路：
    //1.先遍历字符串，将空格的数量coutn统计出来
    //2.要将空格替换为%20，则替换后字符串的长度为str.length+count*2
    //3.然后用新的字符串长度，输出替换后的字符串
    //4.如果从前往后替换，后面的字符要多次移动，所以我们从后往前替换

    public static StringBuffer replaceSpace(StringBuffer str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                count++;
            }
        }
        int oldLength = str.length();
        int oldIndex = oldLength-1;
        int newLength = oldLength + count*2;
        int newIndex = newLength-1;

        str.setLength(newLength);
        for(int j=oldIndex;j>=0;j--){
            if(str.charAt(j) == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            } else{
                str.setCharAt(newIndex--,str.charAt(j));
            }
        }
        return str;
    }

    public static void main(String[] args) {
        StringBuffer list = new StringBuffer("abc defgx yz");
        System.out.println(replaceSpace(list));

    }
}
