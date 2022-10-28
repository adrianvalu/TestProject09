package com.siit.course;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Rectangle extends Shape{

    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle() {
        height = 1 ;
        width = 1;
    }

    public Rectangle (int h) {
        height = h;
    }

    public int computeArea() {
        return this.height * this.width;
    }

    public int computePerimeter() {
        return 2 * ( height + width);
    }

    public double computeDiagonal() {
        return Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
    }

    public void printRectangle() {
        System.out.println("Area is " + computeArea());
        System.out.println("Perimeter is " + computePerimeter());
        System.out.println("Diagonal is " + computeDiagonal());
    }

    public Rectangle(String color, int height, int width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        super.draw("RECTANGLE");
    }
}
