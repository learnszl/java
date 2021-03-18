import org.junit.Test;

import javax.xml.transform.Source;
import java.util.*;

/**
 * @Author szl
 * @Date 2021/2/2 21:12
 * @Description
 */
public class MapTest {
    @Test
    public void test1(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("AA",2);
        map.put("BB",3);
        map.put("CC",4);
        map.put("AA",3);
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator2 = values.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        System.out.println();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator1 = entries.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String,Integer> entry = iterator1.next();
            System.out.println(entry);
        }



    }
}

