/**
 * @Author szl
 * @Date 2020/12/13 18:56
 * @Description 卖票
 */
public class Ticket {
    public static void main(String[] args) {
        Window W = new Window();
        Thread w1 = new Thread(W);
        Thread w2 = new Thread(W);
        Thread w3 = new Thread(W);

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();




    }

}

class Window implements Runnable {
    private int ticket = 2000;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //也可以用同步方法，既可以用synchronized 修饰方法，但要注意包到位
                //synchronized (obj) { //obj为同步监视器，俗称”锁“，任何一个对象都可充当，要求多个线程必须公用同一把锁
                if (ticket > 0) {
//                    try {
//                        Thread.sleep(150);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                } else
                    break;
            }
        }

    }
}
