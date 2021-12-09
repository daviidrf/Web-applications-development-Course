package lecturaescripturam03;

import lecturaescripturam03.model.Employee;
import lecturaescripturam03.model.Staff;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class WriteCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Staff staff = new Staff();
        toCSV(staff.getStaff());
    }

    private static void toCSV(ArrayList<Employee> staff) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("employees.txt"));
            for (Employee emp : staff) {
                String empCSV = formatCSV(emp, ";");
                bw.write(empCSV + "\n");
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println("Input or output problem related to this exception:");
            ex.printStackTrace();
        }

    }

    public static String formatCSV(Employee obj, String delimiter) {
        return String.format("%s%s %s%s %b%s %f%s %s%s %x%s %x",
                obj.getNif(), delimiter, obj.getName(), delimiter, obj.isSenior(),
                delimiter, obj.getSalary(), delimiter, obj.getAddress().getStreet(),
                delimiter, obj.getAddress().getNumber(), delimiter, obj.getAddress().getFloor());
    }
}
