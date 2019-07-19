import java.util.Arrays;

public class BubbleSort{
	public static void swap(int arr[],int i,int j){
			int tmp=arr[i];
			arr[i]=arr[j];
			arr[j]=tmp;
	}
				
	public static void bubSort(int a[]){
		for(int i=0;i<a.length-1;i++){
			boolean sorted = true;
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					swap(a,j,j+1);
					sorted = false;
				}
			}
			if(sorted==true){
				return ;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args){
		int[] a={4,6,2,8,3,10,1};
		int[] b={7,6,5,4,3,2,1};
		int[] c={1,2,3,4,5,6,7};
		int[] d={3,3,3,3,3,3,3};
		bubSort(a);
		bubSort(b);
		bubSort(c);
		bubSort(d);
	}
}