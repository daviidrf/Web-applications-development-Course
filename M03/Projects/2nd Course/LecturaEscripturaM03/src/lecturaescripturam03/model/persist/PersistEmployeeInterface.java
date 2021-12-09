package lecturaescripturam03.model.persist;

import lecturaescripturam03.model.Employee;

import java.io.File;
import java.util.List;

public interface PersistEmployeeInterface {
    public int writeEmployees(File file, List<Employee> data);

    public List<Employee> readEmployees(File file);
}
