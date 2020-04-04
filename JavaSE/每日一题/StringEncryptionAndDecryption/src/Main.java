import java.util.*;

public class Main{

    // 加密解密字符串

    // 加密
    public static void encrypt(String str){
        String res = "";
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) <= 'Z' && str.charAt(i) >= 'A'){
                if(str.charAt(i) == 'Z'){
                    res += 'a';
                }else{
                    char c = str.charAt (i);
                    res += (char)(c + 1 + 32);

                }
            }
            if(str.charAt(i) <= 'z' && str.charAt(i) >= 'a'){
                if(str.charAt(i) == 'z'){
                    res += 'A';
                }else{
                    char c = str.charAt (i);
                    res += (char)(c + 1 - 32);
                }
            }
            if(str.charAt(i) <= '9' && str.charAt(i) >= '0'){
                if(str.charAt(i) == '9'){
                    res += '0';
                }else{
                    char c = str.charAt (i);
                    res += (char)(c+1);
                }
            }
        }
        System.out.println(res);
    }

    // 解密
    public static void decode(String str){
        String res = "";
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) <= 'Z' && str.charAt(i) >= 'A'){
                if(str.charAt(i) == 'A'){
                    res += 'z';
                }else{
                    char c = str.charAt (i);
                    res += (char)(c - 1 + 32);
                }
            }
            if(str.charAt(i) <= 'z' && str.charAt(i) >= 'a'){
                if(str.charAt(i) == 'a'){
                    res += 'Z';
                }else{
                    char c = str.charAt (i);
                    res += (char)(c - 1 - 32);
                }
            }
            if(str.charAt(i) <= '9' && str.charAt(i) >= '0'){
                if(str.charAt(i) == '0'){
                    res += '9';
                }else{
                    char c = str.charAt (i);
                    res += (char)(c-1);
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            encrypt(str1);
            decode(str2);
        }
    }
}