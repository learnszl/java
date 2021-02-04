/**
 * @Author szl
 * @Date 2021/1/5 14:41
 * @Description 线程通信 交替打印1-100
 * wait()、notify()、notifyAll()方法必须包含在同步代码块或者是同步方法中
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
//        Thread t3 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");
//        t3.setName("线程三");

        t1.start();
        t2.start();
//        t3.start();


    }
}

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
