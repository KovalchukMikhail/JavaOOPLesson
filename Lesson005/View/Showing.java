package Lesson005.View;

public class Showing {
    public void showStartMenu(){
        System.out.println("Выберети пункт меню:\n"+
                                "1 - Определить площадь прямоугольника\n"+
                                "2 - Определить площадь круга\n"+
                                "0 - для выхода");
    }

    public void showError(){
        System.out.println("Вы ввели некоректные данные");
    }

    public void showResult(Double result){
        System.out.println("Площадь фигуры:\n" + result );
    }

    public void showText(String text){
        System.out.println(text);
    }

    public void showExitMenu(){
        System.out.println("Выберети пункт меню:\n"+
        "1 - для повторного ввода\n"+
        "0 - для выхода");
    }
}
