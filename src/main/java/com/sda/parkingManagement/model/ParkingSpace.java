package com.sda.parkingManagement.model;
import javax.persistence.*;

@Entity
@Table(name="parking_spaces")
public class ParkingSpace {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean isFree;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @Column
    private int number;

    public ParkingSpace(Long id, Boolean isFree, Sector sector, int number) {
        this.id = id;
        this.isFree = isFree;
        this.sector = sector;
        this.number = number;
    }

    public ParkingSpace(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
