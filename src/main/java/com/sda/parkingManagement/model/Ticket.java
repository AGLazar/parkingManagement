package com.sda.parkingManagement.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date enterDate;

    @Column
    private Date payDate;

    @Column
    private String code;

    @Column
    private long payedAmount;

    public Ticket(Long id, Date enterDate, Date payDate, String code, long payedAmount) {
        this.id = id;
        this.enterDate = enterDate;
        this.payDate = payDate;
        this.code = code;
        this.payedAmount = payedAmount;
    }

    public Ticket() {
    }

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

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(long payedAmount) {
        this.payedAmount = payedAmount;
    }
}
