import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsePool {

    //线程的创建和释放都由线程池管理，我们只需要给它分配任务就好了

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool (1);//池中最多的线程数为1，只有第一个线程再执行
        pool.execute (new Runnable () {
            @Override
            public void run() {
                while(true){
                    System.out.println ("我是第一个线程");
                }
            }
        });
        pool.execute (new Runnable () {
            @Override
            public void run() {
                while(true){
                    System.out.println ("我是第二个线程");
                }
            }
        });

    }
}
