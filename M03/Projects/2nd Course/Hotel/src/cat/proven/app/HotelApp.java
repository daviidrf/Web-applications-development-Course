package cat.proven.app;

import cat.proven.model.Hotel;
import cat.proven.model.Room;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author David
 */
public class HotelApp {

    private Hotel Devel;
    private final List<String> menuOptions;

    public HotelApp() {
        this.menuOptions = new ArrayList<>();
    }

    public static void main(String[] args) {
        HotelApp app = new HotelApp();
        app.run();
    }

    private void run() {
        int option;
        generateMenu();
        Devel = new Hotel();
        Devel.generateData();

        boolean exit;
        do {
            exit = false;
            System.out.println("-------------------------------------------------------------------");
            option = displaySelector(menuOptions);
            System.out.println("-------------------------------------------------------------------");

            switch (option) {
                case 1 -> listAllRooms();
                //case 2 -> ;
                //case 3 -> ;
                //case 4 -> ;
                //case 5 -> ;
                //case 6 -> ;
                //case 7 -> ;
                case 0 -> {
                    System.out.println("Closing App...\n");
                    exit = true;
                }
                default -> System.out.print("Incorrect Option!\n");
            }
        } while (!exit);
    }

    private void generateMenu() {
        menuOptions.add("Exit.");
        menuOptions.add("Show all the rooms.");
        menuOptions.add("Show all the customers.");
        menuOptions.add("Show the customers in a room.");
        menuOptions.add("Add a room.");
        menuOptions.add("Remove a room.");
        menuOptions.add("Modify a room.");
        menuOptions.add("Check-in a customer.");
        menuOptions.add("Check-out a customer.");
        menuOptions.add("Number of occupied rooms.");
    }

    /**
     * Displays a selector with a list of options and gets option number from
     * user.
     *
     * @return the number of the option selected by user or -1 in case of error.
     */
    private int displaySelector(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.format("%d. %s\n", i, options.get(i));
        }
        alert("\nEnter your option: ");
        Scanner sc = new Scanner(System.in);
        int option;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            option = -1;
        }
        return option;
    }

    /**
     * Prompts a message to user
     *
     * @param message the input message to display.
     */
    private void alert(String message) {
        System.out.print(message);
    }

    /**
     * Show all the rooms.
     */
    private void listAllRooms() {
        List<Room> rooms = Devel.getRooms();
        for (int i = 0; i < rooms.size(); i++) {
            alert("Room" + (i + 1) + "\n");
            System.out.println(rooms.get(i).toString());
        }
    }
}
