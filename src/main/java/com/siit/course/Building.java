package com.siit.course;

//import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter

public class Building {

    private String name;
    private static ArrayList<ArrayList<Floor>> floors;

    private HashMap<String, ArrayList<Floor>> floorMap;

    public Building(String name, ArrayList<ArrayList<Floor>> floors) {
        this.name = name;
        this.floors = floors;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " has " + floors.size() + " floors: " + "\n\t\t\t\t" + floors;

    }



    public static void runHomework() {

        Furniture seats1 = new Furniture(10, " seats;");
        ArrayList<Furniture> furnitureArrayList = new ArrayList<>();
        furnitureArrayList.add(seats1);

        Furniture seats2 = new Furniture(8, " seats;");
        ArrayList<Furniture> furnitureArrayList2 = new ArrayList<>();
        furnitureArrayList2.add(seats2);

        Furniture seats3 = new Furniture(30, " seats;");
        ArrayList<Furniture> furnitureArrayList3 = new ArrayList<>();
        furnitureArrayList3.add(seats3);

        Furniture seats4 = new Furniture(20, " seats;");
        ArrayList<Furniture> furnitureArrayList4 = new ArrayList<>();
        furnitureArrayList4.add(seats4);


        Furniture desks1 = new Furniture(20, " desks;");
        ArrayList<Furniture> furnitureArrayList5 = new ArrayList<>();
        furnitureArrayList5.add(desks1);

        Furniture desks2 = new Furniture(10, " desks;");
        ArrayList<Furniture> furnitureArrayList6 = new ArrayList<>();
        furnitureArrayList6.add(desks2);

        Furniture furniture = new Furniture(1, " furniture;");
        ArrayList<Furniture> furnitureArrayList7 = new ArrayList<>();
        furnitureArrayList7.add(furniture);

        Appliances lightingSystem = new Appliances(1, " lighting system");
        ArrayList<Appliances> applianceArrayList2 = new ArrayList<>();
        applianceArrayList2.add(lightingSystem);


        Appliances coffeeMachine = new Appliances(1, " coffee machine");
        Appliances waterDispenser = new Appliances(1, " water dispenser");
        Appliances fridge = new Appliances(1, " fridge");
        ArrayList<Appliances> applianceArrayList = new ArrayList<>();
        applianceArrayList.add(coffeeMachine);
        applianceArrayList.add(waterDispenser);
        applianceArrayList.add(fridge);

        Appliances conferenceEquipment = new Appliances(1, " Telepresence;");
        Appliances tv = new Appliances(1, " TV;");
        ArrayList<Appliances> applianceArrayList3 = new ArrayList<>();
        applianceArrayList3.add(tv);

        ArrayList<Appliances> applianceArrayList5 = new ArrayList<>();
        applianceArrayList5.add(tv);
        applianceArrayList5.add(conferenceEquipment);

        Appliances videoProjector = new Appliances(1, " Video projector;");
        ArrayList<Appliances> applianceArrayList4 = new ArrayList<>();
        applianceArrayList4.add(videoProjector);
        applianceArrayList4.add(conferenceEquipment);


        Room conference1 = new Room(RoomType.Conference, "Conference room 1", furnitureArrayList, applianceArrayList3);
        Room conference2 = new Room(RoomType.Conference, "Conference room 2", furnitureArrayList, applianceArrayList3);
        Room conference3 = new Room(RoomType.Conference, "Conference room 3", furnitureArrayList, applianceArrayList3);

        Room conference4 = new Room(RoomType.Conference, "Conference room 1", furnitureArrayList2, applianceArrayList3);
        Room conference5 = new Room(RoomType.Conference, "Conference room 2", furnitureArrayList2, applianceArrayList3);
        Room conference6 = new Room(RoomType.Conference, "Conference room 3", furnitureArrayList2, applianceArrayList3);
        Room conference7 = new Room(RoomType.Conference, "Conference room 4", furnitureArrayList2, applianceArrayList3);

        Room conference8 = new Room(RoomType.Conference, "Conference room 1", furnitureArrayList3, applianceArrayList4);
        Room conference9 = new Room(RoomType.Conference, "Conference room 2", furnitureArrayList4, applianceArrayList5);
        Room conference10 = new Room(RoomType.Conference, "Conference room 3", furnitureArrayList, applianceArrayList5);
        Room conference11 = new Room(RoomType.Conference, "Conference room 4", furnitureArrayList, applianceArrayList5);
        Room conference12 = new Room(RoomType.Conference, "Conference room 5", furnitureArrayList, applianceArrayList5);
        Room conference13 = new Room(RoomType.Conference, "Conference room 6", furnitureArrayList, applianceArrayList5);

        Room officeSpace1 = new Room(RoomType.OfficeSpace, "Office space 1", furnitureArrayList5, applianceArrayList2);
        Room officeSpace2 = new Room(RoomType.OfficeSpace, "Office space 1", furnitureArrayList6, applianceArrayList2);
        Room officeSpace3 = new Room(RoomType.OfficeSpace, "Office space 2", furnitureArrayList6, applianceArrayList2);

        Room kitchen = new Room(RoomType.Kitchen, "Kitchen 1", furnitureArrayList7, applianceArrayList);

        Room toilet1 = new Room(RoomType.Toilet, "Toilet 1",furnitureArrayList7, applianceArrayList2);
        Room toilet2 = new Room(RoomType.Toilet, "Toilet 2",furnitureArrayList7, applianceArrayList2);


        ArrayList<Room> conferenceRooms = new ArrayList<>();
        conferenceRooms.add(conference1);
        conferenceRooms.add(conference2);
        conferenceRooms.add(conference3);

        ArrayList<Room> officeRooms = new ArrayList<>();
        officeRooms.add(officeSpace1);

        ArrayList<Room> kitchenRooms = new ArrayList<>();
        kitchenRooms.add(kitchen);

        ArrayList<Room> officeRooms2 = new ArrayList<>();
        officeRooms2.add(officeSpace2);
        officeRooms2.add(officeSpace3);


        ArrayList<Room> conferenceRooms2 = new ArrayList<>();
        conferenceRooms2.add(conference4);
        conferenceRooms2.add(conference5);
        conferenceRooms2.add(conference6);
        conferenceRooms2.add(conference7);

        ArrayList<Room> conferenceRooms3 = new ArrayList<>();
        conferenceRooms3.add(conference8);
        conferenceRooms3.add(conference9);
        conferenceRooms3.add(conference10);
        conferenceRooms3.add(conference11);
        conferenceRooms3.add(conference12);
        conferenceRooms3.add(conference13);

        ArrayList<Room> toiletRooms = new ArrayList<>();
        toiletRooms.add(toilet1);
        toiletRooms.add(toilet2);


        Floor floor1 = new Floor("1", officeRooms, conferenceRooms, kitchenRooms, toiletRooms);
        Floor floor2 = new Floor("2", officeRooms2, conferenceRooms2, kitchenRooms,toiletRooms);
        Floor floor3 = new Floor("3", officeRooms, conferenceRooms3, kitchenRooms, toiletRooms);

        ArrayList<Floor> floors1 = new ArrayList<>();
        floors1.add(floor1);

        ArrayList<Floor> floors2 = new ArrayList<>();
        floors2.add(floor2);

        ArrayList<Floor> floors3 = new ArrayList<>();
        floors3.add(floor3);


        ArrayList<ArrayList<Floor>> floors = new ArrayList<>();
        floors.add(floors1);
        floors.add(floors2);
        floors.add(floors3);


        Building b1 = new Building("Adria", floors);
        System.out.println(b1);




















    }



}

