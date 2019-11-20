import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author awin
 */
public class Sequence {
    private int value;

    public int getNext(){
        /**
         * ReentrantLock 重入锁
         */
        Lock lock  = new ReentrantLock();
        lock.lock();
        int i = value++;
        lock.unlock();
        return i;
    }
    synchronized void xxx() throws InterruptedException {
        wait();
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+" "+s.getNext());
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
