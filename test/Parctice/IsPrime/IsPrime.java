import java.util.Scanner;

public class IsPrime{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a numner:");
		int num = input.nextInt();
		for(int i=2;i<num/2;i++){
			if(num%i==0){
				System.out.println(num+" is not a prime.");
				break;
			}
			else{
				System.out.println(num+" is a prime.");
			}
		}
	}
}