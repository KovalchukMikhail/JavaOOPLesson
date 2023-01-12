package Lesson005.Model.Entities;

public class Circle implements Entity{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public void setRadius(Double value){
        if(value > 0) this.radius = value;
        else this.radius = null;
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public Double getSquare() {
        if(this.radius != null) return Math.PI * Math.pow(radius, 2);
        return null;
    }
    
}
