package proven.friends.views;
import proven.friends.controllers.FriendController;
import proven.friends.model.FriendModel;
/**
 *
 * @author David
 */
public class FriendView {
    
    private FriendModel model;
    private FriendController controller;

    public FriendView(FriendController controller, FriendModel model) {
        this.model = model;
        this.controller = controller;
    }

    public void display() {
        
    }
    
    
}
