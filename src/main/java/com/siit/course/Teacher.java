package com.siit.course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class Teacher extends Person{

    private String specialization;

    public Teacher(int age, char sex, String name, int height, int weight, boolean isHungry, Date birthday, String specialization) {
        super(age, sex, name, height, weight, isHungry, birthday);
        this.specialization = specialization;
    }
}