package com.siit.course;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Circle extends Shape {

    private int radius;

    public Circle(int radius) {
        setRadius(radius);
    }

    public Circle() {
    }

    public void setRadius(int radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("The radius is " + radius + " but the radius should be a positive number!!!");
        }
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public void printCircle() {
        System.out.println("Circle with radius " + radius + " has area " + getArea() + " and length " + getLength() );
    }

    @Override
    public void draw() {
        super.draw("CIRCLE");
    }

}