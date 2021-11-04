package cat.proven.StoreApp.model;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Product {

    private String code;
    private String name;
    private double price;
    private int stock;

    //CONSTRUCTORS
    public Product() {
    }

    public Product(String code) {
        this.code = code;
    }

    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(Product other) {
        this.code = other.code;
        this.name = other.name;
        this.price = other.price;
        this.stock = other.stock;
    }

    //GETTERS & SETTERS
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Code --> ").append(code);
        sb.append(" / Name --> ").append(name);
        sb.append(" / Price --> ").append(price);
        sb.append(" / Stock -->").append(stock);
        return sb.toString();
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
    
}
