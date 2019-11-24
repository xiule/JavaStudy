import java.util.LinkedList;

public class forLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<Integer>();
        for (int i = 0; i <= 10; i++) {
            llist.addLast(i);
        }
        byCommonFor(llist);
        byForEach(llist);
    }

        private static void byCommonFor(LinkedList<Integer> list){
        int size =list.size();
        for (int i = 0; i < size; i++) {
            Integer i1 = list.get(i);
            System.out.println(i1);
        }
    }

    private static void byForEach(LinkedList<Integer> list){
        for (Integer list1:list
             ) {
            System.out.println(list1);
        }
    }
}
