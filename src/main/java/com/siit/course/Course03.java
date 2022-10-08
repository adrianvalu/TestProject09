package com.siit.course;

public class Course03 {

    static int x = 0;

    public static void main(String[] args) {
     /*   final double PI = 3.14;
        final int MAX_SIZE = 100; // naming convention all uppercase split by _
        int y = 100; // primitive
        String name = "Alex";
        char myChar = 'a';
        y = y + 5; // y += 5;

//        PI = 1.34;
        float a = 100.4f;
        double b = 100.4;

        boolean myBool = true;
        char myChar2 = 97;

        Integer i1 = 100; // wrapper object on top of int primitive

        System.out.println("Hello course 03!!");
        System.out.println(name);
        System.out.println("My name is " + name);

        System.out.println(args[0] + " " +  args[1]);
        System.out.println(args[0] + args[1]);
        System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
//        System.out.println(args[2]);
        System.out.println(myChar2);
        System.out.println( 500 / 3);
        System.out.println( 500 / 3.0);

        if ( x > 5 ) {
            System.out.println("Number is greater than 5");
        }

        if (y < MAX_SIZE) {
            System.out.println("Number is less than " + MAX_SIZE);

        }
        else {
            System.out.println("Number exceeds the max size of " + MAX_SIZE);
        }

        switch (y) {
            case 0: { // y == 0 --> TRUE
                System.out.println("Number is 0");

                break;
            }
            case 1: { // y == 1 --> TRUE
                System.out.println("Number is 1");

                break;
            }
            default: {
                System.out.println("Not 0 not 1 ");

            }
        }
        // while example
        int index = 0;
        while(myBool) {
            System.out.println("WHILE Infinite loooop !!!! " + index);
            if (index > 10) {
                myBool = false;
            }
            index++;
        }
        // do while example
        myBool = true;
        index = 0;
        do {
            System.out.println("DO WHILE Infinite loooop !!!! " + index);
            if (index > 10) {
                myBool = false;
            }
            index++;
        }
        while (myBool);

        index = 0;
        // rewrite whithout myBool
        do {
            System.out.println("DO WHILE Infinite loooop !!!! " + index);
            if (index > 10) {
                break;
            }
            index++;
        }
        while (true);

        for (index = 0 ; index <= 10 ; index++) {
            System.out.println("FOR Infinite loooop !!!! " + index);
        }

        for (index = 0 ; index < args.length; index++) {
            System.out.println(args[index]);
        }

        for (String s : args) { // for each value from the array element by element, equivalent to foreach
            System.out.println(s);
        }

        for (char c : name.toCharArray()) {
            System.out.println(c);
        }

        int sum = 0;
        for (int i = 1 ; i <= MAX_SIZE ; i++) {
            sum = sum + i; // sum += i;
        }
        System.out.println("Suma este " + sum);

        System.out.println("Suma este " + (MAX_SIZE * (MAX_SIZE + 1))/ 2);

        final int MAX_NUMBER = 1000000;
        int countPrime = 0;
        for (int i = 2; i < MAX_NUMBER; i++) {
            // i is the current number we test if it is prime :)
            boolean isPrime = true;
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.println("Number " + i + " is prime");
                countPrime++;
            }
//            else {
//                System.out.println("Number " + i + " is not prime!");
//            }
        }
        System.out.println("Total number of primes are " + countPrime); */


//      Homework

//  Implement an arithmetic calculator that takes 3 arguments: the first
//  number, the operation, the second number.


        if (args.length == 3) {
            float result = 0;
            float a = Float.parseFloat(args[0]);
            float b = Float.parseFloat(args[2]);
            String operator = args[1];
// implement calculator logic here
            switch (operator) {
                case "+":
                    result = a + b;
                    System.out.println("Result is: " + result);
                    break;
                case "*":
                    result = a * b;
                    System.out.println("Result is: " + result);
                    break;
                case "/":
                    result = a / b;
                    System.out.println("Result is: " + result);
                    break;
                case "-":
                    result = a - b;
                    System.out.println("Result is: " + result);
                    break;
                default:
                    System.out.println("The second argument is not an arithmetic operator!");
            }

        }
        else {
            System.err.println("3 args are needed!");
        }




//        Display the number of days in month February from a year
//          between 1900-2016 that is read from keyboard

        ;
        int year = Integer.parseInt(args[0]);
        if (1900 <= year && year <= 2016) {
            if (year % 4 == 0 && year % 100 != 0) {
                System.out.println("February had 29 days in " + year + ".");
            } else {
                if (year % 100 == 0 && year % 400 == 0) {
                    System.out.println("February had 29 days in " + year + ".");
                } else {
                    System.out.println("February had 28 days in " + year + ".");
                }
            }
        } else {
            System.out.println("Input year must be between 1900 and 2016");
        }


    }
}




