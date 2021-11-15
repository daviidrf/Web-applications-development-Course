package cat.proven.StoreApp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David
 */
public class Store {

    private final List<Product> products;

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

        products.add(new Fridge("44","North", 300, 24, 30, true));
        products.add(new Fridge("55","Penguin", 280, 3, 42, false));
        products.add(new Fridge("66","Frosting", 220, 13, 50, true));
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
     * @return true if its successfully added, false otherwise.
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
     * @return true if its successfully removed, false otherwise.
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

        for (Product product : products) {
            if (product.getCode().equalsIgnoreCase(codeProd)) {
                return product;
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

        for (Product product : products) {
            if (product.getStock() < stock) {
                articlesToReturn.add(product);
            }
        }
        return articlesToReturn;
    }

    /**
     * @param modProd the new product values.
     * @param modSearch the old product to search.
     * @return true if the product is modified or false otherwise.
     */
    public boolean modifyProduct(Product modProd, Product modSearch) {

        if (modProd != null) {
            if (products.contains(modSearch)) {
                int index = products.indexOf(modSearch);
                if (index != -1) {
                    products.set(index, modProd);
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return false;
    }

    /**
     * @param code to search if exists.
     * @return true if code exist or false otherwise.
     */
    public boolean codeExist(String code) {
        boolean found = false;
        for (Product product : products) {
            if (product.getCode().equalsIgnoreCase(code)) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * @param typeGiven the type of the products to filter.
     * @return a list of the products with the given type.
     */
    public List<Product> getProductsByType(String typeGiven) {
        List<Product> yourType = new ArrayList<>();

        for (Product product : products) {
            if (product.getClass().getSimpleName().equalsIgnoreCase(typeGiven)) {
                yourType.add(product);
            }
        }
        return yourType;
    }
}
