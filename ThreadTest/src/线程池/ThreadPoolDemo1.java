package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Thread t1 = new MyThread();
        Thread t2 = new  MyThread();
        Thread t3 = new  MyThread();
        Thread t4 = new  MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);

        //关闭线程池
        pool.shutdown();

    }

}
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"is running");
    }
}



