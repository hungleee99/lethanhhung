/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment5.Encapsulation;

/**
 *
 * @author admin
 */
public class Circle {
    public double radius ;
    public String color ;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = 1.0;
        this.color = "red";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", color=" + color + '}';
    }
    public double getArea() {
        return radius;
    }
    
    
    
}
