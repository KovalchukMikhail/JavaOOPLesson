package ClassWork001.Task002;

import java.util.Arrays;

public class View {
    /**
     * Запрашивает у пользователя размер и последовательно элементы массива
     * @return массив элементов типа int
     */
    public static int[] data(){
        Input inputInt = new Input();
        int size = inputInt.inputInt("Введите размер массива: ");
        int [] array = new int [size];
        for (int i = 0; i < size; i++) {
            array[i] = inputInt.inputInt("Введите " + i + " элемент массива: ");
        }
        return array;
    }

    /**
     * Выводит в консоль результат вычислений.
     */
    public static void showResult(int[] array){
        int size = array.length;
        for (int i = 0; i < size; i++) {
            System.out.println("Сумма " + (i+1) + " тройки:" + array[i]);
        }
    }
    
    /**
     * Выводит в консоль массив.
     */
    public static void showArray(int [] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void showError(){
        System.out.println("Некорректные входные данные");
    }
}
