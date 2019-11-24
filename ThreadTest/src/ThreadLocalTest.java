import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>(){
        @Override
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };

    //创建初始时间
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    //结束时间-开始时间
    public static final long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(end());
    }
}
