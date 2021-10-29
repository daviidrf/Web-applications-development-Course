package cat.proven.StoreApp;

import cat.proven.StoreApp.model.Product;
import cat.proven.StoreApp.model.Store;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Main {
    
    private Store myStore;
    
    private List<String> menuOptions;
    private boolean exit;
    
    public Main() {

        this.menuOptions = new ArrayList<>();


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
    
    private void run() {
        int opcion;
        generateMenu();
        myStore = new Store();
        myStore.generateTestData();
        
        do {
            exit = false;
            opcion = displaySelector(menuOptions);
            System.out.println("\n-------------------------------------------------------------------");

            switch (opcion) {
                case 1 -> listAll();
                case 2 -> listProductByCode();
                case 0 -> {System.out.println("Closing App...\n");
                    exit = true;
                }
                default -> {System.out.print("Incorrect Option!");}
            }
        } while (!exit);
    }

    private void generateMenu() {
        menuOptions.add("Exit.");
        menuOptions.add("List all the products.");
        menuOptions.add("Search product by code.");
        menuOptions.add("Add product.");
        menuOptions.add("Remove product.");
        menuOptions.add("Search product with the stock given.");
        menuOptions.add("Search product by type.");
    }
    
    /**
     * displays a selector with a list of options and gets option number from user.
     * @return the number of the option selected by user or -1 in case of error.
     */
    private int displaySelector(List<String> options) {
        for (int i=0; i<options.size();i++) {
            System.out.format("%d. %s\n", i, options.get(i));
        }
        alert("Enter your choice: ");
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
     * @param message 
     */
    private void alert(String message) {
        System.out.println(message);
    }
    
    /**
     * Shows all the products.
     */
    private void listAll() {
        List<Product> articles = myStore.getProducts();
        
        System.out.println("Number of products in the store: " + articles.size());
        
        for (Product article : articles) {
            article.toString();
        }
    }

    private void listProductByCode() {
        List<Product> articles = myStore.getProducts();
        
        
    }
    
    
}
