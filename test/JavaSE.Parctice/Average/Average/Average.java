
import java.util.Scanner;

//去掉一个最高分，去掉一个最低分，求平均值
public class Average{
	
	public static double average(int a[]){
		int sum=0;
		int max = a[0];
		int min = a[0];
		for(int i=0;i<a.length;i++){	
			if(a[i]>max){
				max=a[i];
			}
		}
		for(int i=0;i<a.length;i++){
			if(a[i]<min){
				min=a[i];
			}	
		}
		for(int i=0;i<a.length;i++){
			sum += a[i];
		}
		return (double)(sum-max-min)/(a.length-2);
		
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please inter the number of grade:");
		int n = input.nextInt();
		System.out.println("Please inter all grade:");
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++){
			arr[i]=input.nextInt();
		}
		System.out.println("The average grade is:"+average(arr));
		
	}
}