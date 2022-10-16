package com.siit.course;

import static com.siit.course.utils.MathFunctions.computeVolume;

public class NewMain {

    public static void main(String[] args) {

        int v = 3;
        System.out.println("The volume for a cube with vertex = " + v + " is " + computeVolume(v));

        long r = 10;
        System.out.println("The volume for a sphere with radius = " + r + " is " + computeVolume(r));

        double b = 4.2;
        int h = 9;
        System.out.println("The volume for a pyramid with baseArea = " + b + " and height = " + h + " is "
                + computeVolume(b,h));

        int r1 = 9;
        int r2 = 12;
        System.out.println("The volume for a torus with smallRadius = " + r1 + " and bigRadius = " + r2 + " is "
                + computeVolume(r1,r2));

    }

}