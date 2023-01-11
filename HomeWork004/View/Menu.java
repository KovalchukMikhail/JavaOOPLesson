package HomeWork004.View;

public class Menu {
    public void showText(String Text){
        System.out.println(Text);
    }

    public void showMainMenu(){
        System.out.println("Введите номер пункта меню:\n" +
                            "1 - выбрать чат\n" +
                            "2 - создать чат\n" +
                            "3 - изменить личные данные\n" +
                            "0 - выход");
    }

    public void showSelectChatMenu(){
        System.out.println("Введите номер пункта меню:\n" +
                            "1 - показать все мои чаты\n" +
                            "2 - выбрать чат по id чата\n" +
                            "0 - выход");
    }

    public void showChatMenu(){
        System.out.println("Введите номер пункта меню:\n" +
                            "1 - войти в чат\n" +
                            "2 - добавить пользователя в чат\n" +
                            "0 - выход");
    }

    public void showStartMenu(){
        System.out.println("Введите номер пункта меню:\n" +
                            "1 - войти (если у Вас уже есть аккаунт)\n" +
                            "2 - добавить пользователя\n" +
                            "0 - выход");
    }

    public void showRepeatMenu(){
        System.out.println("Введите номер пункта меню:\n" +
                            "1 - повторный ввода\n" +
                            "0 - выход");
    }
}
