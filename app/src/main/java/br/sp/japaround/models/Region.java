package br.sp.japaround.models;

import java.util.ArrayList;

public class Region {

    private String region;
    private ArrayList<Province> provinces;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(ArrayList<Province> provinces) {
        this.provinces = provinces;
    }
}
