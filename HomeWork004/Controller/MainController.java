package HomeWork004.Controller;

import java.util.Scanner;


import HomeWork004.DataBase.TestDb.InitializerDb;
import HomeWork004.Model.Infrastructure;
import HomeWork004.Model.Input;
import HomeWork004.Model.Entities.Chat;
import HomeWork004.Model.Entities.User;
import HomeWork004.View.Menu;

public class MainController {
    public static void run(){
        InitializerDb db = new InitializerDb();
        Infrastructure infrastructure = new Infrastructure(db);
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in, "Cp866");
        Input input = new Input();
        MenuController menuController = new MenuController(db, menu, scanner, input, infrastructure);
        Integer answer = menuController.selectItemStartMenu();
        User user = null;
        switch (answer) {
            case 0:
                return;
            case 1:
                user = menuController.InitializationUser();
                break;
            case 2:
                user = menuController.addUser();
                break;
        }
        if(user == null) return;
        while (true){
            answer = menuController.selectItemMainMenu();
            switch (answer) {
                case 0:
                    return;
                case 1:
                    menuController.selectChatMenu(user);
                    break;
                case 2:
                    Chat chat = infrastructure.createChat(user);
                    ChatController openChat = new ChatController(chat, scanner, menu, input, user, infrastructure, db);
                    openChat.startChat();
                    break;
                case 3:
                    menuController.SetUserDataMenu(user);
                    break;
            }
        }


    }
}
