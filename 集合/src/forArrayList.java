import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class forArrayList {
    //ArrayList遍历方式
    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<Integer>();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        //普通for
        for (int i = 0; i < alist.size(); i++) {
            System.out.println(alist.get(i));
        }
        //foreach
        for (Integer list : alist) {
            System.out.println(list);
        }

        //遍历
        for (Iterator<Integer> list = alist.iterator(); list.hasNext();
        ) {
            System.out.println(list.next());
        }


    }
}
