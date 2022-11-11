package com.siit.course;

public class CustomCourseException extends Exception {

    public CustomCourseException() {
        super();
    }

    public CustomCourseException(String s) {
        super(s);
        System.out.println("MY Exception triggered for " + s);
    }

    public CustomCourseException(String s, int n) {
        super(s);
        if (n < 1000) {
            System.out.println("Exception triggered with message " + s );
        }
    }

    public CustomCourseException(int l1, int l2, int l3, String m) {
        super(m);
        System.out.println("Cannot have a triangle with " + l1 + " and " + l2 + " and "  + l3);
    }

}