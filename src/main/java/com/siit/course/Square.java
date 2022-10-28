package com.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Square extends Rectangle {

    private int l;

    public Square(int l) {
        super(l, l);
        this.l = l;
    }

    @Override
    public void draw() {
        super.draw("SQUARE");
    }

    @Override
    public String toString() {
        return "THIS SQUARE HAS 4 vertices each with length " + l;
    }
}