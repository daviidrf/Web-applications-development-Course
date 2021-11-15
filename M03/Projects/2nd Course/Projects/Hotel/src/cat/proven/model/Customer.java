package cat.proven.model;

public class Customer {
    private String name;
    private String NIF;

    public Customer() {
    }

    public Customer(String NIF) {
        this.NIF = NIF;
    }

    public Customer(String name, String NIF) {
        this.name = name;
        this.NIF = NIF;
    }

    public Customer(Customer other) {
        this.name = other.name;
        this.NIF = other.NIF;
    }
}
