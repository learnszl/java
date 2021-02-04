import org.junit.Test;
import java.util.*;

/**
 * @Author szl
 * @Date 2021/2/2 21:12
 * @Description
 */
public class MapTest {
    @Test
    public void test1(){
        HashMap map = new HashMap();
        map.put("AA",2);
        map.put("BB",3);
        map.put("CC",4);
        map.put("AA",3);
        Set<Object> set = map.keySet();
        Iterator<Object> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        Collection<Object> values = map.values();
        iterator = values.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        Set entries = map.entrySet();
        Iterator iterator1 = entries.iterator();
        while(iterator1.hasNext()){
            Map.Entry entry = (Map.Entry)iterator1.next();
        }



    }
}

