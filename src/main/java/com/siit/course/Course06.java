package com.siit.course;

import java.lang.reflect.Array;
import java.util.*;

public class Course06 {

    public static void printHashMap(HashMap<Character, Integer> hm) {
        for (Character c : hm.keySet()) {
            System.out.println(c + " : " + hm.get(c) );
        }
        System.out.println(hm);
    }
    private static int addEvenPositions(int[] arr) {
        int sum = 0;
        for (int i = 0 ; i< arr.length; i+= 2 ) {
            sum += arr[i];
        }
        return sum;
    }

    public static ArrayList<String> convertArrayToList(String[] arg) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, arg);
        return list;
    }

    public static HashSet<String> getUniqueWords(String phrase) {
        HashSet<String> uniqueWords = new HashSet<>();
        String[] words = phrase.split(" "); // split the phrase into words based on spaces
//        Collections.addAll(uniqueWords, words);
        for (String word : words) {
            uniqueWords.add(word.toLowerCase(Locale.ROOT));
        }
        return  uniqueWords;
    }

    public static HashMap<Character, Integer> getAllCharsCount(String phrase) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (Character c: phrase.toLowerCase(Locale.ROOT).toCharArray()) {
            if(charMap.containsKey(c)) { // character already exists in the hashmap
                charMap.replace(c, charMap.get(c) + 1); // increment the value of the hashmap with 1
            }
            else { // character does not exist already in the map
                charMap.put(c, 1);
            }
        }
        return charMap;
    }

    public static void runCourse06() {
        int[] arrayInt = {1, 5, 9};
        String[] arrayString = {"Alex", "are", "prune"};
        Person[] arrayPerson = {
                new Person(),
                new Person(70, 'M', "Andrei", 171, 80, true)
        };

        Person[] arr2 = new Person[5];
        arr2[4] = new Person();
        System.out.println(arr2[4]);

        for (String s : arrayString) {
            System.out.println(s);
        }
        System.out.println(addEvenPositions(arrayInt));

        ArrayList arr3 = new ArrayList();
        List arr4 = new ArrayList();
        ArrayList<String> names = new ArrayList<>();
        names.add("Alex");
        names.add("Andreea");
        names.add("Bianca");
        System.out.println(names.size());
        ArrayList<String> names2 = new ArrayList<>();
        names2.add("Andrei");
        ArrayList<String> names3 = new ArrayList<>();
        names3.addAll(names);
        names3.addAll(names2);
        ArrayList<String> names4 = (ArrayList<String>) names3.clone();
        names4.add("Ioana");
        if (names3.contains("Alex")) {
            System.out.println("Alex is part of the team");
        } else {
            System.out.println("Alex is not part of the team");
        }
        if (names3.equals(names4)) { // Use this to compare 2 lists - element by element
            System.out.println("Collection is the same");
        }
        else {
            System.out.println("Collections are different");
        }
        ArrayList<String> names5 = names4;
        System.out.println(names3.indexOf("Alex"));
        System.out.println(names3.get(0));
        names3.set(0, "AALEX"); // update a value on a specific index / position

        // Conversion between list and array
        String[] arr5 = new String[names4.size()];
        arr5 = names4.toArray(arr5);
        System.out.println(arr5);
        for (String s : arr5) {
            System.out.println(s);
        }

        // Convert from Vector to ArrayList
        ArrayList<String> newList = convertArrayToList(arr5);
        ArrayList<String> newList2 = new ArrayList<>(Arrays.asList(arr5));

        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Triangle(4, 5, 7));
        shapeList.add(new Circle(5));

//        shapeList.remove(0);
        for (Shape s : shapeList) {
            s.draw();
        }

        // not recommended
        Iterator it = shapeList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        ArrayList<Triangle> triangleList = new ArrayList<>();
        ArrayList<Circle> circleList = new ArrayList<>();

        HashSet<String> myHashSet = new HashSet<>();
        myHashSet.add("Alex");
        myHashSet.add("Andreea");
        myHashSet.add("Alex"); // this will not be added as it is duplicated
        for ( String s : myHashSet) {
            System.out.println(s);
        }

        String phrase = "Through Java Collections API we have set of classes and interfaces providing collections of " +
                "objects with more advanced behavior than arrays";
        for (String word : getUniqueWords(phrase)) {
            System.out.println(word);
        }

        HashMap<Integer, String> namesIndex = new HashMap<>();
        namesIndex.put(10, "Alex");
        namesIndex.put(7, "Andreea");
        for (Integer key : namesIndex.keySet()) {
            System.out.println(key + " : " + namesIndex.get(key));
        }

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        hashMap1 = getAllCharsCount("Through Java Collections API we have set of classes and interfaces providing collections of");
        printHashMap(hashMap1);

        Queue<Integer> q = new LinkedList<>();
        q.add(56);
        q.add(101);
        q.add(69);
        q.add(23);
        System.out.println(q);
        int qh = q.remove();
        System.out.println(qh);
        System.out.println(q);

        ArrayList<String> browsers = new ArrayList<>() {
            {
                add("Firefox");
                add("Chrome");
                add("Edge");
            }
        };
        System.out.println(browsers.get(0));
        System.out.println(Browsers.FIREFOX);
        if (browsers.get(0).compareToIgnoreCase(Browsers.FIREFOX.toString()) == 0) {
            System.out.println("Browser are the same " + Browsers.FIREFOX);
        }

        HashMap<String, ArrayList<FacultyCourse>> facultyOffer = new HashMap<>();
        ArrayList<FacultyCourse> courses01 = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());
        students.add(new Student());
        students.add(new Student());
        students.add(new Student());
        courses01.add(
                new FacultyCourse(
                        "Math",
                        new Teacher(
                                50,
                                'M',
                                "Darius Stegosaurus",
                                170,
                                90,
                                false,
                                new Date(1972, 12, 10 ),
                                "Mathematics"
                        ),
                        students
                )
        );
        courses01.add(
                new FacultyCourse(
                        "Logic",
                        new Teacher(
                                60,
                                'F',
                                "Daria Stegosaurus",
                                170,
                                70,
                                false,
                                new Date(1962, 12, 10 ),
                                "Logic"
                        ),
                        students
                )
        );
        facultyOffer.put("REAL", courses01);

//        HashMap<Integer, HashMap<String, Integer>> myHashmap = new HashMap<>();

    }
}