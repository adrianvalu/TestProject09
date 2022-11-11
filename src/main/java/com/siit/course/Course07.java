package com.siit.course;

import com.sun.security.jgss.GSSUtil;

import java.awt.*;

public class Course07 {

    public static void infiniteLoop(int index) {
        index++;
        infiniteLoop(index);
    }

    public static void runCourse07(String[] args) {
//        infiniteLoop(0);
        if (args.length < 1) {
            throw new IllegalArgumentException("This is an exception");
        }
        System.out.println(args[0]);
        System.out.println("Course 07");

        Circle c1 = new Circle(5);
        c1.printCircle();
        try {
            c1.setRadius(-100);
        }
        catch (IllegalArgumentException iae) {
            System.out.println("We found an exception while setting the radius to -100");
        }
        c1.printCircle();
        System.out.println("----------");
        try {
            Circle c2 = new Circle(5);
            c2.printCircle();
//            System.out.println(args[100]);
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        catch(NullPointerException nex) {
            System.out.println("This is the null pointer exception");
        }
        catch(ArrayIndexOutOfBoundsException aob) {
            System.out.println(aob.getMessage());
        }
        catch (Exception ex) {
            System.out.println("This is the general exception!");
        }
        finally {
            System.out.println("This block executes always (with or without exception)");
        }
        System.out.println("--------");
        System.out.println("We are continuing running the app");


        try {
            String test = "abc12";
            Double d = Double.parseDouble(test);
            Double d2 = Double.parseDouble(args[1]);
            double sum = d + d2;
            System.out.println(sum);
        }
        catch (NullPointerException  | NumberFormatException  ex) {
            System.out.println("The parsing failed because the input is null or cannot extract a number ");
            System.out.println(ex.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException aob) {
            System.out.println(aob.getMessage());
        }
        System.out.println("------");
        try {
            Triangle t1 = new Triangle(12, 5, 1, "Color.RED");
        } catch (CustomCourseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------");
        Double d2 = Double.parseDouble(args[1]);
        Circle c3 = new Circle();
        c3.setRadius(-5);



    }

}