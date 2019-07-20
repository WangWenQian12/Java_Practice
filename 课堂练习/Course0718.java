import java.util.Arrays;//Arrays.fill(a,2)


public class Course0718{
	/*public static void swap(int[] a,int i,int j){
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}	*/
	
	/*public static int indexOf(int[] a,int v){
		for(int i=0;i<a.length;i++){
			if(a[i]==v){
				println(i);
			}
		}
		else{
				return -1;
		}
	}*/
	
	//public static void fill
	
	public static int[] copyOf(int[] original,int newLength){
		int[] dest = new int[newLength];
		int length = original.length<=newLength?original.length:newLength;
		for(int i=0;i<length;i++){
			dest[i]=original[i];
		}
		return dest;
		//int[] dest = new int[newLength];
		/*if(length>newLength){
			for(int i=0;i<newLength;i++){
				dest[i]=original[i];
				return dest;
			}
		}
		else{
			return dest;
		}*/
	}
	
	
	//二分查找
	public static int binarySearch(int[] a,int v){
		int left=0;
		int right=a.length;   //[left,right)
		while(left<right){
			int mid=(left+right)/2;
			if(a[mid]>v){
				left=mid+1;
				mid=(left+right)/2;
			}
			else if(a[mid]<v){
				right=mid;
				mid=(left+right)/2;
			}
			else{
				return mid;
			}			
		}
		return -1;		
	}
	
	
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5};
		//swap(a,0,3);
		//indexOf(a,3);
		copyOf(a,3);
		
		System.out.printf(Arrays.toString(a));
		
		/*for(int i=0;i<dest.length;i++){
			System.out.printf("%d ",dest[i]);
		}*/
	}
}