package cat.proven.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {

    private Map<Room, List<Customer>> hotel;

    public Hotel() {
        hotel = new HashMap<>();
    }

    /**
     * Retrieve all the rooms in the hotel.
     * @return a list with all the rooms or an empty list.
     */
    public List<Room> getRooms(){
        List<Room> rooms = new ArrayList<>();
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            rooms.add(entry.getKey());
        }
        return rooms;
    }

    /**
     * Retrieve all the customers in the hotel.
     * @return a list with all the customers or an empty list.
     */
    public List<Customer> getCustomers(){
        return null;
    }

    /**
     * Retrieve all the customers in the room given.
     * @param room to search the customers in.
     * @return a list with th customers in the room given or an empty list.
     */
    public List<Customer> getCustomersByRoom(Room room){
        return null;
    }

    /**
     * Add a room to the room's list.
     * @param room to add to the hotel.
     * @return 1 if the room is successfully added or -1 otherwise.
     */
    public int addRoom(Room room){ 
        List<Customer> emptyRoom = new ArrayList<>();
        if(!hotel.containsKey(room)){
            hotel.put(room,emptyRoom);
            return 1;
        }
        return -1;
    }

    /**
     * Remove a room from the room's list.
     * @param room to remove from the hotel.
     * @return 1 if the room is successfully removed or -1 otherwise.
     */
    public int removeRoom(Room room){
        return -1;
    }

    /**
     * Modify a room from the room's list.
     * @param newRoom is the new room.
     * @param oldRoom is the old room.
     * @return 1 if the room is successfully modified or -1 otherwise.
     */
    public int modifyRoom(Room newRoom, Room oldRoom){
        return -1;
    }

    /**
     * Retrieve the list of occupied rooms in the hotel.
     * @return a list with the occupied rooms or an empty list.
     */
    public List<Room> getOccupiedRooms() { return null;}

    /**
     * Check in a list of clients in the room given.
     * @param room to check in the customers.
     * @param customers to check in.
     * @return 1 if the customers are successfully check in the room or -1 otherwise.
     */
    public int checkInCustomers(Room room, List<Customer> customers) { return -1;}

    /**
     * Check out the customers from the room given.
     * @param room to check out the customers.
     * @return 1 if the customers are successfully removed from the room or -1 otherwise.
     */
    public int checkOutCustomers(Room room) { return -1;}

    /**
     * Add test data to the hotel.
     */
    public void generateData() {
        List<Customer> emptyRoom = new ArrayList<>();
        hotel.put(new Room(1, 3, 50, "STANDARD", false),emptyRoom);
        hotel.put(new Room(2, 4, 30, "SUPERIOR", false),emptyRoom);
        hotel.put(new Room(3, 1, 40, "STANDARD", false),emptyRoom);
        hotel.put(new Room(4, 2, 100, "SUITE", false),emptyRoom);
    }
}