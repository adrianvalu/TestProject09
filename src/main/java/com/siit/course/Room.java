package com.siit.course;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private RoomType roomType;
    private String roomName;
    private ArrayList<Furniture> furnitureArrayList;
    private ArrayList<Appliances> appliancesArrayList;

    public Room(RoomType roomType, String roomName, ArrayList<Furniture> furnitureArrayList, ArrayList<Appliances> appliancesArrayList) {
        this.roomType = roomType;
        this.roomName = roomName;
        this.furnitureArrayList = furnitureArrayList;
        this.appliancesArrayList = appliancesArrayList;
    }

    @Override
    public String toString() {
        return roomName + " :" + furnitureArrayList.get(0) + appliancesArrayList;

    }

}
