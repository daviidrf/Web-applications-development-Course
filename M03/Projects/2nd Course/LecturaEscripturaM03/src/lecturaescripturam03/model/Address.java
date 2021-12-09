package lecturaescripturam03.model;

/**
 *
 * @author David
 */
public class Address {
    String street;
    int number;
    int floor;

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public Address(String street, int number, int floor) {
        this.street = street;
        this.number = number;
        this.floor = floor;
    }
    
}
