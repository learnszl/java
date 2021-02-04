import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/1/24 19:04
 * @Description java比较器
 */
public class CompareTest {
    @Test
    public void test1(){
        String[] arr = new String[]{"aa","cc","zz","bb"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    @Test
    public void test2(){
        Computer[] com = new Computer[4];
        com[0] = new Computer("dell",5900,100);
        com[1] = new Computer("huawei",5699,120);
        com[2] = new Computer("apple",5900,110);
        com[3] = new Computer("xiaomi",5800,82);
        Arrays.sort(com);
        System.out.println(Arrays.toString(com));
        System.out.println("*****************");
        System.out.println(com[0].toString());
    }
}
