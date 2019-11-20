package 自己实现锁;

public class LockDemo {
    MyLock lock = new MyLock();

    public void a(){
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }
    public void b(){
        lock.lock();
        System.out.println("b");

        lock.unlock();
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        new Thread(() -> {
        lockDemo.a();
        }).start();
    }
}
