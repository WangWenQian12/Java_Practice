import java.util.Scanner;
import java.lang.String;


public class DeleteString {


    public static void DeleteString(char[] arr1,char[] arr2){
        int count=0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){

                if(arr1[i] == arr2[j]){
                    count++;
                    for(int m = i;m<arr1.length-1;m++){
                        arr1[m] = arr1[m+1];
                    }
                }
            }
        }
        for(int i=0;i<arr1.length-count;i++){
            System.out.print(arr1[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please inter the first string:");
        String string1 = input.nextLine();
        char[] arr1 = new char[string1.length()];
        for(int i=0;i<string1.length();i++){
            arr1[i] = string1.charAt(i);
        }
        System.out.println("Please inter the second string:");
        String string2 = input.nextLine();
        char[] arr2 = new char[string2.length()];
        for(int i=0;i<string2.length();i++){
            arr2[i] = string2.charAt(i);
        }


        //String[] arr1 = new String[]{"T","h","e","y"," ","a","r","e"," ","s","t","u","d","e","n","t","s","."};
        //String[] arr2 = new String[]{"a","e","i","o","u"};
        //System.out.println(arr1.length);
        //System.out.println(arr2.length);

        DeleteString(arr1,arr2);

    }
}
