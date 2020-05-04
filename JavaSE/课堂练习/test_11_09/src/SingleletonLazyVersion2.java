
//线程安全的懒汉单例
public class SingleletonLazyVersion2 {

    private SingleletonLazyVersion2(){}

    private static SingleletonLazyVersion2 instance = null;

    //synchronized保证其原子性（其在释放锁时，把阻塞状态的对象全部释放，保证可见性）
    public synchronized static SingleletonLazyVersion2 getInstance(){
        if(instance == null){
            instance = new SingleletonLazyVersion2 ();
        }
        return instance;
    }



    public static void main(String[] args) {

    }

}
