package cat.proven.StoreApp.model;

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
        sb.append("\nCode --> ").append(code);
        sb.append("\nName --> ").append(name);
        sb.append("\nPrice --> ").append(price);
        sb.append("\nStock --> ").append(stock);
        return sb.toString();
    }
    
    
}
