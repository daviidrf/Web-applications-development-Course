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
            System.out.println("-------------------------------------------------------------------");
            opcion = displaySelector(menuOptions);
            System.out.println("-------------------------------------------------------------------");

            switch (opcion) {
                case 1 ->
                    listAll();
                case 2 ->
                    searchByCode();
                case 3 ->
                    addProduct();
                case 4 ->
                    removeProduct();
                case 5 ->
                    searchByStock();
                case 6 ->
                    searchByType();
                case 0 -> {
                    System.out.println("Closing App...\n");
                    exit = true;
                }
                default -> {
                    System.out.print("Incorrect Option!");
                }
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
     * displays a selector with a list of options and gets option number from
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
     * @param message
     */
    private void alert(String message) {
        System.out.print(message);
    }

    /**
     * Shows all the products.
     */
    private void listAll() {
        List<Product> articles = myStore.getProducts();

        System.out.println("Number of products in the store: " + articles.size() + "\n");

        System.out.println("------------------------------------");
        System.out.printf("%4$4s %3$4s %2$4s %1$4s", "Code", "Name", "Price", "Stock");
            System.out.println("\n------------------------------------");

        for (int i = 0; i < articles.size(); i++) {
            System.out.println(articles.get(i).toString() + "\n");
        }
    }

    /**
     * Shows the product by the Code given.
     */
    private void searchByCode() {
        List<Product> articles = myStore.getProducts();
        Scanner sc = new Scanner(System.in);

        alert("Introduce the code to search your Product: ");
        String code = sc.nextLine();
        alert("\n");

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getCode().equalsIgnoreCase(code)) {
                System.out.print("Your product: ");
                System.out.println(" " + articles.get(i).toString() + "\n");
            }
        }
    }

    /**
     * Add a product.
     */
    private void addProduct() {

        Product newProd = newProduct();

        if (newProd != null) {
            boolean result = myStore.addProduct(newProd);
            if (result) {
                alert("\nProduct succesfully added to the Store.\n");
            } else {
                alert("\nError adding the product!\n");
            }

        } else {
            alert("\nError adding the product!\n");
        }

    }

    /**
     * Remove a product.
     */
    private void removeProduct() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the Code of the product to remove: ");
        Product remProd = new Product(sc.nextLine());

        if (remProd != null) {
            boolean result = myStore.removeProduct(remProd);
            if (result) {
                alert("\nProduct succesfully removed from the Store.\n");
            } else {
                alert("\nError removing the product!\n");
            }
        } else {
            alert("\nError removing the product!\n");
        }

    }

    /**
     * Asks the user the values for the new product.
     *
     * @return a new product.
     */
    private Product newProduct() {
        Scanner sc = new Scanner(System.in);
        Product newProd = new Product();

        alert("Introduce the new ID: ");
        newProd.setCode(sc.nextLine());
        alert("Introduce the new name: ");
        newProd.setName(sc.nextLine());
        alert("Introduce the new price: ");
        newProd.setPrice(sc.nextDouble());
        alert("Introduce the new stock: ");
        newProd.setStock(sc.nextInt());

        return newProd;
    }

    private void searchByStock() {
        //TODO
    }

    private void searchByType() {
        //TODO
    }

}
