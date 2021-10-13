package proven.friends;
import proven.friends.controllers.FriendController;
import proven.friends.model.FriendModel;
/**
 *
 * @author David
 */
public class FriendsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FriendModel model = new FriendModel();
        FriendController control = new FriendController(model);
    }
    
}
