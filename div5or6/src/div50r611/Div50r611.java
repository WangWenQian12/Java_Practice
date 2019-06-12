
package div50r611;

import java.util.Scanner;

public class Div50r611 {
    public static void main(String[] args) {
        int count=0;
        for(int number=100;number<=200;number++){
        if((number%5==0 || number%6==0)&&(number%5==0 ^ number%6==0)){
            count++;                
            if(count%10==0){
               System.out.println();
                }
            else{
               System.out.print(number+" ");                
            }
        }
    }
}
}
