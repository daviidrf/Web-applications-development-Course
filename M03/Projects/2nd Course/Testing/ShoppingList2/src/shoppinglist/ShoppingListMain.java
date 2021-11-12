package shoppinglist;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import shoppinglist.model.ShoppingList;

/**
 *
 * @author David
 */
public class ShoppingListMain {

    private ShoppingList myShoppingList;

    private List<String> menuOptions;
    private boolean exit;

    public ShoppingListMain() {

        this.menuOptions = new ArrayList<>();

        menuOptions.add("Exit.");
        menuOptions.add("Add item to the list.");
        menuOptions.add("Show items to buy.");
        menuOptions.add("Show items bought.");
        menuOptions.add("Buy a product.");
        menuOptions.add("Remove item on the list.");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShoppingListMain app = new ShoppingListMain();
        app.run();

    }

    private void run() {
        int opcion;
        myShoppingList = new ShoppingList();
        myShoppingList.generateTestData();

        do {
            exit = false;
            opcion = displayOptions(menuOptions);
            System.out.println("\n-------------------------------------------------------------------");

            switch (opcion) {
                case 1 -> {
                    //Add item to the list to buy.
                    addItemToBuy();
                    System.out.println("-------------------------------------------------------------------");
                }
                case 2 -> {
                    //Show items to buy.
                    displayArticlesToBuy();
                    System.out.println("-------------------------------------------------------------------");
                }
                case 3 -> {
                    //Show items bought.
                    displayArticlesBought();
                    System.out.println("-------------------------------------------------------------------");
                }
                case 4 -> {
                    //Buy an article and move it from the ArticleToBuy to ArticleBought.
                    buyAnArticle();
                    System.out.println("\n-------------------------------------------------------------------");
                }
                case 5 -> {
                    //Remove an article from ArticleToBuy.
                    removeFromList();
                    System.out.println("\n-------------------------------------------------------------------");
                }

                case 0 -> {
                    System.out.println("Closing App...\n");
                    exit = true;
                }
                default -> {
                    System.out.print("Incorrect Option!");
                    System.out.println("\n-------------------------------------------------------------------");
                }
            }
        } while (!exit);

    }

    private int displayOptions(List<String> list) {
        Scanner ent = new Scanner(System.in);
        int option;
        for (int i = 0; i < list.size(); i++) {
            System.out.format("%d- %s\n", i, list.get(i));
        }
        do {
            System.out.print("\nEnter your option: ");

            try {
                option = ent.nextInt();
            } catch (InputMismatchException e) {
                option = -1;
            }
        } while (option < 0 && option > list.size());

        return option;
    }

    private void addItemToBuy() {
        String itemToAdd = inputString("Introduce the product to add: ");
        if (itemToAdd != null) {
            if (myShoppingList.getArticlesToBuy().contains(itemToAdd)
                    || myShoppingList.getArticlesBought().contains(itemToAdd)) {
                System.out.println("Your item is already in the list!");
            } else {
                myShoppingList.getArticlesToBuy().add(itemToAdd);
                System.out.println("Your item is succesfully added.");
            }
        } else {
            System.out.println("Error reading article!");
        }

    }

    private void displayArticlesToBuy() {
        displayList(myShoppingList.getArticlesToBuy());
    }

    private void displayArticlesBought() {
        displayList(myShoppingList.getArticlesBought());
        System.out.println("Total amount = " + myShoppingList.getTotalAmount());
    }

    private void displayList(List<String> list) {
        for (String elem : list) {
            System.out.println(elem);
        }
        System.out.format("\nNumber of elements: %d\n", list.size());
    }

    /**
     *
     * @param question
     * @return the user answer.
     */
    private String inputString(String question) {
        Scanner ent = new Scanner(System.in);
        System.out.println(question);
        return ent.nextLine();
    }

    private void buyAnArticle() {
        int articleSelected = displayOptions(myShoppingList.getArticlesToBuy());

        if (articleSelected != -1) {
            String sprice = inputString("Introduce the price: ");
            try {
                //Convert the string to double.
                double price = Double.parseDouble(sprice);
                //Save the article in a variable.
                String article = myShoppingList.getArticlesToBuy().get(articleSelected);
                //Remove the article from ArticlesToBuy.
                myShoppingList.getArticlesToBuy().remove(articleSelected);
                //Add the article in ArticlesBought.
                myShoppingList.getArticlesBought().add(article);
                //Updates the total amount.
                //myShoppingList.getTotalAmount() += price;
                //Reports the result.
                System.out.println("Article succesfully bought.");
                System.out.println("Total amount: " + myShoppingList.getTotalAmount());
            } catch (NumberFormatException e) {
                System.out.println("Error reading the price!");
            }
        } else {
            System.out.println("Article not founded!");
        }
    }

    /**
     * Ask the user what item want to be removed. Verifies if the item exists in
     * articlesToBuy, shows the article and asks a confirmation to the user.
     * Remove the article from the list.
     */
    private void removeFromList() {
        String article = inputString("Enter the article to remove: ");
        if (myShoppingList.getArticlesToBuy().contains(article)) {
            if (confirm("CONFIRM: Do you want to remove (Yes/No) ---> " + article)) {
                myShoppingList.getArticlesToBuy().remove(article);
            } else {
                System.out.println("Cancelling Operation...");
            }
        } else {
            System.out.println("Article not found!");
        }
    }

    private boolean confirm(String message) {
        boolean b = false;
        System.out.println(message);
        Scanner ent = new Scanner(System.in);
        try {
            String x = ent.nextLine();
            if (x.equalsIgnoreCase("Yes")) {
                System.out.println("Removing...");
                return true;
            } else {
                return false;
            }
        } catch (InputMismatchException e) {
            b = false;
        }
        return b;
    }

}
