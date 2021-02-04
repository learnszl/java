import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @Author szl
 * @Date 2021/1/28 22:02
 * @Description
 */
public class ListTest {
    @Test
    public void test1() {
        Collection<Object> coll = new ArrayList<>();
        coll.add("123");
        coll.add(123);
        coll.add("szl");
        coll.add(new Person("lmz",22));
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add(456);
        coll1.add("456");
        coll.addAll(coll1);
        System.out.println(coll.isEmpty());
        System.out.println(coll);
        System.out.println(coll.size());
        System.out.println(coll.contains(new Person("lmz",22)));

    }
    @Test
    public void test2(){
        Collection<Object> coll = new ArrayList<>();
        coll.add("123");
        coll.add(123);
        coll.add("szl");
        coll.add(new Person("lmz",22));
        Iterator<Object> iterator = coll.iterator();
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }
        iterator = coll.iterator();
        //推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }

    @Test
    public void test3(){
        ArrayList<Object> coll = new ArrayList<>();
        coll.add(0);
        coll.add("123");
        coll.add(123);
        coll.add("szl");
        coll.add(new Person("lmz",22));
        coll.remove(Integer.valueOf(0));
        System.out.println(coll);

    }
}
