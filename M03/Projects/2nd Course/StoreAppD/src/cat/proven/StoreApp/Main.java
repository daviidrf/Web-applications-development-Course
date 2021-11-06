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
                    modifyProduct();
                case 5 ->
                    removeProduct();
                case 6 ->
                    searchByStock();
                case 7 ->
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
        menuOptions.add("Modify product.");
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
     * Search all the products in the data source. Reports the user all the
     * products or if the data source is empty.
     */
    private void listAll() {
        List<Product> articles = myStore.getProducts();

        if (articles.size() > 0) {
            System.out.println("Number of products in the store: " + articles.size() + "\n");

//            System.out.println("------------------------------------");
//            System.out.printf("%4$4s %3$4s %2$4s %1$4s", "Code", "Name", "Price", "Stock");
//            System.out.println("\n------------------------------------");
            for (int i = 0; i < articles.size(); i++) {
                System.out.println(articles.get(i).toString() + "\n");
            }
        } else {
            alert("There is no product in the store!");
        }

    }

    /**
     * Asks the user a code to search the product to show. Search if the product
     * exists in the data source. Reports the user the product found it or that
     * there are no results.
     */
    private void searchByCode() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the code to search your Product: ");
        Product codeProd = new Product(sc.nextLine());

        Product article = myStore.getProduct(codeProd);

        if (article != null) {
            alert("\nYour product: \n\n");
            System.out.println(article.toString());
        } else {
            System.out.println("Your Object doesn't exist.\n");
        }

    }

    /**
     * Asks the user the values for the new Product. Search if the product does
     * not exist in the data source and add it. Reports the user if the product
     * is added or not.
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
     * Asks the user a Code to search the Product to modify. Search the product
     * in the data source and ask the user the new values of the product, asks
     * again to the user to confirm the changes. Reports the user if the product
     * is modified or not.
     */
    private void modifyProduct() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the Code of the product to modify: ");
        Product modSearch = new Product(sc.nextLine());

        modSearch = myStore.getProduct(modSearch);

        if (modSearch != null) {
            alert("\nProduct found, introduce the new values:\n\n");
            Product modProd = newProduct();
            if (modProd != null) {
                alert("\nConfirm to modify the product values Y/N: ");
                if (sc.nextLine().equalsIgnoreCase("Y")) {
                    boolean result = myStore.modifyProduct(modProd, modSearch);
                    if (result) {
                        alert("\nProduct succesfully modified.\n");
                    } else {
                        alert("\nError modifying the product!\n");
                    }
                } else {
                    alert("Aborting modification...");
                }
            }
        } else {
            alert("\nProduct not found!");
        }
    }

    /**
     * Asks the user a Code to search the Product to remove. Search the product
     * in the data source and asks again the user to confirm the remove. Reports
     * the user if the product is removed or not.
     */
    private void removeProduct() {
        Scanner sc = new Scanner(System.in);

        alert("Introduce the Code of the product to remove: ");
        Product remProd = new Product(sc.nextLine());

        if (remProd != null) {
            alert("Confirm to remove the prouduct Y/N: ");
            if (sc.nextLine().equalsIgnoreCase("Y")) {
                boolean result = myStore.removeProduct(remProd);

                if (result) {
                    alert("\nProduct succesfully removed from the Store.\n");
                } else {
                    alert("\nError removing the product!\n");
                }
            } else {
                alert("Aborting removing...");
            }
        } else {
            alert("\nError removing the product!\n");
        }

    }

    /**
     * Asks the user the stock. Search all the products under the stock given in
     * the data source. Reports the user the products below the stock given or
     * that there are no results.
     */
    private void searchByStock() {
        Scanner sc = new Scanner(System.in);
        alert("Introduce the stock to filter: ");
        int stock = sc.nextInt();
        List<Product> articles = myStore.getPbyStock(stock);

        if (articles.size() > 0) {
            System.out.println("Number of products in the store with stock below " + stock + ": " + articles.size() + "\n");

            for (int i = 0; i < articles.size(); i++) {
                System.out.println(articles.get(i).toString() + "\n");
            }
        } else {
            alert("There is no product below that stock!\n");
        }
    }

    /**
     * Asks the user the type to filter. Search all the products with the type
     * given. Reports the user the products of that type or that there are no
     * results.
     */
    private void searchByType() {
        //TODO
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

}
