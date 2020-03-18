import java.util.Scanner;

public class Main{

    // 人民币转换

    public static void translate(String str){
        String[] sts = str.split ("\\.");
        String s = sts[0];
        StringBuilder sb=new StringBuilder("人民币");
        // 处理小数点之前的数据
        for (int j=0,i=s.length()-1;i>=0;i--,j++){
            // 最高位不为0
            if (s.charAt(j)!='0') {
                // 有四个或四个的倍数个数字。当前位的下一位和下下一位为0。
                if (j>=3 && i%4==0 && s.charAt(j-1)=='0'&&s.charAt(j-2)=='0'){
                    sb.append("零");
                }
                // 有三个数字，且当前位为1
                if (s.charAt(j)=='1' && i%4-1==0) {
                }else {
                    // 其他情况
                    sb.append(Num(s.charAt(j)));
                }
            }
            if (i!=0) {
                if (i % 8 == 0 && i >= 8) {
                    sb.append("亿");
                }
                if (i % 4 == 0 && i % 8 != 0) {
                    sb.append("万");
                }
                if (i % 4-3 == 0 && s.charAt(j)!='0') {
                    sb.append("仟");
                    // 处理 “0” 的情况
                    if (s.charAt(j+1)=='0'&&s.charAt(j+2)!='0'){
                        sb.append("零");
                    }
                }
                if (i % 4-2 == 0 && s.charAt(j)!='0') {
                    sb.append("佰");
                    if (s.charAt(j+1)=='0'&& s.charAt(j+2)!='0'){
                        sb.append("零");
                    }
                }
                if (i % 4-1 == 0&& s.charAt(j)!='0') {
                    sb.append("拾");
                }
            }
        }
        if (s.charAt(0)!='0'){
            sb.append("元");
        }
        // 判断小数点之后的数据
        if (sts[1].equals("00")){
            sb.append("整");
        }else{
            if (sts[1].charAt(0)=='0'){
                sb.append(Num(sts[1].charAt(1)));
                sb.append("分");
            }
            if (sts[1].charAt(1)=='0'){
                sb.append(Num(sts[1].charAt(0)));
                sb.append("角");
            }
            if (sts[1].charAt(0)!='0'&&sts[1].charAt(1)!='0'){
                sb.append(Num(sts[1].charAt(0)));
                sb.append("角");
                sb.append(Num(sts[1].charAt(1)));
                sb.append("分");
            }
        }
        System.out.println(sb);
    }


    public static String Num(char c){
        if (c =='1'){
            return "壹";
        }if (c =='2'){
            return "贰";
        }if (c =='3'){
            return "叁";
        }if (c =='4'){
            return "肆";
        }if (c =='5'){
            return "伍";
        }if (c =='6'){
            return "陆";
        }if (c =='7'){
            return "柒";
        }if (c =='8'){
            return "捌";
        }if (c =='9'){
            return "玖";
        }
        return null;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext ()) {
            String str = sc.nextLine ();
            translate (str);
        }
    }
}