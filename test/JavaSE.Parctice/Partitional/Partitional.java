
import java.util.Scanner;
import java.util.Arrays;

public class Partitional{
	public static void swap(int a[],int i,int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static int[] partitional(int nums[]){
		int left = 0;
		int right = nums.length-1;
		while(left<right){
			if(left<right && nums[left]%2==0){
				left++;
			}
			if(left<right && nums[right]%2!=0){
				right--;
			}
			swap(nums,left,right);
		}
		return nums;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the number of your array:");
		int n = input.nextInt();
		System.out.println("Enter the array:");
		int a[] = new int[n];
		for(int i=0;i<n;i++){
		  a[i] = input.nextInt();
		}
		System.out.println(Arrays.toString(partitional(a)));
	}
}