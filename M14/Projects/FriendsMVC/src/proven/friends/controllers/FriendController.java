package proven.friends.controllers;

import java.util.List;
import proven.friends.model.Friend;
import proven.friends.model.FriendModel;
import proven.friends.views.FriendView;

/**
 * <strong>FriendController.java</strong>
 * Class FriendController. Friend controller. uses the
 * {@link proven.friends.model.FriendModel} class. uses the
 * {@link proven.friends.views.FriendView} class.
 *
 * @author ProvenSoft
 */
public class FriendController {

    private final FriendModel model;
    private final FriendView view;

    public FriendController(FriendModel model) {
        this.model = model;
        this.view = new FriendView(this, model);
        view.display();
    }

    public void exitApplication() {
        System.exit(0);
    }

    /**
     * Processes requests from the view.
     *
     * @param action to execute.
     */
    public void processRequest(String action) {
        action = (action == null) ? "wrong_action" : action;
        switch (action) {
            case "exit":
                exitApplication();
                break;
            case "list_all_friends":
                listAllFriends();
                break;
            case "search_friend_by_phone":
                searchFriendByPhone();
                break;
            case "friend_form_remove":
                removeFriendForm();
                break;
            case "friend_form_add":
                addFriend();
                break;
            case "search_friends_by_name":
                searchFriendsByName();
                break;
            case "friend_form_modify":
                modifyFriendForm();
                break;
            case "wrong_action":
            default:
                view.showMessage("Wrong option");
                break;
        }
    }

    /**
     * lists all friends in the data source.
     */
    public void listAllFriends() {
        List<Friend> data = model.findAll();
        if (data != null) {
            view.showFriendTable(data);
        } else {
            view.showMessage("Error retrieving data");
        }
    }

    public void searchFriendByPhone() {
        String phone = view.showInputDialog("Input phone: ");
        if (phone != null) {
            Friend friend = new Friend(phone);
            Friend found = model.find(friend);
            if (found != null) {
                view.friendForm(found);
            } else {
                view.showMessage("Friend not found");
            }
        } else {
            view.showMessage("Error in parameter phone");
        }
    }

    public void searchFriendsByName() {
        String name = view.showInputDialog("Input name: ");
        if (name != null) {
            List<Friend> data = model.findFriendsByName(name);
            if(data != null) {
                view.showFriendTable(data);
            } else{
                view.showMessage("Error searching Friends");
            }
            
        } else {
            view.showMessage("Error in parameter name");
        }
    }

    /**
     * adds a new friend to data source
     *
     * @param friend to add
     */
    public void addFriend() {
        Friend friend = view.friendForm(null);
        if (friend != null) {
            int result = model.add(friend);
            if (result > 0) {
                view.showMessage("Friend successfully added");
            } else {
                view.showMessage("Friend has not been added");
            }
        } else  {
            view.showMessage("Error in parameters");
        }

    }

    /**
     * modifies a Friend in the data source
     *
     * @param oldVersion old data
     * @param newVersion new data
     */
    public void modifyFriend(Friend oldVersion, Friend newVersion) {
        int result = model.modify(oldVersion, newVersion);
        if (result > 0) {
            view.showMessage("Friend successfully modified");
        } else {
            view.showMessage("Friend has not been modified");
        }
    }

    /**
     * removes a Friend from the data source
     *
     * @param friend to be removed
     */
    public void removeFriend(Friend friend) {
        int result = model.remove(friend);
        if (result > 0) {
            view.showMessage("Friend successfully removed");
        } else {
            view.showMessage("Friend has not been removed");
        }
    }

    public void modifyFriendForm() {
        String phone = view.showInputDialog("Input phone: ");
        if (phone != null) {
            Friend friend = new Friend(phone);
            Friend found = model.find(friend);
            if (found != null) {
                view.friendForm(found);
            } else {
                view.showMessage("Friend not found");
            }
        }
    }

    public void removeFriendForm() {
        String phone = view.showInputDialog("Input phone: ");
        if (phone != null) {
            Friend friend = new Friend(phone);
            Friend found = model.find(friend);
            if (found != null) {
                view.friendForm(found);
            } else {
                view.showMessage("Friend not found");
            }
        }
    }

}
