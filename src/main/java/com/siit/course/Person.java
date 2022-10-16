package com.siit.course;

import java.util.Date;

public class Person {

    int age;
    char sex;
    String name;
    int height;
    int weight;
    boolean isHungry;
    Date birthday;

    public Person() {

    }

    public Person(int age, char sex, String name, int height, int weight, boolean isHungry) {
        this.age = age;
        this.sex = sex;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.isHungry = isHungry;
    }

    public Person(int age, char sex, String name, int height, int weight, boolean isHungry, Date birthday) {
        this.age = age;
        this.sex = sex;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.isHungry = isHungry;
        this.birthday = birthday;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public void eat() {
        if (!isHungry) {
            System.out.println("I don't want to eat anymore!! I am not hungry.");
        }
        else {
            System.out.println("I am now eating!!!");
            isHungry = false;
        }
    }

    public void happyBirthday() {
        age++;
    }

}
