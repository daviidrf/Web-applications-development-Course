package cat.proven.model;

import java.util.Objects;

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

    public Room(int number, int capacity, double price, String category) {
        this.number = number;
        this.capacity = capacity;
        this.price = price;
        this.category = category;
        this.occupied = false;
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
        final StringBuilder sb = new StringBuilder("\nRoom Number --> ");
        sb.append(number);
        sb.append("\nCapacity --> ").append(capacity);
        sb.append("\nPrice --> ").append(price);
        sb.append("\nCategory -->").append(category);
        sb.append("\nOccupied --> ").append(occupied);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
