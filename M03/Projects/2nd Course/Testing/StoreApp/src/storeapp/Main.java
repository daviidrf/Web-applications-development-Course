package storeapp;

import java.util.ArrayList;
import java.util.List;
import storeapp.model.Store;

/**
 *
 * @author David
 */
public class Main {
    
    private List<String> menuOptions;
    private boolean exit;
    
    public Main() {

        this.menuOptions = new ArrayList<>();

        menuOptions.add("Exit.");
        menuOptions.add("List all the products.");
        menuOptions.add("Search product by code.");
        menuOptions.add("Add product.");
        menuOptions.add("Remove product.");
        menuOptions.add("Search product with the stock given.");
        menuOptions.add("Search product by type.");

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
        Store store = new Store();
        store.generateTestData();

        do {
            exit = false;
            opcion = displayOptions(menuOptions);
            System.out.println("\n-------------------------------------------------------------------");

            switch (opcion) {
                case 1 -> {addItemToBuy();}
                case 2 -> {displayArticlesToBuy();}
                case 3 -> {displayArticlesBought();}
                case 4 -> {buyAnArticle();}
                case 5 -> {removeFromList();}
                case 0 -> {System.out.println("Closing App...\n");
                    exit = true;
                }
                default -> {System.out.print("Incorrect Option!");}
            }
        } while (!exit);
    }
    
    
    
}
