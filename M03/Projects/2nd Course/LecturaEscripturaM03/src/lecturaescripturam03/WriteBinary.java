package lecturaescripturam03;

import lecturaescripturam03.model.Employee;
import lecturaescripturam03.model.Staff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class WriteBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //TODO error control. Only implemented Happy Path.

        //Get employee data
        Staff model = new Staff();
        List<Employee> data = model.getStaff();

        //Get file from main args
        String filename = args[0];
        File file = new File(filename);

        //Write data to file and close file
        // Instantiate

        //Report result
    }


}
