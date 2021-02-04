import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author szl
 * @Date 2021/1/5 15:51
 * @Description 线程创建4：线程池
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new RunnableThread1());
    }
}
class RunnableThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" +i);

        }
    }
}