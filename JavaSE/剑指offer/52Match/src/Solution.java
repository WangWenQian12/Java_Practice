public class Solution {

    //正则表达式匹配

    public static boolean match(char[] str, char[] pattern){
        if(str.length == 0 && pattern.length == 0){
            return true;
        }
        if(pattern.length == 0){
            return false;
        }
        return matchExpression(str,0,pattern,0);

    }

    public static boolean matchExpression(char[] str,int i,char[] pat,int j){
        if (i == str.length && j == pat.length) { // 字符串和模式串都为空
            return true;
        } else if (j == pat.length) { // 模式串为空
            return false;
        }
        if (j + 1 < pat.length && pat[j + 1] == '*') {
            //出现了*，并且s和P指向的相同，3种情况并列
            if ((i < str.length && pat[j] == '.')
                    || (i < str.length && pat[j] == str[i])) {
                return matchExpression (str, i, pat, j + 2)
                        || matchExpression (str,  i + 1, pat, j)
                        || matchExpression (str,  i + 1, pat, j + 2);
            } else {//出现了*，并且s和p指向的不同，那就把*前面的字符理解出现了0次，p+2
                return matchExpression (str, i, pat, j + 2);
            }
        }

        if(i < str.length && (str[i] == pat[j] || pat[j] == '.')){
            return matchExpression (str,i+1,pat,j+1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[] arr1 = {'a','a','a'};
        char[] arr2 = {'a','.','a'};
        System.out.println (match(arr1,arr2));
    }
}