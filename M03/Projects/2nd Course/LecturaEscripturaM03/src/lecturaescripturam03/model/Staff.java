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

    private ArrayList<Employee> employees;

    public Staff() {
        employees = new ArrayList<>();
        initData();
    }

    private void initData() {
        Address add = new Address("P.O. Box 621, 2570 Risus. Av.", 55, 2);
        employees.add(new Employee("1", "Justin", true, 4808.5, add));
        employees.add(new Employee("2", "Austin", false, 51857, add));
        employees.add(new Employee("3", "Jasper", true, 4808.5, add));
    }

    public ArrayList<Employee> getStaff() {
        return employees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Staff{staff=").append(employees);
        sb.append('}');
        return sb.toString();
    }


}
