package com.sda.parkingManagement.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="tickets")
public class Ticket {
    @Id
    @Column
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date enterDate;

    @Column
    private Date exitDat;

    @Column
    private String code;

    @Column
    private Date payDate;

    @Column
    private int payedAmount;

    public Ticket(Long id, Date enterDate, Date exitDat, String code, Date payDate, int payedAmount) {
        this.id = id;
        this.enterDate = enterDate;
        this.exitDat = exitDat;
        this.code = code;
        this.payDate = payDate;
        this.payedAmount = payedAmount;
    }


    public Ticket(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getExitDat() {
        return exitDat;
    }

    public void setExitDat(Date exitDat) {
        this.exitDat = exitDat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(int payedAmount) {
        this.payedAmount = payedAmount;
    }
}
