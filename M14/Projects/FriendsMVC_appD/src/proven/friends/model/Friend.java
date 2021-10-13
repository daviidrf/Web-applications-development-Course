package proven.friends.model;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Friend {
    private String phone;
    private String name;
    private int age;

    //CONSTRUCTORS
    
    public Friend() {
    }

    public Friend(String phone) {
        this.phone = phone;
    }

    public Friend(String phone, String name, int age) {
        this.phone = phone;
        this.name = name;
        this.age = age;
    }
    
    public Friend(Friend other) {
        this.phone = other.phone;
        this.name = other.name;
        this.age = other.age;
    }
    
    //SETTERS

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    //GETTERS

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    //OTHER FUNCTIONS

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Friend{phone=").append(phone);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.phone);
        return hash;
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
        final Friend other = (Friend) obj;
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }
    
    
    
}
