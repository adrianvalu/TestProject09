package com.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Light {

    public static final float MAX_INTENSITY = 100f;
    private boolean isOn;
    private float intensity;

    public void turnOn() {
        isOn = true;
        intensity = 1f;
    }

    public void turnOff() {
        isOn = false;
        intensity = 0;
        print();
    }

    public void dim(float intensity) {
        this.intensity -= intensity;
        if (this.intensity <= 0) {
            turnOff();
        }
    }

    public void brighten(float intensity) {
        this.intensity += intensity;
        if (this.intensity > MAX_INTENSITY) {
            this.intensity = MAX_INTENSITY;
        }
        isOn = true;
    }

    public void print() {
        String state = (isOn) ? "ON" : "OFF"; // if isOn == true then state = "ON" else state = "OFF";
        System.out.println("The state of the light is " + state + " and intensity is " + intensity);
    }

}