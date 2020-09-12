public class Solution {

    // 翻转单词顺序列

    public String ReverseSentence(String str) {
        if(str.length () == 0){
            return "";
        }
        char[] arr = str.toCharArray ();

        // 整体翻转
        reverse (arr,0,arr.length-1);
        // 逐个单词翻转
        int i = 0;
        int j = 0;
        while(i < arr.length){
            if(arr[i] == ' '){
                // 此时i，j指向空格
                i++;
                j++;
            }else if(arr[j] == ' ' || j == arr.length-1){
                // 此时i指向单词第一个字母，j指向单词最后一个字母，需要翻转
                reverse (arr,i,j-1);
                j++;
                i = j;
            }else{
                j++;
            }
        }
        return String.valueOf (arr);

    }
    private void reverse(char[] arr, int begin, int end){
        while(begin < end){
            char tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
        }
    }
}