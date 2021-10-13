package proven.friends.controllers;

import proven.friends.model.FriendModel;
import proven.friends.views.FriendView;

/**
 *
 * @author David
 */
public class FriendController {
    
    private FriendModel model;
    private FriendView view;
    
    public FriendController(FriendModel model){
        this.model = model;
        this.view = new FriendView(this ,model);
        this.view.display();
    }
}
