package cat.proven.model;

public class Room {
    private int number;
    private int capacity;
    private double price;
    private String category;
    private boolean occupied;

    public Room() {
    }

    public Room(int number) {
        this.number = number;
    }

    public Room(int number, int capacity, double price, String category, boolean occupied) {
        this.number = number;
        this.capacity = capacity;
        this.price = price;
        this.category = category;
        this.occupied = occupied;
    }

    public Room(Room other) {
        this.number = other.number;
        this.capacity = other.capacity;
        this.price = other.price;
        this.category = other.category;
        this.occupied = other.occupied;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room Number --> ");
        sb.append(number);
        sb.append("\nCapacity --> ").append(capacity);
        sb.append("\nPrice --> ").append(price);
        sb.append("\nCategory -->").append(category);
        sb.append("\nOccupied --> ").append(occupied);
        return sb.toString();
    }
}
