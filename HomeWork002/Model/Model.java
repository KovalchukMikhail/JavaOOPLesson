package HomeWork002.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model {
    Scanner scanner;
    public Model(Scanner scanner){
        this.scanner = scanner;
    }
    public MainMenuEnum getMenuItem(Scanner scanner){
        int current = inputInt(scanner);
        if (current >= 0 && current <8) return MainMenuEnum.values()[current];
        return null;
    }

    public int inputInt(Scanner scanner){
        int result = -1;
            try
            {
                result = scanner.nextInt();
                return result;
            }
            catch (Exception ex)
            {
                scanner.next();
                return result;
            }
    }

    public Person getPersonById(Integer id, List<Person> persons){
        for (Person person : persons) {
            if(person.getId().equals(id)) return person;
        }
        return null;
    }

    public List <Person> getParents(List<Person> persons, Person person){
        List <Person> parents = new ArrayList<>();
        persons.stream().filter(p -> p.getId().equals(person.getFatherId()) || p.getId().equals(person.getMotherId())).
                        forEach(p -> parents.add(p));
        return parents;

    }
    public List <Person> getGrandparents(List<Person> persons, Person person){
        List <Person> parents = getParents(persons, person);
        List <Person> grandparents = new ArrayList<>();
        for (Person parent : parents) {
            getParents(persons, parent).forEach(p -> grandparents.add(p));
        }
        // for (Person parent : parents) {
        //     persons.stream().filter(p -> p.getId().equals(parent.getFatherId()) || p.getId().equals(parent.getMotherId())).
        //     forEach(p -> grandparents.add(p));
        // }
        return grandparents;
    }
    public List <Person> getChildren(List<Person> persons, Person person){
        List <Person> сhildren = new ArrayList<>();
        for (Integer id : person.getSonsId()) {
            persons.stream().filter(p -> p.getId().equals(id) || p.getId().equals(id)).
            forEach(p -> сhildren.add(p));
        }
        for (Integer id : person.getDaughtersId()) {
            persons.stream().filter(p -> p.getId().equals(id) || p.getId().equals(id)).
            forEach(p -> сhildren.add(p));
        }
        return сhildren;
    }
    public List <Person> getBrothersAndSisters(List<Person> persons, Person person){
        List <Person> BrothersAndSisters = new ArrayList<>();
        for (Integer id : person.getBrothersId()) {
            persons.stream().filter(p -> p.getId().equals(id) || p.getId().equals(id)).
            forEach(p -> BrothersAndSisters.add(p));
        }
        for (Integer id : person.getSistersId()) {
            persons.stream().filter(p -> p.getId().equals(id) || p.getId().equals(id)).
            forEach(p -> BrothersAndSisters.add(p));
        }
        return BrothersAndSisters;
    }
    public List <Person> getAuntAndUncle(List<Person> persons, Person person){
        List <Person> parents = getParents(persons, person);
        List <Person> auntsAndUncles = new ArrayList<>();
        for (Person parent : parents) {
            getBrothersAndSisters(persons, parent).stream().forEach(p -> auntsAndUncles.add(p));
        }
        return auntsAndUncles;
    }
    public List <Person> getGrandchilds(List<Person> persons, Person person){
        List <Person> сhildren = getChildren(persons, person);
        List <Person> grandchilds = new ArrayList<>();
        for (Person сhild : сhildren) {
            getChildren(persons, сhild).stream().forEach(p -> grandchilds.add(p));
        }
        return grandchilds;
    }
}
