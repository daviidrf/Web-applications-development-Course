package cat.proven.shoppinglist;

import cat.proven.shoppinglist.model.ShoppingList;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    //attributes
    private ShoppingList myShoppingList;
    
    private boolean exit;  //flag to exit application.
    private List<String> menu;  //the menu of the application.
    
    public static void main(String[] args) {
        Main ap = new Main();
        ap.run();
    }
    
    private void run() {
       this.menu = new ArrayList<>();
       generateMenu();
       exit = false;
       myShoppingList = new ShoppingList();
       myShoppingList.generateTestData();  //fake data to test the application. Remove for production.
       do {
            //display menu and get user's choice.
            alert("Shopping list menu");
            int choice = displaySelector(menu);
            //process choice.
            switch (choice) {  //new switch: returns a value.
                case 0 -> exitApp();  //break clause not required.
                case 1 -> displayArticlesToBuy();
                case 2 -> displayBoughtArticles();
                case 3 -> addToList();
                case 4 -> buy();
                case 5 -> removeFromList();
                default -> alert("Bad option");
            }
       } while (!exit); 
    }
    
    /** ====== CONTROL METHODS ====== **/    
    
    /**
     * exits application.
     */
    private void exitApp() {
        exit = true;
    }

    /**
     * asks the user to input the article to add, 
     * verifies that the article does not exist in any list
     * and adds it to list,
     * and reports result to user
     */
    private void addToList() {
        //read article form user
        String article = inputString("Input article: ");
        if (article != null) {
            boolean result = myShoppingList.addArticle(article);
            String resultMsg = (result ? "Article successfully added" : "Error adding article" );
            alert(resultMsg);
        } else {
            alert("Error reading article");
        }
    }

    /**
     * displays the list of articles to buy,
     * asks the user to select an article.
     * I correctly selected, 
     * searches the article in the list of articles to buy,
     * asks the user to input the price,
     * moves an article from the list of articles to buy 
     * to the list of bought articles and reports result to user.
     * If not, reports error to user.
     */
    private void buy() {
        //display list of articles to buy and read article from user
        int articleSelected = displaySelector(myShoppingList.getArticlesToBuy());       
        //validate user's choice
        //System.out.println("DEBUG: SELECTED ARTICLE: "+articleSelected);
        if ((articleSelected>=0) && (articleSelected<myShoppingList.getArticlesToBuy().size())) {
            //read price from user
            String sprice = inputString("Enter price: ");
            try {
                double price = Double.parseDouble(sprice);
                if (price >= 0)  {
                    //retrieve article
                    String found = myShoppingList.getArticlesToBuy().get(articleSelected);
                    boolean result = myShoppingList.buy(found);
                    if (result) {
                        //update total amount
                        myShoppingList.updateAmount(price);
                        //report result to user 
                        alert("Article successfully bought");
                        alert("Total amount: "+myShoppingList.getTotalAmount());
                    } else {
                        alert("Error buying article");
                    }
                } else {
                    alert("Price should not be negative");
                }
            } catch (NumberFormatException e) {
                alert("Error reading price");
            }       
        } else {
            alert("Article not found!");
        }
    }

    /**
     * asks the user to input the text of the article to remove,
     * searches the article in the list and, if found, shows the article
     * and asks for confirmation. If not found, reports error to user.
     * Then removes the article from the list of articles to buy,
     * and reports result to user
     */
    private void removeFromList() {
        //read article from user
        String article = inputString("Enter article to remove: ");
        //validate input
        if (article != null) {
            //search article.
            String foundArticle = myShoppingList.findArticle(article);
            if (foundArticle != null) {
                //display article
                displayArticle(foundArticle);
                //confirm removal
                boolean answer = confirm("Are you sure? ");
                if (answer) {
                    //remove
                    boolean result = myShoppingList.removeArticle(article);  
                    String resultMsg = 
                       (result ? "Article successfully removed" : "Error removing article");
                    alert(resultMsg);
                } else {
                    alert("Operation cancelled by user");
                }
            } else {
                alert("Article not found");
            }
        } else {
            alert("Article not found");
        }
    }
    
    /** ====== VIEW METHODS ====== **/

    private void generateMenu() {
        menu.add("Exit");
        menu.add("Show articles to buy");
        menu.add("Show bought articles");
        menu.add("Add to list");
        menu.add("Buy");
        menu.add("Remove from list");
    }
    
    /**
     * displays the list of articles to buy
     */
    private void displayArticlesToBuy() {
        List<String> articles = myShoppingList.getArticlesToBuy();
        displayList(articles);
    }

    /**
     * displays the list of bought articles
     */
    private void displayBoughtArticles() {
        List<String> articles = myShoppingList.getBoughtArticles();
        displayList(articles);
        alert("Total amount: " +  myShoppingList.getTotalAmount());
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
     * displays list to user
     * @param list the list to display
     */
    private void displayList(List<String> list) {
        for (String elem: list) {
            alert(elem);
        }
        alert(String.format("Number of elements: %d\n", list.size()));        
    }
    
    /**
     * prompts a message to user and reads a text from user
     * @return the text been read
     */
    private String inputString(String message) {
        System.out.print(message);               
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    
    /**
     * prompts a message to user and ask for confirmation
     * @param message the message to show to user
     * @return true or false
     */
    private boolean confirm(String message) {
        boolean b = false;
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        try {
            b = sc.nextBoolean();
        } catch (InputMismatchException e) {
            b = false;
        }
        return b;
    }
    
    /**
     * Prompts a message to user
     * @param message 
     */
    private void alert(String message) {
        System.out.println(message);
    }

    /**
     * displays article data
     * @param article the article to show 
     */
    private void displayArticle(String article) {
        System.out.println(article);
    }
    
}
