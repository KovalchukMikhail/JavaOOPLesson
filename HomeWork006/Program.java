// Реализовать алгоритм сортировки массива слиянием

package HomeWork006;

import java.util.Scanner;

import HomeWork006.Interfases.Model;
import HomeWork006.Interfases.View;



public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Cp866");
        Model model = new StandartModel();
        View view = new StandartView(scanner);
        new Controller(model, view).start();
    }
}
