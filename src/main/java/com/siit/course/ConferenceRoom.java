package com.siit.course;

import java.util.ArrayList;

public class ConferenceRoom extends Room {


    public ConferenceRoom(RoomType roomType, String roomName, ArrayList<Furniture> furnitureArrayList, ArrayList<Appliances> appliancesArrayList) {
        super(roomType, roomName, furnitureArrayList, appliancesArrayList);
    }
}