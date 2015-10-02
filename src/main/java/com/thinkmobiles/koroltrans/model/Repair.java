package com.thinkmobiles.koroltrans.model;

/**
 * Created by john on 28.09.tacho.
 */
public class Repair {
    private String id, truckId, name, distance,date, marka, price;

    public Repair(String id, String truckId, String name, String distance, String date, String marka, String price) {
        this.id = id;
        this.truckId = truckId;
        this.name = name;
        this.distance = distance;
        this.date = date;
        this.marka = marka;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }
}
