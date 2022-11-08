package com.siit.course;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter

public class Floor {

    private String floorName;
    private ArrayList<Room> officeRooms;
    private ArrayList<Room> conferenceRooms;

    private ArrayList<Room> kitchenRooms;

    private ArrayList<Room> toiletRooms;

    public Floor(String floorName, ArrayList<Room> officeRooms, ArrayList<Room> conferenceRooms, ArrayList<Room> kitchenRooms, ArrayList<Room> toiletRooms) {
        this.floorName = floorName;
        this.officeRooms = officeRooms;
        this.conferenceRooms = conferenceRooms;
        this.kitchenRooms = kitchenRooms;
        this.toiletRooms = toiletRooms;
    }

    @Override
        public String toString() {
            return getClass().getSimpleName() + " " + floorName + " : " + officeRooms.size() + " Office space rooms : " + officeRooms + "\n\t\t\t\t\t\t\t" +
                    conferenceRooms.size() + " Conference rooms : " + conferenceRooms + "\n\t\t\t\t\t\t\t" + kitchenRooms.size() + " Kitchen rooms : " + kitchenRooms +
                     "\n\t\t\t\t\t\t\t" +toiletRooms.size() + " Toilet rooms : " + toiletRooms;

        }


    }



















