
import java.lang.String;
//import java.lang.

public class DecToHex{
	public static String Reverse(String s)
	{
		int length = s.length();
		String c = "";
		for(int i = length-1;i>=0;i--){
			c += s.charAt(i);
		}
		return c;
	}
	
	public static String decToHex(int n){
		String s = "";
		while(n>0){
			int res = n % 16;
			int ret = n / 16;
			if(res > 9){
				char c = (char)((res-10) +'A');
				s += c;
			}
			else{
				s += res;
			}
			n = ret;
		}
		return Reverse(s);
		
	}
	public static void main(String[] args){
		System.out.println(decToHex(300));
	}
}