import java.util.concurrent.locks.ReentrantLock;

public class Test {
    int k = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(new B());
        Thread thread2 = new Thread(new B());
        thread.start();
        thread2.start();
    }

    public void sout(){
        System.out.println(k++);
    }

}
class B implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        System.out.println(lock.hashCode());
        lock.unlock();
    }
}