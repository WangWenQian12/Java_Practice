
package grade11;

import java.util.Scanner;

public class Grade11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the grade:");
        int[] grade=new int[10];
        int i=0;
        for(i=0;i<grade.length;i++){
           grade[i]=input.nextInt();
        }

        int best=grade[0];
        for(i=0;i<grade.length;i++){
           if(grade[i]>best){
               best=grade[i];
           }
        }
        for(i=0;i<grade.length;i++){
            if(grade[i]>=best-10){
                System.out.println(grade[i]+" A ");
            }
            else if(grade[i]>best-20){
                System.out.println(grade[i]+" B ");
            }
            else if(grade[i]>best-30){
                System.out.println(grade[i]+" C ");
            }
            else if(grade[i]>best-40){
                System.out.println(grade[i]+" D ");
            }
            else{
                System.out.println(grade[i]+" E ");         
            }
        }
    }
    
}
