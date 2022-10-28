package com.siit.course;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Person {

    private int age;
    private char sex;
    private String name;
    private int height;
    private int weight;
    private boolean isHungry;
    private Date birthday;

    private Shape favouriteShape;

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

    // Setter
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    // Getter
    public Date getBirthday() {
        return this.birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}
