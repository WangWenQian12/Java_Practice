public class OneTwoThree{
    private static class Foo {

        private volatile int n = 0;

        public void one() {
            if(n != 0){
                return;
            }

            //volatile保证下面的俩句代码不重排序
            System.out.println("one");
            n = 1;
        }

        public void two() {
            if(n != 1){
                return;
            }
            System.out.println("two");
            n = 1;
        }

        public void three() {
            if(n != 2){
                return;
            }
            System.out.println("three");
            n = 0;
        }
    }

    private static Foo foo = new Foo();

    private static class OneThread extends Thread {
        @Override
        public void run() {
            while (true) {
                foo.one();
            }
        }
    }

    private static class TwoThread extends Thread {
        @Override
        public void run() {
            while (true) {
                foo.two();
            }
        }
    }

    private static class ThreeThread extends Thread {
        @Override
        public void run() {
            while (true) {
                foo.three();
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
