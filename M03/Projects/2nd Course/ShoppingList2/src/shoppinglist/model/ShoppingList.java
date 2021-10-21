/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinglist.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class ShoppingList {

    private List<String> articlesToBuy;
    private List<String> articlesBought;
    private double totalAmount;

    public ShoppingList() {
        this.articlesToBuy = new ArrayList<>();
        this.articlesBought = new ArrayList<>();
        this.totalAmount = 0;
    }

    public List<String> getArticlesToBuy() {
        return articlesToBuy;
    }

    public List<String> getArticlesBought() {
        return articlesBought;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void generateTestData() {
        //Generate data in articlesToBuy
        this.articlesToBuy.add("Milk");
        this.articlesToBuy.add("Bread");
        this.articlesToBuy.add("Potatoes");
        this.articlesToBuy.add("Apples");
        this.articlesToBuy.add("Water");

        //Generate data in articlesBought
        this.articlesBought.add("Sushi");
        this.articlesBought.add("Bananas");

        //Generate an amount to the Bought Articles.
        this.totalAmount = 20;
    }

}
