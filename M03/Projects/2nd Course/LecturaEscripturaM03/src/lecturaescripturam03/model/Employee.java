package lecturaescripturam03.model;

/**
 *
 * @author David
 */
public class Employee {
    String nif;
    String name;
    boolean senior;
    double salary;
    Address address;

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public boolean isSenior() {
        return senior;
    }

    public double getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public Employee(String nif, String name, boolean senior, double salary, Address address) {
        this.nif = nif;
        this.name = name;
        this.senior = senior;
        this.salary = salary;
        this.address = address;
    }
   
    
}
