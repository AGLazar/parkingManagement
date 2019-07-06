package com.sda.parkingManagement.model;

import java.util.List;

public class Sector {
    private Long id;
    private List<ParkingSpace> parkingSpaces;
    private String name;

    public Sector(Long id, List<ParkingSpace> parkingSpaces, String name) {
        this.id = id;
        this.parkingSpaces = parkingSpaces;
        this.name = name;
    }

    public Sector(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
