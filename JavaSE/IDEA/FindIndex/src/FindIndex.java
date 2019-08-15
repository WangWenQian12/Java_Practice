import java.util.Scanner;

public class FindIndex {

    public static void getIndex(int arr[],int len,int k){
        int left = 0;
        int right = len-1;
        while(arr[left]<arr[right]){
            if(arr[left]+arr[right]<k){
                left++;
            }
            else if(arr[left]+arr[right]>k){
                right--;
            }
            else{
                System.out.println("和为"+k+"的下标为"+left+"和"+right);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

        System.out.println("Please inter the number of array:");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Please inter the array:");
        for(int i =0;i<n;i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Please inter the sum:");
        int k = input.nextInt();

        getIndex(arr,n,k);

    }
}
