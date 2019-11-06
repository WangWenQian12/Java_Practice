import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ThreadState {

    //状态枚举

    private static class MyThread extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace ();
            }
        }
    }

    //线程状态
    public static void main(String[] args) {
        for(Thread.State state : Thread.State.values ()){
            System.out.println (state);
        }

        System.out.println ();
        Thread thread = new MyThread();
        System.out.println (thread.getState ());
        System.out.println ("========================");
        thread.start ();
        while(thread.isAlive ()){
            System.out.println (thread.getState ());
        }
        System.out.println ("========================");
        System.out.println (thread.getState ());
    }

}
