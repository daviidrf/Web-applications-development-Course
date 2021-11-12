package cat.proven.StoreApp;

import cat.proven.StoreApp.model.Fridge;
import cat.proven.StoreApp.model.Product;
import cat.proven.StoreApp.model.Store;
import cat.proven.StoreApp.model.Tv;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author David
 */
public class Main {

    private Store myStore;

    private final List<String> menuOptions;

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
        int option;
        generateMenu();
        myStore = new Store();
        myStore.generateTestData();

        boolean exit;
        do {
            exit = false;
            System.out.println("-------------------------------------------------------------------");
            option = displaySelector(menuOptions);
            System.out.println("-------------------------------------------------------------------");

            switch (option) {
                case 1 -> listAll();
                case 2 -> searchByCode();
                case 3 -> addProduct();
                case 4 -> modifyProduct();
                case 5 -> removeProduct();
                case 6 -> searchByStock();
                case 7 -> searchByType();
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
        menuOptions.add("List all the products.");
        menuOptions.add("Search product by code.");
        menuOptions.add("Add product.");
        menuOptions.add("Modify product.");
        menuOptions.add("Remove product.");
        menuOptions.add("Search product with stock below the given.");
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
     * @param message the input message to display.
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
            for (Product article : articles) {
                System.out.println(article.toString() + "\n");
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
        Product article = myStore.getProduct(sc.nextLine());

        if (article != null) {
            alert("\nYour product: \n\n");
            System.out.println(article);
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
        Scanner sc = new Scanner(System.in);
        alert("What type of product do you want to add: ");
        Product newProd = newProduct(sc.nextLine());

        if (newProd != null) {
            boolean result = myStore.addProduct(newProd);
            if (result) {
                alert("\nProduct successfully added to the Store.\n");
            } else {
                alert("\nError adding the product!\n");
            }

        } else {
            alert("\nError adding the product, the product is null!\n");
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
        String code = sc.nextLine();
        boolean found = myStore.codeExist(code);
        Product modSearch = myStore.getProduct(code);

        if (found) {
            String pType = myStore.getProduct(code).getClass().getSimpleName();
            if (modSearch != null) {
                alert("\nProduct found, introduce the new values:\n\n");
                Product modProd = newProduct(pType);
                if (modProd != null) {
                    alert("\nConfirm to modify the product values Y/N: ");
                    if (sc.nextLine().equalsIgnoreCase("Y")) {
                        boolean result = myStore.modifyProduct(modProd, modSearch);
                        if (result) {
                            alert("\nProduct successfully modified.\n");
                        } else {
                            alert("\nError modifying the product!\n");
                        }
                    } else {
                        alert("Aborting modification...\n");
                    }
                }
            }
        } else {
            alert("\nProduct not found!\n");
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
        Product remProd = myStore.getProduct(sc.nextLine());

        if (remProd != null) {
            alert("Confirm to remove the product Y/N: ");
            if (sc.nextLine().equalsIgnoreCase("Y")) {
                boolean result = myStore.removeProduct(remProd);

                if (result) {
                    alert("\nProduct successfully removed from the Store.\n");
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

        System.out.println("Number of products in the store with stock below " + stock + ": " + articles.size() + "\n");
        if (articles.size() > 0) {

            for (Product article : articles) {
                System.out.println(article.toString() + "\n");
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
        Scanner sc = new Scanner(System.in);
        alert("What type of product do you want to list: ");
        String pType = sc.nextLine();

        if (pType.equalsIgnoreCase("tv") || pType.equalsIgnoreCase("fridge")) {
            List<Product> articles = myStore.getProductsByType(pType);

            System.out.println("Number of products of this type: " + articles.size() + "\n");
            if (articles.size() > 0) {
                for (Product article : articles) {
                    System.out.println(article.toString() + "\n");
                }
            } else {
                alert("There is no products of this type!\n");
            }
        } else {
            alert("Type given not valid!\n");
        }
    }

    /**
     * Asks the user the values for the new product.
     *
     * @return a new product.
     */
    private Product newProduct(String type) {
        Scanner sc = new Scanner(System.in);

        if (type.equalsIgnoreCase("tv")) {
            Tv newProd = new Tv();
            alert("Introduce the new ID: ");
            newProd.setCode(sc.nextLine());
            alert("Introduce the new name: ");
            newProd.setName(sc.nextLine());
            alert("Introduce the new price: ");
            newProd.setPrice(sc.nextDouble());
            alert("Introduce the new stock: ");
            newProd.setStock(sc.nextInt());
            alert("Introduce the new inches: ");
            newProd.setInches(sc.nextInt());

            return newProd;

        } else if (type.equalsIgnoreCase("fridge")) {
            Fridge newProd = new Fridge();
            alert("Introduce the new ID: ");
            newProd.setCode(sc.nextLine());
            alert("Introduce the new name: ");
            newProd.setName(sc.nextLine());
            alert("Introduce the new price: ");
            newProd.setPrice(sc.nextDouble());
            alert("Introduce the new stock: ");
            newProd.setStock(sc.nextInt());
            alert("Introduce the new capacity: ");
            newProd.setCapacity(sc.nextInt());
            alert("Introduce the new noFrost value: ");
            newProd.setNoFrost(sc.nextBoolean());

            return newProd;
        } else {
            alert("Incorrect type introduced!");
            return null;
        }

    }

}
