package com.siit.course;

import com.siit.course.utils.GeneralUtils;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class Course05 {

    public static void runCourse05(String args[]) {
        double d1 = Double.parseDouble("123.45");
        Person p1 = new Person(34, 'F', "Alexandra", 165, 65, false);
        p1.setBirthday(new Date(1988, Calendar.DECEMBER, 25));
        p1.toString();
        System.out.println("Birthday date is " + p1.getBirthday());
        CarBrands cb = new CarBrands(
                "Seat",
                new Date(1980, Calendar.FEBRUARY, 15),
                "Florin Bucur",
                "Corneliu Balan",
                p1
        );
        Car c1 = new Car(
                cb,
                "Ateca",
                Color.GREEN,
                "diesel",
                true,
                "SEAT1234566778",
                0f,
                100f,
                (byte) 0,
                true,
                45
        );
        c1.printCar();
        c1.paintCar(Color.RED);
        c1.printCar();
        c1.accelerate(20f);
        c1.accelerate();
        c1.printCar();
        c1.gearUp();
        System.out.println("STATIC METHOD CALL !!!");
        GeneralUtils.printCar(c1);

        c1.turnLeft(540);


        Light l1 = new Light();
        l1.dim(20f);
        l1.print();
        l1.turnOn();
        l1.print();
        l1.brighten(1000f);
        l1.print();
        l1.turnOff();

        Shape s1 = new Shape("green");
        s1.draw();
        s1.erase();

        Triangle t1 = new Triangle(10, 20, 30);
        t1.setColor("yellow");
        t1.draw();
        Triangle t2 = new Triangle(24, 36, 57, "red");
        t2.draw();

        Circle circle1 = new Circle(5);
        circle1.setColor("blue");
        circle1.draw();
        System.out.println(t1);

        Square sq1 = new Square(5);
        sq1.printRectangle();
        sq1.draw();
        System.out.println(sq1);

        Shape t3 = new Triangle(17, 45, 62, "white");
        t3.draw();
        Shape r2 = new Rectangle("red", 45, 66);
        r2.draw();

        Person p3 = new Person(25, 'F', "Emilia", 165, 70, true, new Date(), new Square(5) );

    }

}