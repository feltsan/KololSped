package com.thinkmobiles.koroltrans.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by john on 27.09.tacho.
 */
public class Truck implements Serializable {
    private String id;
    private String derzhNomer;

    private Trailer trailer;
    private TruckDocuments truckDocuments;
    private ArrayList<Repair> repairs;
    private ArrayList<Oil> oils;
    private ArrayList<Order> orders;

    public Truck(String id, String derzhNomer, Trailer trailer, TruckDocuments truckDocuments, ArrayList<Repair> repairs, ArrayList<Oil> oils, ArrayList<Order> orders) {
        this.id = id;
        this.derzhNomer = derzhNomer;
        this.trailer = trailer;
        this.truckDocuments = truckDocuments;
        this.repairs = repairs;
        this.oils = oils;
        this.orders = orders;
    }

    public String getId() {        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDerzhNomer() {
        return derzhNomer;
    }

    public void setDerzhNomer(String derzhNomer) {
        this.derzhNomer = derzhNomer;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public TruckDocuments getTruckDocuments() {
        return truckDocuments;
    }

    public void setTruckDocuments(TruckDocuments truckDocuments) {
        this.truckDocuments = truckDocuments;
    }

    public ArrayList<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(ArrayList<Repair> repairs) {
        this.repairs = repairs;
    }

    public ArrayList<Oil> getOils() {
        return oils;
    }

    public void setOils(ArrayList<Oil> oils) {
        this.oils = oils;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
