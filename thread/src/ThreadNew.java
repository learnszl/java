import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author szl
 * @Date 2021/1/5 15:16
 * @Description 创建线程方式三：实现Callable接口 ---JDK5.0新增
 */
class NumThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask<Integer> task = new FutureTask<Integer>(numThread);
        new Thread(task).start();

        try {
            Integer sum = task.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
