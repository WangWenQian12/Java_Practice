public class OneTwoThree2 {
    private static class Foo {

        private volatile int n = 0;

        public void one() throws InterruptedException {
            if (n != 0) {
                //当前进程进入等待集，并释放锁，其他进程竞争CPU争夺锁
                synchronized (this) {
                    wait ();
                }
                return;
            }
            System.out.println ("one");
            n = 1;
            //将等待集中的所有进程唤醒
            synchronized (this) {
                notifyAll ();
            }

        }

        public void two() throws InterruptedException {
            if (n != 1) {
                synchronized (this) {
                    wait ();
                }
                return;
            }
            System.out.println ("two");
            n = 1;
            synchronized (this) {
                notifyAll ();
            }

        }

        public void three() throws InterruptedException {
            if (n != 2) {
                synchronized (this) {
                    wait ();
                }
                return;
            }
            System.out.println ("three");
            n = 0;
            synchronized (this) {
                notifyAll ();
            }

        }
    }

    private static Foo foo = new Foo();

    private static class OneThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try{
                    foo.one ();;
                }catch (InterruptedException e){
                    e.printStackTrace ();
                }

            }
        }
    }

    private static class TwoThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try{
                    foo.two ();;
                }catch (InterruptedException e){
                    e.printStackTrace ();
                }

            }
        }
    }

    private static class ThreeThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try{
                    foo.three ();;
                }catch (InterruptedException e){
                    e.printStackTrace ();
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread one = new OneThread();
        Thread two = new TwoThread();
        Thread three = new ThreeThread();
        one.start();
        two.start();
        three.start();
    }
}


