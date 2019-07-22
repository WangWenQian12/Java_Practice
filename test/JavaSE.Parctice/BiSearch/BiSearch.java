import java.util.Scanner;

public class BiSearch{
	
	public static int biSearch(int a[],int n){
		int left = 0;
		int right = a.length;
		while(left<right){
			int mid = (left + right)/2;
			if(n>a[mid]){
				left = mid + 1; 
			}
			else if(n<a[mid]){
				right = mid;
			}
			else{
				return mid;
			}
		}
		return -1;
		//return mid;
	}	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please inter the number of the order array:");
		int n = input.nextInt();
		int[] arr = new int[n];
		System.out.println("Please inter the array:");
		for(int i=0;i<n;i++){
			arr[i] = input.nextInt();
		}
		System.out.println("Please inter the number you want to search:");
		int m = input.nextInt(); 
		if(biSearch(arr,m)==-1){
			System.out.println("No exit!");
		}
		else{
			System.out.println("Find it! The index is "+biSearch(arr,m));
		}
	}
}