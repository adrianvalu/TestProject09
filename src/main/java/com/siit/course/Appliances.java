package com.siit.course;

public class Appliances {


    private int unit;

    private String applianceName;

    public Appliances(int unit, String applianceName) {
        this.unit = unit;
        this.applianceName = applianceName;
    }

    @Override
    public String toString() {
        return " " + unit + applianceName;

    }
}
