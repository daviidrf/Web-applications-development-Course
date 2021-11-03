package cat.proven.StoreApp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
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

        products.add(new Product("11", "Placa Base", 80, 10));
        products.add(new Product("22", "Procesador", 50, 10));
        products.add(new Product("33", "Memória RAM", 30, 10));
        products.add(new Product("44", "Tarjeta Gráfica", 100, 10));
        products.add(new Product("55", "Disco Duro", 60, 10));
    }

    /**
     *
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
     * @param remProd the product with the code to refrence the product to
     * remove.
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

}
