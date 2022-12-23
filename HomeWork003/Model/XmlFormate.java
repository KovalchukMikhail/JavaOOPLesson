package HomeWork003.Model;

import HomeWork003.Interface.TitleFormat;
import HomeWork003.Items.Person;

public class XmlFormate implements TitleFormat{

    @Override
    public <T extends Person> String createString(T person) {
        return String.format("<xml>\n" +
                            "<Worker>\n" +
                            "<age>%d</age>\n" +
                            "<Firstname>%s</Firstname>\n" +
                            "<Surname>Какое-то имя</Surname>\n" +
                            "</Worker>" +
                            "</xml>", person.getAge(), person.getFirstname(), person.getSurname());
    }
    
}
