package com.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FacultyCourse {

    private String name;
    private Teacher teacher;
    private ArrayList<Student> students;

    public void printCourse() {
        System.out.println("Course name " + name);
        System.out.println("Course teacher " + teacher.getName());
        System.out.println("Student count  " + students.size());
    }

}