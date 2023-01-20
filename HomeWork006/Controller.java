package HomeWork006;

import HomeWork006.Interfases.Model;
import HomeWork006.Interfases.View;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void start(){
        Integer size = getInt("Введите размер массива");
        if(size == null) return;
        Integer min = getInt("Введите минимальное возможное значение чисел в массиве");
        if(min == null) return;
        Integer max = getInt("Введите максимальное возможное значение чисел в массиве");
        if(max == null) return;

        int[] array = model.сreatArray(min, max, size);
        view.showText("Исходный массив");
        view.showArray(array);

        model.sortingArray(array);
        view.showText("Отсортированный массив");
        view.showArray(array);
    }

    private Integer getInt(String text){
        Integer answer = null;
        boolean check = true;
        while(check){
            view.showText(text);
            answer = view.inputInt();
            if(answer == null) check = askExit();
            else return answer;
        }
        return answer;
    }

    private boolean askExit(){
        int answer;
        while(true){
            view.showExitMenu();
            answer = view.inputInt();
            if(answer == 1) return false;
            else if (answer == 0) return true;
        }
    }
}
