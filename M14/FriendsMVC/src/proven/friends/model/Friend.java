package proven.friends.model;

import java.util.Objects;

/**
 * <strong>Friend.java</strong>
 * ADT for a friend.
 */
public class Friend {
    private String phone;
    private String name;
    private int age;

    public Friend(String phone, String name, int age) {
        this.phone = phone;
        this.name = name;
        this.age = age;
    }

    public Friend() {
    }
    
    public Friend(String phone) {
        this.phone = phone;
    }  

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.phone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if (obj==null) { //null object
            b = false;
        } else {
            if (this==obj) {  //same object
                b = true;
            } else {
                if (obj instanceof Friend) {
                    Friend other = (Friend) obj;
                    b = (this.phone.equals(other.phone));
                } else {
                    b = false;
                }
            }
        }
        return b;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Friend{");
        sb.append("phone="); sb.append(phone);
        sb.append(";name="); sb.append(name);
        sb.append(";age="); sb.append(age);
        sb.append("}");
        return sb.toString();
    }
    
}