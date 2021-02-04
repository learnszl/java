import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author szl
 * @Date 2021/1/4 16:40
 * @Description 解决线程安全问题三（1、同步代码块；2同步方法）：Lock锁 ---JDK5.0新增
 **/
public class LockTest {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        //Thread t3 = new Thread(w);

        t1.setName("线程一");
        t2.setName("线程二");
        //t3.setName("线程三");

        t1.start();
        t2.start();
        //t3.start();

    }

}

class Window1 implements Runnable {
    private int ticket = 100;
    //1、实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                //调用lock
                lock.lock();
                //synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else
                    break;

            } finally {
                //解锁
                lock.unlock();

            }

            //}
        }


    }
}
