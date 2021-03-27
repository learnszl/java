import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author szl
 * @Date 2021/3/18 16:57
 * @Description
 */
public class FileReaderWriterTEst {
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
//        int data = fr.read();
//        while(data != -1){
//            System.out.println((char)data);
//            data = fr.read();
//        }
            int data;
            while ((data = fr.read()) != -1)
                System.out.println((char) data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            char[] cbuf = new char[3];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
