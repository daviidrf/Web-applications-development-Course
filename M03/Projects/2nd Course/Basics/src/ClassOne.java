import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class ClassOne {

    private List<ClassTwo> Class2List;

    public ClassOne() {
        Class2List = new ArrayList<>();
        generateData();
    }

    public void write (String text){
        System.out.println(text);
    }

    public void generateData() {
        Class2List.add(new ClassTwo("c2-1"));
        Class2List.add(new ClassTwo("c2-2"));
        Class2List.add(new ClassTwo("c2-3"));

    }

    public void displayData() {
        for (ClassTwo classTwo : Class2List) {
            System.out.println(classTwo);
        }
    }

    public void displaySecondElement() {
        System.out.println(Class2List.get(1).toString());
    }
    
}
