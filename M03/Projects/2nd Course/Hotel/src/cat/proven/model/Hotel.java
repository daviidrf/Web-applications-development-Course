package cat.proven.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {

    private final Map<Room, List<Customer>> hotel;

    public Hotel() {
        hotel = new HashMap<>();
    }

    /**
     * Retrieve all the rooms in the hotel.
     *
     * @return a list with all the rooms or an empty list.
     */
    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            rooms.add(entry.getKey());
        }
        return rooms;
    }

    /**
     * Retrieve all the customers in the hotel.
     *
     * @return a list with all the customers or an empty list.
     */
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                customers.add(entry.getValue().get(i));
            }
        }
        return customers;
    }

    /**
     * Retrieve all the customers in the room given.
     *
     * @param room to search the customers in.
     * @return a list with th customers in the room given or an empty list.
     */
    public List<Customer> getCustomersByRoom(Room room) {
        List<Customer> customers = new ArrayList<>();
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            if (entry.getKey().equals(room)) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    customers.add(entry.getValue().get(i));
                }
            }
        }
        return customers;
    }

    /**
     * Add a room to the room's list.
     *
     * @param room to add to the hotel.
     * @return 1 if the room is successfully added or -1 otherwise.
     */
    public int addRoom(Room room) {
        List<Customer> emptyRoom = new ArrayList<>();
        if (!hotel.containsKey(room)) {
            hotel.put(room, emptyRoom);
            return 1;
        }
        return -1;
    }

    /**
     * Remove a room from the room's list.
     *
     * @param room to remove from the hotel.
     * @return 1 if the room is successfully removed or -1 otherwise.
     */
    public int removeRoom(Room room) {
        if (hotel.containsKey(room)) {
            hotel.remove(room);
            return 1;
        }
        return -1;
    }

    /**
     * Modify a room from the room's list.
     *
     * @param newRoom is the new room.
     * @param oldRoom is the old room.
     * @return 1 if the room is successfully modified or -1 otherwise.
     */
    public int modifyRoom(Room newRoom, Room oldRoom) {
        int result = -1;
        if (hotel.containsKey(oldRoom)) {
            List<Customer> oldCustomers = getCustomersByRoom(oldRoom);
            hotel.put(newRoom, oldCustomers);
            int updated = removeRoom(oldRoom);
            if (hotel.containsKey(newRoom) && updated == 1) {
                result = 1;
            }
        }
        return result;
    }

    /**
     * Retrieve the list of occupied rooms in the hotel.
     *
     * @return a list with the occupied rooms or an empty list.
     */
    public List<Room> getOccupiedRooms() {
        List<Room> rooms = new ArrayList<>();
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            if (entry.getKey().isOccupied()) {
                rooms.add(entry.getKey());
            }
        }
        return rooms;
    }

    /**
     * Check in a list of clients in the room given.
     *
     * @param room      to check in the customers.
     * @param customers to check in.
     * @return 1 if the customers are successfully check in the room or -1 otherwise.
     */
    public int checkInCustomers(Room room, List<Customer> customers) {
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            if (entry.getKey().equals(room) && !entry.getKey().isOccupied()) {
                if(changeRoomOccupancy(entry.getKey()) == 1) {
                    entry.setValue(customers);
                    return 1;
                }
            }
        }

        return -1;
    }

    /**
     * Check out the customers from the room given.
     *
     * @param room to check out the customers.
     * @return 1 if the customers are successfully removed from the room or -1 otherwise.
     */
    public int checkOutCustomers(Room room) {
        List<Customer> customers = new ArrayList<>();

        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            if (entry.getKey().equals(room)) {
                if(changeRoomOccupancy(entry.getKey()) == 1) {
                    entry.setValue(customers);
                    return 1;
                }
            }
        }
        return -1;
    }

    /**
     * Retrieve the list of rooms with the category and capacity given.
     *
     * @param category of the rooms to return.
     * @param capacity of the rooms to return.
     * @return a list with the filtered rooms or an empty list.
     */
    public List<Room> getRoomsByCategoryCapacity(String category, int capacity) {
        List<Room> rooms = new ArrayList<>();
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            if (entry.getKey().getCategory().equalsIgnoreCase(category)
                    && entry.getKey().getCapacity() >= capacity
                    && !entry.getKey().isOccupied()) {
                rooms.add(entry.getKey());
            }
        }
        return rooms;
    }

    /**
     * Retrieve the room with the number given.
     *
     * @param number of the room to return.
     * @return a room with the number given or null otherwise.
     */
    public Room getRoomByNumber(int number) {
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            if (entry.getKey().getNumber() == number) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Changes the room occupancy.
     *
     * @param room to change it occupancy.
     * @return 1 if the occupancy is changed or -1 otherwise.
     */
    private int changeRoomOccupancy(Room room) {
        if(room.isOccupied()) {
            room.setOccupied(false);
            return 1;
        } else if(!room.isOccupied()){
            room.setOccupied(true);
            return 1;
        }
        return -1;
    }

    /**
     * Add test data to the hotel.
     */
    public void generateData() {
        List<Customer> emptyRoom = new ArrayList<>();
        List<Customer> room1 = new ArrayList<>();
        room1.add(new Customer("David", "46480325Q"));
        room1.add(new Customer("Jordi", "45636534R"));
        List<Customer> room2 = new ArrayList<>();
        room2.add(new Customer("Roger", "43124542E"));

        Room r1 = new Room(1, 3, 50, "STANDARD");
        r1.setOccupied(true);
        Room r2 = new Room(3, 1, 40, "SUITE");
        r2.setOccupied(true);

        hotel.put(r1, room1);
        hotel.put(new Room(2, 4, 30, "SUPERIOR"), emptyRoom);
        hotel.put(r2, room2);
        hotel.put(new Room(4, 2, 100, "STANDARD"), emptyRoom);
    }
}
