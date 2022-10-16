package com.siit.course;

import java.util.Date;

public class CarBrands {

    String name;
    Date establishDate;
    String owner;
    String contact;
    Person ceo;

    public CarBrands(String name, Date establishDate, String owner, String contact, Person ceo) {
        this.name = name;
        this.establishDate = establishDate;
        this.owner = owner;
        this.contact = contact;
        this.ceo = ceo;
    }

    public CarBrands() {
    }

    public String getName() {
        return this.name;
    }

    public Date getDate() {
        return this.establishDate;
    }
}
