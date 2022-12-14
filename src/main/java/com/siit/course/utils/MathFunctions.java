package com.siit.course.utils;

public class MathFunctions {

    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i < n / 2 ; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int compareNumbers(int x, int y) {
        if (x > y) {
            return 1;
        }
        else {
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    public static void compareNum(int a, int b) {
        int compare = compareNumbers(a, b);
        switch (compare) {
            case 0: {
                System.out.println("Number are equal");
                break;
            }
            case 1: {
                System.out.println(a + " is greater than " + b);
                break;
            }
            case -1: {
                System.out.println(a + " is less than " + b);
                break;
            }
            default: {
                System.out.println("Error encountered! ");
            }
        }
    }

    public static boolean isOdd(int n) {
        return n % 2 == 1;
//        return (n % 2 == 1) ? true : false;
    }

    // Cube compute volume
    public static double computeVolume(int vertex) {
        return Math.pow(vertex, 3);
    }

    // Sphere compute volume
    public static double computeVolume(long radius) {
        return 4*Math.PI*Math.pow(radius, 3)/3;
    }

    // Pyramid compute volume
    public static double computeVolume(double baseArea, int height) {
        return baseArea*height/3;
    }

    // Torus compute volume
    public static double computeVolume(int smallRadius, int bigRadius) {
        return Math.PI*Math.pow(smallRadius, 2)*2*Math.PI*bigRadius;
    }

}