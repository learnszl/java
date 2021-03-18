import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author szl
 * @Date 2021/3/18 14:48
 * @Description File类的使用
 */
public class FileTest {
    @Test
    public void test1() throws IOException {
        //构造器1
        File file1 = new File("hello.txt");//仅仅是内存层面的对象，不要求硬盘中有实际的文件
        System.out.println(file1);
        if (!file1.exists()) {
            boolean newFile = file1.createNewFile();
            System.out.println(newFile);
        }
    }
}
