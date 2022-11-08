package com.siit.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Furniture {


    private int unit;

    private String furnitureName;

    public int getUnit() {
        return unit;
    }

    public Furniture(int unit, String furnitureName) {
        this.unit = unit;
        this.furnitureName = furnitureName;
    }

    @Override
    public String toString() {
        return " " + unit + furnitureName;

    }



}
