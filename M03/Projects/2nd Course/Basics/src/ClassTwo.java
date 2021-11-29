/**
 *
 * @author David
 */
public class ClassTwo {
    private String id;

    public ClassTwo(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassTwo{");
        sb.append("id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
