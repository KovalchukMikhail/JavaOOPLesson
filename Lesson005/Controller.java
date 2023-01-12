package Lesson005;


import Lesson005.Model.Entities.Circle;
import Lesson005.Model.Entities.Entity;
import Lesson005.Model.Entities.Infrastructure;
import Lesson005.Model.Entities.Quadrilateral;
import Lesson005.View.Input;
import Lesson005.View.Showing;

public class Controller {
    Infrastructure model;
    Input input;
    Showing view;

    public Controller(Infrastructure model, Input input, Showing view) {
        this.model = model;
        this.input = input;
        this.view = view;
    }

    public void run(){
        Entity entity = null;
        boolean check = true;
        while(check){
            view.showStartMenu();
            Integer answer = input.InputInt();
            if (answer != null){
                switch (answer) {
                    case 0:   
                        return;
                    case 1:
                        entity = getQuadrilateral();
                        check = false;
                        break;
                    case 2:
                        entity = getCircle();
                        check = false;
                        break;
                    default:
                        view.showError();
                        break;
                }
            }
        }
        if(entity == null) return;
        view.showResult(entity.getSquare());

    }

    private Quadrilateral getQuadrilateral(){
        while(true){
            view.showText("Введите длину превой стороны прямоугольника");
            Double lenthX = input.inputDouble();
            view.showText("Введите длину второй стороны прямоугольника");
            Double lenthY = input.inputDouble();
            Quadrilateral quadrilateral = model.createQuadrilateral(lenthX, lenthY);
            if(quadrilateral != null) return quadrilateral;
            view.showError();
            if(askExit()) return null;
        }

    }

    private Circle getCircle(){
        while(true){
            view.showText("Введите радиус круга");
            Double radius = input.inputDouble();
            Circle circle = model.createCircle(radius);
            if(circle != null) return circle;
            view.showError();
            if(askExit()) return null;
        }
    }

    private boolean askExit(){
        int answer;
        while(true){
            view.showExitMenu();
            answer = input.InputInt();
            if(answer == 1) return false;
            else if (answer == 0) return true;
        }
        
    }
}

