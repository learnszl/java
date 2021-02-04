import org.junit.Test;

/**
 * @Author szl
 * @Date 2021/1/6 14:50
 * @Description String是不可变的字符序列
 */
public class StringTest {
    @Test
    public void test1(){
        String s1 = "abc";  //字面量定义方式，string是类，但却不用new可以直接赋值（唯一一个）
        String s2 = "abc";
        System.out.println(s1 == s2);//true
        //s1 = "szl";
        System.out.println(s1);
        System.out.println(s2);
    }
    @Test
    public void test2(){
        //通过字面量定义的方式，此时s1,s2的数据szl声明在方法区中的字符常量池中
        String s1 = "szl";
        String s2 = "szl";
        //通过new + 构造器方式


        String s3 = new String("szl");
        String s4 = new String("szl");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//false
    }




}
