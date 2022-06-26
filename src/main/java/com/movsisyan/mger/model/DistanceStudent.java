package com.movsisyan.mger.model;

public class DistanceStudent extends Student {
    private String distance;
    private String address;

    public DistanceStudent(String distance, String name, String surname, int course, String address) {
        super(name, surname, course);
        this.address = address;
        this.distance = distance;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", ") + " " +
                "type ='" + distance + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
