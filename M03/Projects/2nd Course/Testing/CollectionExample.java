
import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        //Collection<Integer> data = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        //List<Integer> data = new LinkedList<>();

        /* Collection examples */
        
        //populate data.
        data.add(Integer.valueOf(23));
        data.add(Integer.valueOf(12));
        data.add(Integer.valueOf(10));
        data.add(Integer.valueOf(45));

        System.out.println("Number of elements (size()): " + data.size());

        System.out.println("Iterate with for-each loop");
        for (Integer elem : data) {
            System.out.println(elem.toString());
        }

        System.out.println("Iterate with iterator");
        Iterator<Integer> iter = data.iterator();
        while (iter.hasNext()) {
            Integer elem = iter.next();
            System.out.println(elem.toString());
        }

        System.out.println("Use of contains()");
        System.out.println("Collection contains 23: " + data.contains(23));
        System.out.println("Collection contains 99: " + data.contains(99));

        System.out.println("Use of isEmpty()");
        System.out.println("Is empty?:" + data.isEmpty());

        System.out.println("Remove element 23");
        data.remove(Integer.valueOf(23));
        for (Integer elem : data) {
            System.out.println(elem.toString());
        }

        /* List examples */
        
        System.out.println("Iterate with listiterator");
        ListIterator<Integer> iter2 = data.listIterator();
        while (iter2.hasNext()) {
            Integer elem = iter2.next();
            System.out.println("Next elem: " + elem.toString());

        }

        System.out.println("Add an element at index 1");
        data.add(1, new Integer(55));
        printList(data);

        System.out.println("Add an element at the top of the list");
        data.add(Integer.valueOf(77));
        printList(data);

        System.out.println("Modify element at index 2");
        data.set(2, Integer.valueOf(44));
        printList(data);

        System.out.println("Iterate with a counter and use method get");
        for (int i = 0; i < data.size(); i++) {
            Integer elem = data.get(i);
            System.out.println(elem.toString());
        }

        System.out.println("Use of toString()");
        System.out.println(data.toString());

        System.out.println("Use of indexOf()");
        int p = data.indexOf(44);
        System.out.println("Index of elem 44= " + p);
    }

    private static void printList(List<Integer> l) {
        //use of functional operation.
        l.forEach((elem) -> {
            System.out.println(elem.toString());
        });
    }

}
