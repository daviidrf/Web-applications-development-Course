package cat.proven.model;

import java.util.List;

public class Hotel {

    /**
     * Retrieve all the rooms in the hotel.
     * @return a list with all the rooms or an empty list.
     */
    public List<Room> getRooms(){
        return null;
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
     * @param roomNumber to search the customers in.
     * @return a list with th customers in the room given or an empty list.
     */
    public List<Customer> getCustomersByRoom(int roomNumber){
        return null;
    }

    /**
     * Add a room to the room's list.
     * @param room to add to the hotel.
     * @return true if the room is successfully added or false otherwise.
     */
    public boolean addRoom(Room room){
        return false;
    }

    /**
     * Remove a room from the room's list.
     * @param room to remove from the hotel.
     * @return true if the room is successfully removed or false otherwise.
     */
    public boolean removeRoom(Room room){
        return false;
    }

    /**
     * Modify a room from the room's list.
     * @param room to modify in the hotel.
     * @return true if the room is successfully modified or false otherwise.
     */
    public boolean modifyRoom(Room room){
        return false;
    }

    
}
