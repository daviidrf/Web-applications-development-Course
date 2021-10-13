package proven.friends.views;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import proven.friends.controllers.FriendController;
import proven.friends.model.Friend;
import proven.friends.model.FriendModel;

/**
 * FriendView class View of friend manager application
 *
 * @author Jose Antonio
 */
public class FriendView {

    private final FriendController control;
    private final FriendModel model;
    private final FriendMenu menu;

    public FriendView(FriendController control, FriendModel model) {
        this.control = control;
        this.model = model;
        this.menu = new FriendMenu();
    }

    public String showInputDialog(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    /**
     * Displays a message.
     *
     * @param message to display
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Shows the view.
     */
    public void display() {
        do {
            menu.show();
            String action = menu.getSelectedOptionActionCommand();
            processAction(action);
        } while (true);
    }

    /**
     * control method for actions in the view
     *
     * @param action to execute
     */
    private void processAction(String action) {
        if (action != null) {
            switch (action) {
                default:
                    control.processRequest(action);
                    break;
            }
        }
    }

    /**
     * prints a table with the given data
     *
     * @param data to print
     */
    public void showFriendTable(List<Friend> data) {
        for (Friend elem : data) {
            System.out.println(elem.toString());
        }
        System.out.format("%d elements found.\n", data.size());
    }

    /**
     *
     * @param input
     * @return
     */
    public Friend friendForm(Friend input) {
        Friend f = null;
        if (input != null) {
            System.out.println(input.toString());
        }
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Input phone: ");
            String phone = scan.next();
            System.out.print("Input name: ");
            String name = scan.next();
            System.out.print("Input age: ");
            int age = scan.nextInt();
            f = new Friend(phone, name, age);
        } catch (NumberFormatException e) {
            f = null;
        } catch (InputMismatchException e) {
            f = null;
        }
        return f;
    }

}//end of class
