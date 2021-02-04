import org.junit.Test;

import java.time.LocalDate;

/**
 * @Author szl
 * @Date 2021/1/10 22:39
 * @Description
 */
public class DateTest {
    @Test
    public void test(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

    }
}
