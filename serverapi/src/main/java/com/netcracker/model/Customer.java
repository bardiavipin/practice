package com.netcracker.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pomu0116 on 6/1/2017.
 * modified by yopa0716 on 6/2/2017.
 */
public class Customer {

    private String type;
    private int id;
    private String name;
    private String Email;
    private int accountNumber;
    private Contact contact;
    private Location location;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
       this.location=location;
    }
}
