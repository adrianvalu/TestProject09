package com.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Shape {

    private String color;

    public void draw() {
        System.out.println("Drawing a SHAPE with color " + color);
    }

    public void draw(String type) {
        System.out.println("Drawing a " + type +  " with color " + color);
    }

    public void erase() {
        System.out.println("Erasing a SHAPE with color " + color);
    }

    protected void shapePrivateMethod() {
        System.out.println("THIS IS A METHOD JUST FOR SHAPE");
    }
//public abstract void doAnotherThing();

}