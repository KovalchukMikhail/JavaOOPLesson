package HomeWork006;

import java.util.Scanner;

import HomeWork006.Interfases.View;

public class StandartView implements View{
    Scanner scanner;

    public StandartView(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public void showArray(int [] array) {
        {
            System.out.print("[");
            for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + " ");
            }
            System.out.println("]");
        }
    }

    @Override
    public void showText(String text) {
        System.out.println(text);
        
    }

    @Override
    public void showError() {
        System.out.println("Вы ввели некоректные данные"); 
    }

    @Override
    public Integer inputInteger() {
        Integer num;
        try
        {
            num = Integer.valueOf(this.scanner.next());
        }
        catch (Exception e)
        {
            num = null;
        }
        return num;
    }

    public void showExitMenu(){
        System.out.println("Выберети пункт меню:\n"+
        "1 - для повторного ввода\n"+
        "0 - для выхода");
    }
}
