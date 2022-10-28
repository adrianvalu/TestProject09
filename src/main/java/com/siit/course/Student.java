package com.siit.course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class Student extends Person {

    private String faculty;
    private String studentId;

    public Student(int age, char sex, String name, int height, int weight, boolean isHungry, Date birthday, String faculty, String studentId) {
        super(age, sex, name, height, weight, isHungry, birthday);
        this.faculty = faculty;
        this.studentId = studentId;
    }

    public void party() {
        System.out.println("The student is partying!!");
    }
}