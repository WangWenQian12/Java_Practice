public class createThreadPractice {

    //创建三个线程，分别计算
    //1+2+3+4+ ... + 1000000的和
    //1+3+5+7+6+ ... + 1000001的和
    //1^2 + 2^2 + 3^2+ …… +100000^2的和
    //对比单线程情况下的速度


    public static class calcThread1 extends Thread{
        private int count = 1000000;

        @Override
        public void run() {
            long sum = 0;
            for(int i = 1;i <= count;i++){
                sum += i;
            }
            System.out.println ("p1:"+sum);
        }
    }

    public static class calcThread2 extends Thread{
        private int count = 1000001;

        @Override
        public void run() {
            long sum = 0;
            for(int i = 1;i <= count;i+=2){
                sum += i;
            }
            System.out.println ("p2:"+sum);
        }
    }

    public static class calcThread3 extends Thread{
        private int count = 100000;

        @Override
        public void run() {
            long sum = 0;
            for(int i = 1;i <= count;i++){
                sum += i*i;
            }
            System.out.println ("p3:"+sum);
        }
    }

    public static void main(String[] args) {
        new calcThread1 ().start();
        new calcThread2 ().start();
        new calcThread3 ().start();

    }
}
