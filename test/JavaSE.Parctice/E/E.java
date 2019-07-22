public class E{
	public static long fact(int n){
		if(n==0||n==1){
			return 1;
		}
		else{
			return n*fact(n-1);
		}
	}
	
	//public static int 
	
	public static double calcE(int n){
		double e=0;
		for(int i=0;i<n;i++){
			e += (1.0/fact(i));
		}			
		return e;
	}
	
	public static void main(String[] args){
		
		System.out.printf("e = %f%n",calcE(10));
		
		
		/*double e=1.0;
		double m=1.0;
		int n=1;
		int count=0;
		while(Math.abs(e-Math.E)>Math.pow(10,-5)){
			m*=n;
			n++;
			e+=1/m;
			count++;
		}
		System.out.println(e+"  "+(count+1));*/
	}
}