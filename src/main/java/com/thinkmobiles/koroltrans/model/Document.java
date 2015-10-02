package com.thinkmobiles.koroltrans.model;

/**
 * Created by john on 28.09.tacho.
 */
public abstract class Document {
    private String id, name, fromDate, toData, price, type;

    public Document(String id, String name, String fromDate, String toData, String price, String type) {
        this.id = id;
        this.name = name;
        this.fromDate = fromDate;
        this.toData = toData;
        this.price = price;
        this.type = type;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToData() {
        return toData;
    }

    public void setToData(String toData) {
        this.toData = toData;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
