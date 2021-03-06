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
                case 6 -> modifyRoom();
                case 7 -> checkIn();
                case 8 -> checkOut();
                case 9 -> listOccupiedRooms();
                case 0 -> {
                    System.out.println("Closing App...\n");
                    exit = true;
                }
                default -> System.out.print("Incorrect Option!\n");
            }
        } while (!exit);
    }

    /**
     * Generate the menu options of the program.
     */
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
        menuOptions.add("List occupied rooms.");
    }

    /**
     * Display a list of rooms.
     *
     * @param rooms the list of rooms to display.
     */
    private void displayRooms(List<Room> rooms) {
        for (Room room : rooms) {
            alert(room.toString() + "\n");
        }
    }

    /**
     * Display a list of customers.
     *
     * @param customers the list of customers to display.
     */
    private void displayCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            alert(customer.toString() + "\n");
        }
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
     * Prompts a message to the user
     *
     * @param message the input message to display.
     */
    private void alert(String message) {
        System.out.print(message);
    }

    /**
     * Ask the values for the new room.
     *
     * @return a room with the values given.
     */
    private Room askRoomValues() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the new room number: ");
        int number = sc.nextInt();
        alert("Introduce the new room capacity: ");
        int capacity = sc.nextInt();
        alert("Introduce the new room price: ");
        double price = sc.nextDouble();
        alert("Introduce the new category: ");
        String category = getCategory(sc.nextLine());

        return new Room(number, capacity, price, category);
    }

    /**
     * @param category the category to compare.
     * @return a valid category for the new Hotel room.
     */
    private String getCategory(String category) {
        if (category.equalsIgnoreCase("superior")) {
            return "SUPERIOR";
        } else if (category.equalsIgnoreCase("suite")) {
            return "SUITE";
        } else {
            return "STANDARD";
        }
    }

    /**
     * Show all the rooms.
     */
    private void listAllRooms() {
        List<Room> rooms = Devel.getRooms();
        displayRooms(rooms);
    }

    /**
     * Show all the customers in the Hotel. Show the result to the user.
     */
    private void listAllCustomers() {
        List<Customer> customers = Devel.getCustomers();
        if (customers.size() > 0) {
            displayCustomers(customers);
        } else {
            alert("There are no rooms with customers.");
        }
    }

    /**
     * Show the customers in the room given if there are customers in it.
     * Show the result to the user.
     */
    private void listCustomersById() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the number of the room to list the customers: ");
        List<Customer> customers = Devel.getCustomersByRoom(new Room(sc.nextInt()));

        if (customers.size() > 0) {
            displayCustomers(customers);
        } else {
            alert("This room is empty.\n\n");
        }
    }

    /**
     * Ask the user a new room values for a new room.
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
     * Ask the user a room number and the confirmation and remove it from
     * the Hotel. Show the result to the user.
     */
    private void removeRoom() {
        Scanner sc = new Scanner(System.in);
        int result = -1;

        List<Room> rooms = Devel.getRooms();
        alert("Introduce the number of the room you want to remove: ");
        int number = sc.nextInt();

        for (Room room : rooms) {
            if (room.getNumber() == number) {
                alert("Room found, confirm if you want to remove (Y/N): ");
                sc.nextLine();
                if (sc.nextLine().equalsIgnoreCase("Y")) {
                    result = Devel.removeRoom(room);
                    if (result == 1) {
                        alert("\nRoom successfully removed.\n");
                    } else {
                        alert("\nRoom not removed.\n");
                    }
                }
                break;
            }
        }
    }

    /**
     * Ask the user a room number and modify it with the new values given
     * and show to the user the result.
     */
    private void modifyRoom() {
        Scanner sc = new Scanner(System.in);
        int result = -1;
        List<Room> rooms = Devel.getRooms();
        alert("Introduce the number of the room to modify: ");
        int number = sc.nextInt();

        for (Room room : rooms) {
            if (room.getNumber() == number) {
                Room newRoom = askRoomValues();
                alert("Room found, confirm if you want to modify (Y/N):");
                sc.nextLine();

                if (sc.nextLine().equalsIgnoreCase("Y")) {
                    result = Devel.modifyRoom(newRoom, room);
                    if (result == 1) {
                        alert("\nRoom successfully modified.\n");
                    } else {
                        alert("\nRoom not modified.\n");
                    }
                }
                break;
            }
        }
    }

    /**
     * Check in the users given by the user in the room selected
     * if the room is empty and show to the user the result.
     */
    private void checkIn() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the category do you want: ");
        String category = sc.nextLine();
        alert("Introduce the number of customers to check in: ");
        int capacity = sc.nextInt();

        List<Room> available = Devel.getRoomsByCategoryCapacity(category, capacity);

        if (available.size() > 0) {
            alert("\nShowing available rooms...\n");
            for (Room room : available) {
                alert(room.toString() + "\n");
            }
            alert("\nIntroduce the number of the room to check in: \n");
            int roomNumber = sc.nextInt();

            for (Room roomEntry : available) {
                if (roomEntry.getNumber() == roomNumber) {
                    Room room = Devel.getRoomByNumber(roomNumber);
                    if (room != null) {
                        if (Devel.getCustomersByRoom(room).isEmpty()) {
                            List<Customer> customers = askCustomersValues(capacity);
                            if (Devel.checkInCustomers(room, customers) == 1) {
                                alert("\nCustomers checked in room " + room.getNumber() + "\n");
                            } else {
                                alert("\nError checking in the customers!\n");
                            }
                        } else {
                            alert("\nThis room is occupied!\n");
                        }
                    } else {
                        alert("\nThis room don't exist!");
                    }
                } else {
                    alert("\nThat room is not valid! Aborting...\n");
                }
            }
        } else {
            alert("\nNo available rooms!\n");
        }
    }

    /**
     * Check out the users in the room selected if the room is not empty
     * and show to the user the result.
     */
    private void checkOut() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the number of the room to check out: ");
        Room room = Devel.getRoomByNumber(sc.nextInt());
        if (room != null) {
            if (!Devel.getCustomersByRoom(room).isEmpty()) {
                List<Customer> customers = Devel.getCustomersByRoom(room);
                if (!customers.isEmpty()) {
                    for (Customer customer : customers) {
                        System.out.println(customer.toString());
                    }
                    alert("\nThis is your room? Confirm to check out (Y/N): ");
                    sc.nextLine();
                    if (sc.nextLine().equalsIgnoreCase("Y")) {
                        if (Devel.checkOutCustomers(room) == 1) {
                            alert("\nCustomers checked out successfully.\n");
                        } else {
                            alert("\nError checking out the customers!\n");
                        }
                    } else {
                        alert("\nCanceling check out...\n");
                    }
                }
            } else {
                alert("\nThis room is empty already!\n");
            }
        }
    }

    /**
     * List the rooms occupied by customers if there are. Show the result
     * to the user.
     */
    private void listOccupiedRooms() {
        List<Room> rooms = Devel.getOccupiedRooms();
        displayRooms(rooms);
    }

    /**
     * Ask customer values as many times as the capacity given.
     *
     * @param capacity the number of times to ask the customer values.
     * @return a list with the customers or an empty list.
     */
    private List<Customer> askCustomersValues(int capacity) {
        Scanner sc = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            alert("\nIntroduce the Name: ");
            String name = sc.nextLine();
            alert("Introduce the NIF: ");
            String nif = sc.nextLine();

            customers.add(new Customer(name, nif));
        }

        return customers;
    }
}
