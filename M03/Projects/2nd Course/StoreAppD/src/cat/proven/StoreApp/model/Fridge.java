package cat.proven.StoreApp.model;

public class Fridge extends Product {

    private int capacity;
    private boolean noFrost;

    public Fridge() {
        super();
    }

    public Fridge(String code) {
        super(code);
    }

    public Fridge(String code, String name, double price, int stock, int capacity, boolean noFrost) {
        super(code, name, price, stock);
        this.capacity = capacity;
        this.noFrost = noFrost;
    }

    public Fridge(Fridge other, int capacity, boolean noFrost) {
        super(other);
        this.capacity = other.capacity;
        this.noFrost = other.noFrost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isNoFrost() {
        return noFrost;
    }

    public void setNoFrost(boolean noFrost) {
        this.noFrost = noFrost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" / Capacity --> ").append(capacity);
        sb.append(" / noFrost --> ").append(noFrost);
        return sb.toString();
    }
}
