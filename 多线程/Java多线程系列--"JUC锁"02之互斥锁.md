@[TOC]

# ReentrantLock介绍
ReentrantLock是一个可重入的锁,又被成为"独占锁"

顾名思义，ReentrantLock锁在同一个时间点只能被一个线程锁持有；而可重入的意思是，ReentrantLock锁，可以被单个线程多次获取。
ReentrantLock分为“**公平锁**”和“**非公平锁**”。它们的区别体现在获取锁的机制上是否公平。“锁”是为了保护竞争资源，防止多个线程同时操作线程而出错，ReentrantLock在同一个时间点只能被一个线程获取(当某线程获取到“锁”时，其它线程就必须等待)；ReentraantLock是通过一个FIFO的等待队列来管理获取该锁所有线程的。在“公平锁”的机制下，线程依次排队获取锁；而“非公平锁”在锁是可获取状态时，不管自己是不是在队列的开头都会获取锁。

# ReentrantLock函数列表
```java
// 创建一个 ReentrantLock ，默认是“非公平锁”。
ReentrantLock()
// 创建策略是fair的 ReentrantLock。fair为true表示是公平锁，fair为false表示是非公平锁。
ReentrantLock(boolean fair)

// 查询当前线程保持此锁的次数。
int getHoldCount()
// 返回目前拥有此锁的线程，如果此锁不被任何线程拥有，则返回 null。
protected Thread getOwner()
// 返回一个 collection，它包含可能正等待获取此锁的线程。
protected Collection<Thread> getQueuedThreads()
// 返回正等待获取此锁的线程估计数。
int getQueueLength()
// 返回一个 collection，它包含可能正在等待与此锁相关给定条件的那些线程。
protected Collection<Thread> getWaitingThreads(Condition condition)
// 返回等待与此锁相关的给定条件的线程估计数。
int getWaitQueueLength(Condition condition)
// 查询给定线程是否正在等待获取此锁。
boolean hasQueuedThread(Thread thread)
// 查询是否有些线程正在等待获取此锁。
boolean hasQueuedThreads()
// 查询是否有些线程正在等待与此锁有关的给定条件。
boolean hasWaiters(Condition condition)
// 如果是“公平锁”返回true，否则返回false。
boolean isFair()
// 查询当前线程是否保持此锁。
boolean isHeldByCurrentThread()
// 查询此锁是否由任意线程保持。
boolean isLocked()
// 获取锁。
void lock()
// 如果当前线程未被中断，则获取锁。
void lockInterruptibly()
// 返回用来与此 Lock 实例一起使用的 Condition 实例。
Condition newCondition()
// 仅在调用时锁未被另一个线程保持的情况下，才获取该锁。
boolean tryLock()
// 如果锁在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁。
boolean tryLock(long timeout, TimeUnit unit)
// 试图释放此锁。
void unlock()


```

# ReentrantLock示例
```java
public class Depot{
    private int size;
    private Lock lock;  //独占锁
    
    public Depot(){
        this.size=0;
        this.lock=new ReentrantLock();
        }
    //生产者
    public void produce(int val){
        lock.lock();
        try{
        size += val;
          System.out.printf("%s produce(%d) --> size=%d\n", 
                    Thread.currentThread().getName(), val, size);
        }finally{
            lock.unlock();
        }
    
    }
    public void consume(int val){
        lock.lock();
        try{
            size-=val;
             System.out.printf("%s consume(%d) <-- size=%d\n", 
                        Thread.currentThread().getName(), val, size);
        }finally{
            
        }
    
    }
  
}
//生产者
public class Producer{
    private Depot depot;
    
    public Producer(Depot depot){
        this.depot=depot;
    }
    
    //消费产品:新建一个线程向仓库中生产产品
    public void produce(final int val){
        new Thread(){
            public void run(){
                depot.produce(val);
            }       
        }.start();   
    }


}

//消费者
public class Customer{
    private Depot depot;
    
    public Customer(Depot depot){
        this.depot=depot;
    }   
    //消费产品:新建一个县城从仓库中消费
    public void consume(final int val){
        new Thread(){
            public void run(){
                depot.consume(val);
            }   
        }.start();
    }


}
acquire
public class TestLock{
    public static void main(String[] args){
      Depot mDepot = new Depot();
        Producer  mPro = new Producer(mDepot);
        Producer  mCus = new Customer(mDepot);
        Pro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}
```