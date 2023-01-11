package HomeWork004.Controller;

import java.util.Optional;
import java.util.Scanner;

import HomeWork004.DataBase.TestDb.InitializerDb;
import HomeWork004.Model.Infrastructure;
import HomeWork004.Model.Input;
import HomeWork004.Model.Entities.Chat;
import HomeWork004.Model.Entities.User;
import HomeWork004.View.Menu;

public class MenuController {
    InitializerDb db;
    Menu menu;
    Scanner scanner;
    Input input;
    Infrastructure infrastructure;

    public MenuController(InitializerDb db, Menu menu, Scanner scanner, Input input, Infrastructure infrastructure) {
        this.db = db;
        this.menu = menu;
        this.scanner = scanner;
        this.input = input;
        this.infrastructure = infrastructure;
    }
    
    public User InitializationUser(){
        boolean check = true;
        String requestName = "Введите имя пользователя";
        String requestPassword = "Введите пароль";
        String errorName = "Введенное имя не найдено";
        String errorPassword = "Пароль введен не верно";
        User user = null;     
        while(check){
            menu.showText(requestName);
            String name = input.inputString(scanner).toLowerCase();
            user = infrastructure.selectUser(name);
            if (user == null){
                menu.showText(errorName);
                if(exitFromMenu())check = false;
            }
            else break;
        }
        while(check){
            menu.showText(requestPassword);
            if (user.checkPassword(input.inputString(scanner))) return user;
            else
            {
                menu.showText(errorPassword);
                if(exitFromMenu())check = false;
            }
        }
        return null;
    }

    public User addUser(){
        String requestName = "Введите имя пользователя";
        String requestPassword = "Введите пароль";
        String errorName = "Введенное имя уже занято";
        String errorPassword = "Должен содержать хотябы один символ";
        String password = "";
        User user;
        while(true){
            menu.showText(requestName);
            String name = input.inputString(scanner).toLowerCase();
            user = infrastructure.selectUser(name);
            if (user == null && !name.isEmpty()){
                while(true){
                    menu.showText(requestPassword);
                    password = input.inputString(scanner);
                    if(!password.isEmpty()){
                        user = infrastructure.createUser(name, password);
                        return user;
                    }
                    else{
                        menu.showText(errorPassword);
                        if(exitFromMenu())return null;
                    }
                }
            }
            else{
                menu.showText(errorName);
                if(exitFromMenu())return null;
            }
        }
    }

    public void selectChatMenu(User user){
        Integer answer;
        Integer minValue = 0;
        Integer maxValue = 2;
        while(true){
            menu.showSelectChatMenu();
            answer = selectItemMenu(minValue, maxValue);
            if (answer != null) {
                switch (answer) {
                    case 0:
                        return;
                    case 1:
                        menu.showText(infrastructure.getInfoAllChatsOfUser(user));
                        waitEvent();
                        break;
                    case 2:
                        selectChatById(user);
                        break;
                }
            }  
        }
    }


    public void selectChatById(User user){
        String requestChatId = "Введите id чата";
        String errorChatIdString = "Вы не состоите в чате с таким id";
        while(true){
            menu.showText(requestChatId);
            Integer chatId = input.inputInt(scanner);
            Chat chat = db.getChatById(chatId);
            if (chat != null) {
                ChatController openChat = new ChatController(chat, scanner, menu, input, user, infrastructure, db);
                openChat.startChat();
                return;
            }
            else{
                menu.showText(errorChatIdString);
                if(exitFromMenu())return;
            }
        }
    }

    public Integer selectItemMainMenu(){
        Integer answer;
        Integer minValue = 0;
        Integer maxValue = 3;
        while(true){
            menu.showMainMenu();
            answer = selectItemMenu(minValue, maxValue);
            if (answer != null) return answer;
        }
    }

    public Integer selectItemStartMenu(){
        Integer answer;
        Integer minValue = 0;
        Integer maxValue = 2;
        while(true){
            menu.showStartMenu();
            answer = selectItemMenu(minValue, maxValue);
            if (answer != null) return answer;
        }
    }

    public void SetUserDataMenu(User user){
        menu.showText("Меню в разработке");
        menu.showText("Введите любой символ для возврата в главное меню");
        input.inputString(scanner);
    }

    public Integer selectItemMenu(Integer minValue, Integer maxValue){
        String errorInput= "Вы ввели некоректное значение";
        Integer answer = input.inputInt(scanner);
        if(answer != null || answer >= minValue || answer <= maxValue)return answer;
        else {
            menu.showText(errorInput);
            return null;
        }
    }



    private boolean exitFromMenu(){
        while(true){
            menu.showRepeatMenu();
            Integer answerNum = input.inputInt(scanner);
            if(answerNum != null){
                if(answerNum.equals(0)) return true;
                else if (answerNum.equals(1)) return false;
            }
        }
    }

    private void waitEvent(){
        String text = "для возврата нажмите любую клавишу";
        menu.showText(text);;
        input.inputString(scanner);
    }
}
