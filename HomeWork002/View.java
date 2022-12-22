package HomeWork002;

public class View {
    public void showMainMenu(){
        System.out.println("Выберети действие\n" +
                            "1 показать весь список людей\n" +
                            "2 показать родителей по id человека\n" +
                            "3 показать бабушек и дедушек по id человека\n" +
                            "4 покзать детей по id человека\n" +
                            "5 показать братьев и сестер по id человека\n" +
                            "6 показать дядей и теть по id человека\n" +
                            "7 показать внуков по id человека\n" +
                            "0 для окончания работы программы\n");
    }

    public void showReturnMenu(){
        System.out.println("Для возврата в главное меню введите 0");
    }

    public void showMenuSelectionId(){
        System.out.println("Для поиска родственников человек, введите его Id: ");
    }

    public void showError(){
        System.out.println("Вы ввели некоректные данные!");
    }

    public void showText(String text){
        System.out.println(text);
    }
}

