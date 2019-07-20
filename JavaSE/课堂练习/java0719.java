import java.util.Arrays;

public class java0719{
	
	public static int[] partitional(int[] nums){
		int begin=0;
		int end=nums.length-1;
		while(begin < end){
			while(begin<end && nums[begin]%2==0){
				begin++;
			}
			while(begin<end && nums[end]%2!=0){
				end--;
			}
			swap(nums,begin,end);
		}
		return nums;
	}
	
	
	public static int[] rotate(int[] nums,int k){
		k = k % nums.length;
		int[] a = Arrays.copyOfRange(nums,k,nums.length);
		System.arraycopy(nums,0,nums,nums.length-k,k);
		System.arraycopy(a,0,nums,0,nums.length-k);
		return nums;
		
		
		/*int[] a;
		int[] b;
		for(int i=0;i<k%nums.length;i++){
			a[i]=nums[i];
		}
		for(int j=nums.length;j>k%nums.length;j--){
			b[j]=nums[i];
		}
		reverse(b);
		System.arraycopy(a,0,b,nums.length-k,k);
		return b;*/
	}
	
	
	
	//去掉一个最大值去掉一个最小值
	public static double average(int a[]){
		int sum=0;
		int max=a[0];
		int min=a[0];
		for(int i=0;i<a.length;i++){
			if(max<a[i]){
				max=a[i];
			}
		}
		for(int j=0;j<a.length;j++){
			if(min>a[j]){
				min=a[j];
			}
		}
		for(int m=0;m<a.length;m++){

			sum += a[m];
		}
		
		return (double)(sum-max-min)/(a.length-2);
		
	}
	
	public static void swap(int arr[],int i,int j){
			int tmp=arr[i];
			arr[i]=arr[j];
			arr[j]=tmp;
	}
	
	public static void bubSort(int a[]){
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					int tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args){
		int[] a={4,6,2,8,3,10,1};
		int[] b={7,6,5,4,3,2,1};
		int[] c={1,2,3,4,5,6,7};
		int[] d={3,3,3,3,3,3,3};
		//bubSort(a);
		//bubSort(b);
		//bubSort(c);
		//bubSort(d);
		
		//System.out.println(average(a));
		//System.out.println(Arrays.toString(rotate(c,3)));
		System.out.println(Arrays.toString(partitional(c)));
		
	}
}