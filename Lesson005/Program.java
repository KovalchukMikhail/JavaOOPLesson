package Lesson005;

import Lesson005.Model.Entities.Infrastructure;
import Lesson005.View.Input;
import Lesson005.View.Showing;

public class Program {
    public static void main(String[] args) {
        Controller controller = new Controller(new Infrastructure(), new Input(), new Showing());
        controller.run();
    }
}
