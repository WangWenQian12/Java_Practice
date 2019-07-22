
import java.util.Arrays;

public  class Rotate{
	
	public static int[] rotate(int a[],int k){
		k = k % a.length;
		int b[] = Arrays.copyOfRange(a,a.length-k,a.length);
		System.arraycopy(a,0,a,k,a.length-k);
		System.arraycopy(b,0,a,0,k);
		return a;
	}		
	
	public static void main(String[] args){
		int[] a={1,2,3,4,5};
		//System.out.println(Arrays.toString(rotate(a,3)));
		System.out.println(Arrays.toString(rotate(a,8)));
		System.out.println(Arrays.toString(rotate(new int[]{1,2,3,4,5,6,7,8,9,},1)));
	}
}