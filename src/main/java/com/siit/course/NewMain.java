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

        //Homework 2

        Author author1 = new Author();
        author1.name = "Jane Doe";
        author1.email = "janedoe@gmail.com";

        Author author2 = new Author("John Doe", "joedoe@gmail.com");

        Book book1 = new Book();
        book1.name = "Sunrise";
        book1.year = 1985;
        book1.author = author1;
        book1.price = 58;

        Book book2 = new Book("Sunset", 1978, author2, 64);


        System.out.println("Book " + book1.name + "(" + book1.getPrice() + " RON), by " + author1.name + ", published in " + book1.year + ".");
        System.out.println("Book " + book2.name + "(" + book2.getPrice() + " RON), by " + author2.name + ", published in " + book2.year + ".");
    }

}