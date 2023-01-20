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
        Integer size = getInt("Введите размер массива", 0);
        if(size == null) return;
        Integer min = getInt("Введите минимальное возможное значение чисел в массиве");
        if(min == null) return;
        Integer max = getInt("Введите максимальное возможное значение чисел в массиве");
        if(max == null) return;
        else if (max <= min){
            view.showError();
            return;
        }

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
            answer = view.inputInteger();
            if(answer == null) check = askExit();
            else return answer;
        }
        return answer;
    }

    private Integer getInt(String text, int min){
        Integer answer = null;
        boolean check = true;
        while(check){
            view.showText(text);
            answer = view.inputInteger();
            if(answer == null || answer < min) check = askExit();
            else return answer;
        }
        return answer;
    }

    private Integer getInt(String text, int min, int max){
        Integer answer = null;
        boolean check = true;
        while(check){
            view.showText(text);
            answer = view.inputInteger();
            if(answer == null || answer < min || answer > max) check = askExit();
            else return answer;
        }
        return answer;
    }

    private boolean askExit(){
        int answer;
        while(true){
            view.showExitMenu();
            answer = view.inputInteger();
            if(answer == 0) return false;
            else if (answer == 1) return true;
        }
    }
}
