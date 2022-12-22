package HomeWork002.DataBase;
import java.util.List;

import HomeWork002.Model.Person;

public class TempTable {
    String path = "HomeWork002/DataBase/TableExample.txt";
    RepositoryUtilities utilities = new RepositoryUtilities();
    List<Person> persons = utilities.getList(path);
    
    public List<Person> getPersons() {
        return persons;
    }
}
