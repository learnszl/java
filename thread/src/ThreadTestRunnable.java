/**
 * @Author szl
 * @Date 2020/12/5 21:45
 * @Description
 */
class RunnableThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" +i);

        }
    }
}

public class ThreadTestRunnable {
    public static void main(String[] args) {
        RunnableThread thread = new RunnableThread();
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);

        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");

        t1.start();
        t2.start();
        t3.start();

    }



}
