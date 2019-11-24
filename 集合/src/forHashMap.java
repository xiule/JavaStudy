import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class forHashMap {
    public static void main(String[] args) {
        //第一种遍历方式
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "刘备");
        map.put(2, "张飞");
        map.put(3, "关羽");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();

            Object key = entry.getKey();
            Object value = entry.getValue();

            System.out.println(key + "|" + value);
        }


        //foreach遍历1
        for (Object key : map.keySet()
        ) {
            Object o = map.get(key);
            String s = o.toString();

            System.out.println(key + "=" + s);
        }

        //遍历2
        // Map<String, String> map = new HashMap<String, String>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"|"+value);
        }


    }
}
