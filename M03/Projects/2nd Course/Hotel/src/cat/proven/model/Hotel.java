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
     * @param room to search the customers in.
     * @return a list with th customers in the room given or an empty list.
     */
    public List<Customer> getCustomersByRoom(Room room){
        List<Customer> customers = new ArrayList<>();
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            if(entry.getKey().equals(room)){
                for (int i = 0; i < entry.getValue().size(); i++) {
                    customers.add(entry.getValue().get(i));
                }
            }
        }
        return customers;
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
        if(hotel.containsKey(room)){
            hotel.remove(room);
            return 1;
        }
        return -1;
    }

    /**
     * Modify a room from the room's list.
     * @param newRoom is the new room.
     * @param oldRoom is the old room.
     * @return 1 if the room is successfully modified or -1 otherwise.
     */
    public int modifyRoom(Room newRoom, Room oldRoom){
        for (Map.Entry<Room, List<Customer>> entry : hotel.entrySet()) {
            if(entry.getKey().equals(oldRoom)){
                    //entry.getKey(newRoom);
            }
        }
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
        List<Customer> room1 = new ArrayList<>();
            room1.add(new Customer("David", "46480325Q"));
            room1.add(new Customer("Jordi", "45636534R"));
        List<Customer> room2 = new ArrayList<>();
        room2.add(new Customer("Roger", "43124542E"));

        hotel.put(new Room(1, 3, 50, "STANDARD"),room1);
        hotel.put(new Room(2, 4, 30, "SUPERIOR"),emptyRoom);
        hotel.put(new Room(3, 1, 40, "STANDARD"),room2);
        hotel.put(new Room(4, 2, 100, "SUITE"),emptyRoom);


    }
}
