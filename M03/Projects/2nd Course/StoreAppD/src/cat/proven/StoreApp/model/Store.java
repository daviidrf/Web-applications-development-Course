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
        
        products.add(new Product("11","Placa",80,10));
        products.add(new Product("22","Procesador",50,10));
        products.add(new Product("33","RAM",30,10));
        products.add(new Product("44","Grafica",100,10));
        products.add(new Product("55","Disco",60,10));
    }
    
    /**
     * 
     * @return all products from data source or an empty list.
     */
    public List<Product> getProducts() {
        return products;
    }

    

    

    
    
}
