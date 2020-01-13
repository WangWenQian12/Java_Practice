public class Main {

    //判断一个数字（二进制形式）中连续的1的个数

    public static int calcOne(int num){
        int maxCount = 0;
        int count = 0;
        while(num > 0){
            if(num % 2 == 1){
                count++;
            }else{
                count = 0;
            }
            if(count > maxCount){
                maxCount = count;
            }
            num >>= 1;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println (calcOne(7896));
    }
}
