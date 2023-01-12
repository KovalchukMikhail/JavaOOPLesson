package Lesson005.Model.Entities;

import java.sql.SQLInvalidAuthorizationSpecException;

public class Quadrilateral implements Entity{
    private Double lenthX;
    private Double lenthY;

    public Quadrilateral(Double lenthX, Double lenthY) {
        this.lenthX = lenthX;
        this.lenthY = lenthY;
    }

    public void setLenthX(Double lenthX) {
        if(lenthX > 0)this.lenthX = lenthX;
        else this.lenthX = null;
    }

    public void setLenthY(Double lenthY) {
        if(lenthY > 0)this.lenthY = lenthY;
        else this.lenthY = null;
    }

    public Double getLenthX() {
        return lenthX;
    }

    public Double getLenthY() {
        return lenthY;
    }

    @Override
    public Double getSquare() {
        if(lenthX != null && lenthY != null) return lenthX * lenthY;
        return null;
    }
    
}
