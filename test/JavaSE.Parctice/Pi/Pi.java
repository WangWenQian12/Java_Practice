public class Pi{
	public static double calcPi(int n){
		double pi4=0;
		for(int i=0;i<n;i++){
			int m=(2*i)+1;
			if(i%2==0){
				pi4+=(1.0/m);
			}
			else{
				pi4-=(1.0/m);
			}
		}
		return 4*pi4;
	}
	
	public static void main(String[] args){
		System.out.printf("pi=%f%n",calcPi(100000));
		
		/*double sum=1.0;
		double m=1.0;
		int count=0;
		while(Math.abs(sum-Math.E)>Math.pow(10,-4)){
			sum += Math.pow(-1,count)*(1/m);
			m+=2;
			count++;
		}
		System.out.println(4*sum);*/
	}
}