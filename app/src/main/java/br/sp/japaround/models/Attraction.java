package br.sp.japaround.models;

import java.util.ArrayList;

public class Attraction {

    private String price;
    private String district;
    private String schedules;
    private String attraction;

    private Address address;
    private Station station;

    private ArrayList<String> source;
    private ArrayList<String> obs;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSchedules() {
        return schedules;
    }

    public void setSchedules(String schedules) {
        this.schedules = schedules;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public ArrayList<String> getSource() {
        return source;
    }

    public void setSource(ArrayList<String> source) {
        this.source = source;
    }

    public ArrayList<String> getObs() {
        return obs;
    }

    public void setObs(ArrayList<String> obs) {
        this.obs = obs;
    }
}
