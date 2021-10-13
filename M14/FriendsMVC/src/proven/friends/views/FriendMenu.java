package proven.friends.views;
/** 
 * FriendMenu.java
 * Class FriendMenu
 * Menu form friends application.
 * @author Jose Moreno
 */
public class FriendMenu extends Menu {

    public FriendMenu() {
        super("Friends Manager main menu");
        addOption(new Option("Exit","exit"));
        addOption(new Option("List All friends","list_all_friends"));
        addOption(new Option("Find friend by phone","search_friend_by_phone"));
        addOption(new Option("Find friends by name","search_friends_by_name"));
        addOption(new Option("Add friend","friend_form_add"));
        addOption(new Option("Modify friend","friend_form_modify"));
        addOption(new Option("Remove friend","friend_form_remove"));
    } 
}