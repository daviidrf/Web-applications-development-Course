package cat.proven.StoreApp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David
 */
public class Store {

    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    /**
     * Generate Fake data to test the store.
     */
    public void generateTestData() {

        products.add(new Tv("11","Samsung B4", 200, 15, 65));
        products.add(new Tv("22","Xiaomi G4", 180, 8, 55));
        products.add(new Tv("33","Apple TV", 120, 20, 45));

        products.add(new Fridge("44","North", 200, 15));
        products.add(new Fridge("55","Penguin", 180, 8, 55));
        products.add(new Fridge("66","Frosting", 120, 20, 45));


    }

    /**
     * @return all products from data source or an empty list.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Adds a product to the products list. Prevents null products and
     * duplicates.
     *
     * @param newProd the product to add.
     * @return true if its succesfully added, false otherwise.
     */
    public boolean addProduct(Product newProd) {
        boolean b;

        if (newProd != null) {
            if (!products.contains(newProd)) {
                products.add(newProd);
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
     * Removes a product from the products list.
     *
     * @param remProd the product with the code to reference the product to
     *                remove.
     * @return true if its succesfully removed, false otherwise.
     */
    public boolean removeProduct(Product remProd) {
        boolean b;

        if (remProd != null) {
            if (products.contains(remProd)) {
                products.remove(remProd);
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
     * Search a Product in the list.
     *
     * @param codeProd is the product to find.
     * @return the product found.
     */
    public Product getProduct(String codeProd) {



        if (codeProd != null) {
            if (products.contains(codeProd)) {
                int index = products.indexOf(codeProd);
                if (index != -1) {
                    return products.get(index);
                }
            }
        }
        return null;
    }


    /**
     * @param stock what you want to filter.
     * @return a list of articles below the stock given.
     */
    public List<Product> getPbyStock(int stock) {
        List<Product> articlesToReturn = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getStock() < stock) {
                articlesToReturn.add(products.get(i));
            }
        }
        return articlesToReturn;
    }

    /**
     * @param modProd
     * @return
     */
    public boolean modifyProduct(Product modProd, Product modSearch) {
        boolean b = false;

        if (modProd != null) {
            if (products.contains(modSearch)) {
                int index = products.indexOf(modSearch);
                if (index != -1) {
                    if (!products.contains(modProd)) {
                        products.set(index, modProd);
                        b = true;
                    } else {
                        b = false;
                    }
                }
            } else {
                b = false;
            }
        } else {
            b = false;
        }
        return b;
    }

    public boolean codeExist(String code) {
        boolean found = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equalsIgnoreCase(code)) {
                found = true;
            }
        }
        return found;
    }
}
