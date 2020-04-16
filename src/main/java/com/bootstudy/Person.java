package com.bootstudy;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String address;
    private String company;

    public Person(String name, String address, String company) {
        this.name = name;
        this.address = address;
        this.company = company;
    }
    public String getAddress() {
        return address;
    }
    public String getCompany() {
        return company;
    }
    public void setName(String name) {
        this.name = name;
    }
}
