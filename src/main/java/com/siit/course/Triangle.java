package com.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Triangle extends Shape{

    private int l1;
    private int l2;
    private int l3;

    private boolean checkTriangle() {
        if (l1 > l2 + l3) {
            return false;
        }
        if (l2 > l1 + l3) {
            return false;
        }
        if (l3 > l1 + l2) {
            return false;
        }
        return true;
    }

    public Triangle(int l1, int l2, int l3, String color) throws CustomCourseException {
        super(color); // setting up the color using the parent constructor !!
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        if(!checkTriangle()) {
            throw new CustomCourseException(l1, l2, l3, "Invalid Triangle");
        }
//        super.setColor(color); // this is calling the setColor() constructor from Shape class (parent)
    }

    @Override
    public void draw() {
        super.draw("TRIANGLE");
    }

}