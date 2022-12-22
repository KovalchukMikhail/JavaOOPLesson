package HomeWork002;

import java.util.List;
import java.util.Scanner;

import javax.swing.SortingFocusTraversalPolicy;

import HomeWork002.Model.Model;
import HomeWork002.Model.Person;
import HomeWork002.Model.MainMenuEnum;
import HomeWork002.DataBase.TempTable;

public class Controller {
    public static void run(){
        TempTable table = new TempTable();
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        Model model = new Model(scanner);
        Person person = null;
        List <Person> persons = table.getPersons();
        boolean check = true; 
        while(check){
            view.showMainMenu();
            try {
                MainMenuEnum menuItem = model.getMenuItem(scanner);
                if(!menuItem.equals(MainMenuEnum.none) && !menuItem.equals(MainMenuEnum.all)){
                    boolean checkInput = false;
                    while(!checkInput){
                        view.showMenuSelectionId();
                        Integer id = model.inputInt(scanner);
                        person = model.getPersonById(id, persons);
                        if(person != null || id.equals(0)) checkInput = true;
                        else view.showError();
                    }
                    if (person == null) continue;
                }
                
                String text = "";
                switch (menuItem) {
                    case all:
                        persons.stream().forEach(p -> System.out.println(p.toString()));
                        break;
                    case parents:
                        view.showText("Родители " + person.toString() + ":\n");
                        text = model.getParents(persons, person).toString();
                        view.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case grandparents:
                        view.showText("Бабушки и дедушки " + person.toString() + ":\n");
                        text = model.getGrandparents(persons, person).toString();
                        view.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case children:
                        view.showText("Дети " + person.toString() + ":\n");
                        text = model.getChildren(persons, person).toString();
                        view.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case brothersAndSisters:
                        view.showText("Братья и сестры " + person.toString() + ":\n");
                        text = model.getBrothersAndSisters(persons, person).toString();
                        view.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case auntAndUncle:
                        view.showText("Дяди и тети " + person.toString() + ":\n");
                        text = model.getAuntAndUncle(persons, person).toString();
                        view.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case grandchild:
                        view.showText("Внуки " + person.toString() + ":\n");
                        text = model.getGrandchilds(persons, person).toString();
                        view.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case none:
                        check = false;
                        break;
                }
                if (check){
                    view.showReturnMenu();
                    while(model.inputInt(scanner) != 0);
                }
                
                
            } catch (Exception e) {
                
            }
            
        } 
        scanner.close();  
    }
}
