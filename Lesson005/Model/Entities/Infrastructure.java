package Lesson005.Model.Entities;

public class Infrastructure {
    public Quadrilateral createQuadrilateral(Double lenthX, Double lenthY){
        if(lenthX != null && lenthY != null && lenthX > 0 && lenthY > 0) return new Quadrilateral(lenthX, lenthY);
        return null;
    }

    public Circle createCircle(Double radius){
        if(radius != null && radius > 0 ) return new Circle(radius);
        return null;
    }
}
