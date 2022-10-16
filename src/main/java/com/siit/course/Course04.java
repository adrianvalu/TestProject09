package com.siit.course;
import com.siit.course.utils.Circle;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Date;

import static com.siit.course.utils.MathFunctions.*;

public class Course04 {

    public static void drawShapeCorners(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 || i == height -1) && (j == 0 || j == width - 1)) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void drawShapeOutline(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(i == 0 || i == height -1 ) {
                    System.out.print("*");
                }
                else {
                    if (j == 0 || j == width -1) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void drawFullShape(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void drawFullShape(int i) {
        drawFullShape(i, i); // a square is a rectangle with width = height
    }

    // method overloading on parameter type
    public static void drawFullShape(String aaaa, int height) {

    }

    // method overloading on parameter order
    public static void drawFullShape(int height, String aaaa) {

    }

    public static void runCourseCode4() {
        int n = 123456;
        System.out.println("Number " + n + " is prime ? " + isPrimeNumber(n));
        int r = compareNumbers(100, 500);
        compareNum(600, 670);
        System.out.println("Number " + n + " is odd ? " + isOdd(n));
        drawFullShape(3, 5); // rectangle
        drawShapeOutline(7, 13);
        drawShapeCorners(7 , 13);
        drawFullShape("aaaa", 123);
        drawFullShape(5); // square
        int v = 2;
        System.out.println("The volume for a cube with vertex = " + v + " is " + computeVolume(v));
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "Alex";
        p2.name = "Silvia";
        Shape s1 = new Shape();
        s1.colorShape("blue");
        System.out.println("The shape has color " + s1.color);

        Rectangle r1 = new Rectangle(10, 6);
        r1.printRectangle();

        Rectangle r2 = new Rectangle(3, 4);
        r2.printRectangle();

        Rectangle r3 = new Rectangle();
        r3.printRectangle();

        Circle c1 = new Circle(5);
        Circle c2 = new Circle(7);
        Circle c3 = new Circle();
        c1.printCircle();
        c2.printCircle();
        c3.printCircle();

        Person p3 = new Person(
                34,
                'M',
                "Alex",
                171,
                70,
                true,
                new Date(1988, 2, 24)
        );

        p3.eat();
        p3.eat();

        CarBrands dacia = new CarBrands(
                "DACIA",
                new Date(20, 05, 1950),
                "RENAULT",
                "Pitesti",
                p3
        );
        Car car1 = new Car(
                dacia,
                "DUSTER",
                Color.RED,
                "benzina",
                true,
                "1234567890"
        );
        car1.accelerate();
        car1.paintCar(Color.BLUE);
        System.out.println("Car " + car1.model + " with brand " + car1.brand.name);

    }



}