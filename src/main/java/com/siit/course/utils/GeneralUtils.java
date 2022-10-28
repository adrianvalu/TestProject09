package com.siit.course.utils;

import com.siit.course.Car;

public class GeneralUtils {

    public void doSomething() {
        //printCar(new Car());
    }

    public static void printCar(Car c) {
        System.out.println("------------------");
        System.out.println("CAR MODEL " + c.getModel());
        System.out.println("CAR BRAND " + c.getBrand().getName());
        System.out.println("CAR COLOR "  + c.getColor());
        System.out.println("CURRENT SPEED " + c.getCurrentSpeed());
        System.out.println("CURRENT GEAR " + c.getGear());
//        doSomething(); // cannot reference a non-static method from a static method !!!
    }
}
