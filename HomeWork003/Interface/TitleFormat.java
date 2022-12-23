package HomeWork003.Interface;

import HomeWork003.Items.Person;

public interface TitleFormat {
    public <T extends Person> String createString(T person);
}
