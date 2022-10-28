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

    public Triangle(int l1, int l2, int l3, String color) {
        super(color); // setting up the color using the parent constructor !!
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
//        super.setColor(color); // this is calling the setColor() constructor from Shape class (parent)
    }

    @Override
    public void draw() {
        super.draw("TRIANGLE");
    }



}