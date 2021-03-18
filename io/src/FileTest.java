import org.junit.Test;

import java.io.File;

/**
 * @Author szl
 * @Date 2021/3/18 14:48
 * @Description File类的使用
 */
public class FileTest {
    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");//仅仅是内存层面的对象，不要求硬盘中有实际的文件
        System.out.println(file1);


    }



}
