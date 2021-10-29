package cat.proven.shoppinglist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ADT class for a shopping list
 * @author ProvenSoft
 */
public class ShoppingList {
    
    //attributes
    private List<String> articlesToBuy;
    private List<String> boughtArticles;
    private double totalAmount;
    
    //constructor

    public ShoppingList() {
        this.articlesToBuy = new ArrayList<>();
        this.boughtArticles = new ArrayList<>();
        this.totalAmount = 0.0;        
    }

    // getters and setters (accessors)
    
    public List<String> getArticlesToBuy() {
        return articlesToBuy;
    }

    public List<String> getBoughtArticles() {
        return boughtArticles;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    
    //methods
    
    /**
     * searches article in the data source
     * @param article the article to find
     * @return the article found or null if not found or in case of error
     */
    public String findArticle(String article) {
        String found = null;
        int index = articlesToBuy.indexOf(article);
        if (index >= 0) {  //found!
            found = articlesToBuy.get(index);
        } else {
            found = null;
        }
        return found;
    }
    
    
    /**
     * adds an article to the list of articles to buy,
     * it prevents null articles and duplicates.
     * @param article the article to add
     * @return true if successfully added, false otherwise
     */
    public boolean addArticle(String article) {
        boolean b;
        if (article != null) {
            if ( (!articlesToBuy.contains(article))  
                  &&  (!boughtArticles.contains(article)) ) {
                articlesToBuy.add(article);
                b = true;
            } else {
                b = false;
            }
        } else {
            b = false;
        }
        return b;
    }
    
    /**
     * removes an article from the list of articles to buy
     * @param article the article to remove
     * @return true if successfully removed, false otherwise
     */
    public boolean removeArticle(String article) {
        boolean b = false;
        b = articlesToBuy.remove(article);
        return b;        
    }

    /**
     * buys an article: 
     * moves the article from list of articles to by to bought articles
     * @param article the article to buy
     * @return true if successfully bought, false otherwise
     */
    public boolean buy(String article) {
        boolean b = false;
        String found = findArticle(article);
        if (found != null) {
            boughtArticles.add(found);
            articlesToBuy.remove(found);
            b = true;
        } else {
            b = false;
        }
        return b;         
    }
    
    /**
     * initializes test data
     */
    public void generateTestData() {
        //generate data in articlesToBuy.
        articlesToBuy.add("Milk");
        articlesToBuy.add("Bread");
        articlesToBuy.add("Chicken");
        articlesToBuy.add("Sushi");
        articlesToBuy.add("Mineral water");
        articlesToBuy.add("Apples");
        articlesToBuy.add("Watermelon");      
        //generate data in boughtArticles.
        boughtArticles.add("Meat");
        boughtArticles.add("Tomatoes");
        boughtArticles.add("Potatoes");
        //initialize total amount.
        totalAmount = 30.0;
    }
    
    /**
     * increments total amount
     * @param amount the amount to add
     */
    public void updateAmount(double amount) {
        totalAmount += amount;
    }
    
}
