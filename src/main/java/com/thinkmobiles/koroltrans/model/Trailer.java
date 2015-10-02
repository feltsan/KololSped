package com.thinkmobiles.koroltrans.model;

/**
 * Created by john on 28.09.tacho.
 */
public class Trailer {
    private String id, truckId, nomer;
    private TrailerDocuments documents;

    public Trailer(String id, String truckId, String nomer, TrailerDocuments documents) {
        this.id = id;
        this.truckId = truckId;
        this.nomer = nomer;
        this.documents = documents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public TrailerDocuments getDocuments() {
        return documents;
    }

    public void setDocuments(TrailerDocuments documents) {
        this.documents = documents;
    }
}
