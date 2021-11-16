package cat.proven.app;

import cat.proven.model.Customer;
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
                case 2 -> listAllCustomers();
                case 3 -> listCustomersById();
                case 4 -> addRoom();
                case 5 -> removeRoom();
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
     * Ask the values for the new room.
     * @return a room with the values given.
     */
    private Room askRoomValues() {
        Scanner sc = new Scanner(System.in);
        String category = null;
        boolean catOk = false;

        alert("Introduce the new room number: ");
        int number = sc.nextInt();
        alert("Introduce the new room capacity: ");
        int capacity = sc.nextInt();
        alert("Introduce the new room price: ");
        double price = sc.nextDouble();

        while (!catOk) {
            alert("Introduce the new room category: ");
            sc.nextLine();
            category = sc.nextLine();

            if (category.equalsIgnoreCase("standard")) {
                category = "STANDARD";
                catOk = true;
            } else if (category.equalsIgnoreCase("superior")) {
                category = "SUPERIOR";
                catOk = true;
            } else if (category.equalsIgnoreCase("suite")) {
                category = "SUITE";
                catOk = true;
            } else {
                alert("Incorrect category!\n");
            }
        }
        return new Room(number, capacity, price, category);
    }

    /**
     * Show all the rooms.
     */
    private void listAllRooms() {
        List<Room> rooms = Devel.getRooms();

        for (Room room : rooms) {
            alert(room.toString() + "\n");
        }
    }

    /**
     * Show all the customers in the Hotel.
     */
    private void listAllCustomers() {
        List<Customer> customers = Devel.getCustomers();

        if (customers.size() > 0) {
            for (Customer customer : customers) {
                alert(customer.toString() + "\n");
            }
        } else {
            alert("There are no rooms with customers.");
        }

    }

    /**
     * Show the customers in the room given.
     */
    private void listCustomersById() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the number of the room to list the customers: ");
        List<Customer> customers = Devel.getCustomersByRoom(new Room(sc.nextInt()));

        if (customers.size() > 0) {
            for (Customer customer : customers) {
                alert(customer.toString() + "\n");
            }
        } else {
            alert("This room is empty.\n\n");
        }
    }

    /**
     * Ask the user a new room values and add it in the Hotel.
     */
    private void addRoom() {
        Room newRoom = askRoomValues();
        int result = Devel.addRoom(newRoom);

        if (result == 1) {
            alert("\nRoom successfully added.\n");
        } else {
            alert("\nError adding the room.\n");
        }
    }

    /**
     * Ask the user a room number and remove it from the Hotel.
     */
    private void removeRoom() {
        Scanner sc = new Scanner(System.in);
        int result = -1;

        List<Room> rooms = Devel.getRooms();
        alert("Introduce the number of the room you want to remove: ");

        for (Room room : rooms) {
            if (room.getNumber() == sc.nextInt()) {
                alert("Room found, confirm if you want to remove (Y/N): ");
                sc.nextLine();
                if(sc.nextLine().equalsIgnoreCase("Y")) {
                    result = Devel.removeRoom(room);
                }
                break;
            }
        }

        if(result == 1) {
            alert("\nRoom successfully removed.\n");
        } else {
            alert("\nRoom not removed.\n");
        }
    }

}
