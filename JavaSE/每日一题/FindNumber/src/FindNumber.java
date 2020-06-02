public class FindNumber {

    //找数组中单独的数字
    public static int getNumber(int[] arr,int len){
        for(int i = 0;i<len;i++){
            int value = arr[i];
            int count = 0;
            for(int j = 0;j<len;j++){
                if(arr[j] == value){
                    count++;
                }
            }
            if(count >= len/2){
                return value;
            }
            continue;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,2,2,2,5,4,2};
        int len = a.length;
        System.out.println(getNumber(a,len));
    }
}
