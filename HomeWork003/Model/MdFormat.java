package HomeWork003.Model;

import HomeWork003.Interface.TitleFormat;
import HomeWork003.Items.Person;

public class MdFormat implements TitleFormat{

    @Override
    public <T extends Person> String createString(T person) {
        return String.format("# worker:\n" +
                            "* age: %d,\n" +
                            "* Firstname: %s,\n" +
                            "* Surname: %s", person.getAge(), person.getFirstname(), person.getSurname());
    }
    
}
