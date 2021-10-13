package proven.friends;

import proven.friends.controllers.FriendController;
import proven.friends.model.FriendModel;

/**
 * <strong>FriendsApp.java</strong>
 * Application to manage friends and categories.
 * uses the {@link proven.friends.controllers.FriendController} class.
  * @author ProvenSoft
 */
public class FriendsApp {
    public static void main(String [] args) {
        FriendModel model = new FriendModel();
        FriendController control = new FriendController(model);
    }
}