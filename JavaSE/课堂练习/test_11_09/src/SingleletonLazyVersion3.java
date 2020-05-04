public class SingleletonLazyVersion3 {

    private SingleletonLazyVersion3(){}

    //volatile是在第二次的判断instance是否为空对其初始化时保证其代码的重排序的
    private volatile static SingleletonLazyVersion3 instance = null;

    //synchronized保证其原子性（其在释放锁时，把阻塞状态的对象全部释放，保证可见性）
    public synchronized static SingleletonLazyVersion3 getInstance(){
        if(instance == null){
            synchronized (SingleletonLazyVersion3.class){
                if (instance == null) {
                    instance = new SingleletonLazyVersion3 ();
                }
            }
        }
        return instance;
    }
}
