import java.util.*;

public class Main{

    // 检查密码是否合法
    // 1.长度超过8位
    // 2.包括大小写字母.数字.其它符号,以上四种至少三种
    // 3.不能有相同长度超2的子串重复

    public static boolean legalLength(String str){
        return str.length() > 8 ? true:false ;
    }

    public static boolean legalCharacter(String str){
        int upperCaseFlag = 0;
        int lowerCaseFlag = 0;
        int numFlag = 0;
        int elseFlag = 0;
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                upperCaseFlag = 1;
                continue;
            }else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                lowerCaseFlag = 1;
                continue;
            }else if(str.charAt(i)>= '0' && str.charAt(i) <= '9'){
                numFlag = 1;
                continue;
            }else{
                elseFlag = 1;
                continue;
            }
        }
        int sum = upperCaseFlag + lowerCaseFlag + numFlag + elseFlag ;
        return sum >= 3 ? true:false;
    }

    public static boolean checkRepeatString(String str){
        for(int i = 0;i < str.length() - 2;i++){
            String s1 = str.substring(i,i+3);
            for(int j = i + 1;j < str.length() - 3;j++){
                String s2 = str.substring(j,j+3);
                if(s1.equals(s2)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if(legalLength(str) && legalCharacter(str) && checkRepeatString(str)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
}