package lecturaescripturam03.model.persist;

import lecturaescripturam03.model.Employee;

import java.io.File;
import java.util.List;

public class PersistEmployeeCSV implements PersistEmployeeInterface {
    @Override
    public int writeEmployees(File file, List<Employee> data) {
        return 0;
    }

    @Override
    public List<Employee> readEmployees(File file) {
        return null;
    }
}
