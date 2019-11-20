package 自己实现锁;

public class Seq {
    private MyLock lock = new MyLock();
    private int value;

    public int getNext() {
        lock.lock();
        value++;
        lock.unlock();
        return value;
    }

    /**
     * 不能显性创建线程,阿里巴巴代码规范
     * @param args
     */
    public static void main(String[] args) {
        Seq s = new Seq();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(s.getNext());
                }
            }
        }).start();
    }
}
