import java.util.Scanner;

public class Average1{
	
	public static double average(int a[]){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum=0;
		for(int v:a){
			sum+=v;
			if(v>max){
				max=v;
			}
			if(v<min){
				min=v;
			}
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