/**
 * @Author szl
 * @Date 2020/12/3 22:03
 * @Description 测试线程
 */
public class ThreadTest {
    public static void main(String[] args) {
        myThread mt = new myThread();
        mt.start();
        for (int i = 0; i < 1000; i++) {
            if(i % 2 != 0) {
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + i + "-------");
            }

        }
    }

}

class myThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
