package com.sda.parkingManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="sectors")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (mappedBy = "sector")
    @JsonIgnore
    private List<ParkingSpace> parkingSpaces;
    @Column
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
