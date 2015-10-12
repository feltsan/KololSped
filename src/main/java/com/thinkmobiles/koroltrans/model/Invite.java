package com.thinkmobiles.koroltrans.model;

/**
 * Created by john on 11.10.15.
 */
public class Invite {
    String nomer, type, date;

    public Invite(String nomer, String type, String date) {
        this.nomer = nomer;
        this.type = type;
        this.date = date;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
