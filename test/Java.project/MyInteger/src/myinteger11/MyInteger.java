/*• 如果该对象的值与指定的值相等，那么equals(int)和 equals(Mylnteger)方法返回 true0 
• 静态方法 parselntCcharl： ])将数宇字符构成的数组转换为一个int 值。 
• 静态方法 parselnt(String)将一个字符串转换为一个int 值。 画出该类的UML图并实现这个类。 */
package myinteger11;

public class MyInteger {
    private int value;
    
    public MyInteger(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    public boolean isEven(){
        return isEven(value);
    }
    public boolean isOdd(){
        return isOdd(value);
    }
    public boolean isPrime(){
        return isPrime(value);
    }
    
    public static boolean isEven(int value){
        return value%2==0;
    }
    public static boolean isOdd(int value){
        return value%2!=0;
    }
    public static boolean isPrime(int value){
        for(int i=2;i<value/2;i++){
            if(value/i==0)
                return false;
        }
        return true;
    }
    
    public static boolean isEven(MyInteger myInteger){
        return myInteger.isEven();
    }
    public static boolean isOdd(MyInteger myInteger){
        return myInteger.isOdd();
    }
    public static boolean isPrime(MyInteger myInteger){
        return myInteger.isPrime();
    }

    public boolean equals(int value){
        return this.value==value;
    }
    public boolean equals(MyInteger myInteger){
        return myInteger.value==value;
    }
    
    public static int parseInt(char[] chars){
        int value=0;
        for(int i=0,j=(int)Math.pow(10,chars.length-1);i<chars.length;i++,j/=10){
        value += (chars[i]-48)*j;
        }
        return value;
    }
    /*public static int parseInt(String[] str){
        int value=0;
        for(int i=0,j=(int)Math.pow(10,str.length-1);i<str.length;i++,j/=10){
        value += (str.charAt(i)-48)*j;
        }
        return value;
    }*/
    
    public static void main(String[] args) {
        int[] value={5,6,7,8,9};
        
    }
    
}
