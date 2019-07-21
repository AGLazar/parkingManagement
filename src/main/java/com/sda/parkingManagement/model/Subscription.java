package com.sda.parkingManagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="subscriptions")
public class Subscription {
    @Id
    @Column
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private Date startDate;

    @Column
    @NotNull
    private Date endDate;

    @Column
    @NotNull
    private String code;

    public Subscription(Date startDate, Date endDate, String code) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.code = code;
    }

    public Subscription(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



}
