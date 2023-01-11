package HomeWork004.Test;

import java.util.Scanner;

import HomeWork004.Controller.MenuController;
import HomeWork004.DataBase.TestDb.InitializerDb;
import HomeWork004.Model.Input;
import HomeWork004.View.Menu;

public class test {
    public static void main(String[] args) {
        InitializerDb db = new InitializerDb();
        System.out.println(db.getAllChats().toString());
        // Menu menu = new Menu();
        // Scanner scanner = new Scanner(System.in, "Cp866");
        // Input input = new Input();

        // MenuController menuController = new MenuController(db, menu, scanner, input);
        // System.out.println(menuController.InitializationUser().toString());
    }
}
