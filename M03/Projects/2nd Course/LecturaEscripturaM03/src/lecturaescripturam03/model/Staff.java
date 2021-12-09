/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecturaescripturam03.model;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Staff {

    private ArrayList<Employee> staff;

    public Staff() {
        staff = new ArrayList<>();
        initData();
    }

    private void initData() {
        Address add = new Address("P.O. Box 621, 2570 Risus. Av.", 55, 2);
        staff.add(new Employee("1", "Justin", true, 4808.5, add));
        staff.add(new Employee("2", "Austin", false, 51857, add));
        staff.add(new Employee("3", "Jasper", true, 4808.5, add));
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Staff{staff=").append(staff);
        sb.append('}');
        return sb.toString();
    }


}
