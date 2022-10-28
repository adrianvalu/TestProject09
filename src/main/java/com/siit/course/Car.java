package com.siit.course;

import com.siit.course.utils.GeneralUtils;
import lombok.*;

import java.awt.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Car {

    public final float ACC_STEP = 5;
    public final float MAX_SPEED = 240;
    public final byte MAX_GEAR = 5;

    public final float MAX_DIRECTION = 360;
    private CarBrands brand;
    private String model;
    private Color color;
    private String fuelType;
    private boolean isNew;
    private String vin;
    private float currentSpeed;
    private float fuelLevel;
    private byte gear;
    private boolean isStopped;

    private float direction; // 0 degrees is north

    public Car(CarBrands brand, String model, Color color, String fuelType, boolean isNew, String vin) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
        this.isNew = isNew;
        this.vin = vin;
    }

    private void accelerateStep(float step) {
        isStopped = false;
        if (gear == 0) {
            gear++;
        }
        if (currentSpeed + step > MAX_SPEED)  {
            currentSpeed = MAX_SPEED;
        }
        else {
            currentSpeed += step;
        }
    }

    public void accelerate() { // default accelerate
        accelerateStep(ACC_STEP);
    }

    public void accelerate(float speedDelta) { // accelerate with a speed delta
        accelerateStep(speedDelta);
    }

    public void paintCar(Color color) {
        this.color = color;
    }

    public void printCar() { // Object method
        System.out.println("------------------");
        System.out.println("CAR MODEL " + this.model);
        System.out.println("CAR BRAND " + this.brand.getName());
        System.out.println("CAR COLOR "  + this.color);
        System.out.println("CURRENT SPEED " + this.currentSpeed);
        System.out.println("CURRENT GEAR " + this.gear);
        System.out.println("CURRENT CAR direction is " + this.direction);
//        GeneralUtils.printCar(this); // Static --> Class method
    }

    public void gearUp() {
        if (gear == MAX_GEAR) {
            System.out.println("The max gear level has been reached!");
        }
        else {
            gear++;
        }
    }

    public void gearDown() {
        if (gear == 0) {
            System.out.println("The car reached already the minimum gear level !");
        }
        else {
            gear--;
        }
    }

    public void startCar() {
        isStopped = false;
        gear = 1;
        currentSpeed = 0;
    }

    public void stopCar() {
        isStopped = true;
        gear = 0;
        currentSpeed = 0;
    }

    public void turnLeft(float angle) {
        direction -= (angle % MAX_DIRECTION);
        if (direction < 0) {
            direction = MAX_DIRECTION + direction;
        }
    }

    public void turnRight(float angle) {
        direction += angle;
        direction %= MAX_DIRECTION; // direction = direction % MAX_DIRECTION;
    }


}