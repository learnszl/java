import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author szl
 * @Date 2021/1/31 22:23
 * @Description
 */
public class SetTest {
    @Test
    public void test1(){
        HashSet set = new HashSet();
        set.add(123);
        set.add(123);
        set.add(24);
        set.add("123...");
        set.add(new Person("szl",22));
        set.add(new Person("szl",22));//添加对象时需要重写equals()和hashcode()
        set.add("123...");
        System.out.println(set.size());
        System.out.println("***********");

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test//练习题
    public void test2(){
        HashSet set = new HashSet();
        Person p1 = new Person("AA",2);
        Person p2 = new Person("BB",3);
//        set.add(null);
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);//2个
        set.add(new Person("CC",2));
        System.out.println(set);//3个
        set.add(new Person("AA",2));
        System.out.println(set);//四个


    }
    @Test
    public void test3(){

        Person u1 = new Person("李梦真",22);

        Person u2 = new Person("宋志立",22);

        System.out.println(u2.getName() + "超级喜欢" + u1.getName());

    }
}
