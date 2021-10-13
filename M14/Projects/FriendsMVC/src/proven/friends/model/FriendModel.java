package proven.friends.model;

import java.util.List;


/**
 * <strong>FriendModel .java</strong>
 * MODEL class for Friends .
 * @author ProvenSoft
 */
public class FriendModel {
   

    public FriendModel() {
   
    }
    /**
     * finds a friend in the data source
     * @param entity to find
     * @return the friend found or null if not found
     */
    public Friend find(Friend entity) {
        return null;
    }
    /**
     * adds a new friend to the data source
     * @param entity to add
     * @return 1 if successfully added, 0 otherwise
     */
    public int add(Friend entity) {
        return 0;
    }
    /**
     * 
     * @param oldEntity old version to modify
     * @param newEntity new data for object to be modified
     * @return 1 if successfully modified, 0 otherwise
     */
    public int modify(Friend oldEntity, Friend newEntity) {
        return 0;
    }
    /**
     * removes a friend from the data source
     * @param entity ro remove
     * @return 1 if successfully removed, 0 otherwise
     */
    public int remove(Friend entity) {
        return 0;
    }
    /**
     * gets all friends from the data source
     * @return a list with all data or an empty list if none is found.
     */
    public List<Friend> findAll() {
        return null;
    }
        
    public List<Friend> findFriendsByName(String name) {
        return null;
    }
    
    @Override
    public String toString() {
        return null;
    }
    
}