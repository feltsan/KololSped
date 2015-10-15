package com.thinkmobiles.koroltrans.model;

import java.io.Serializable;

/**
 * Created by john on 11.10.15.
 */
public class Invite implements Serializable{
    String nomer, type, date;

    public Invite(String nomer, String type, String date) {
        this.nomer = nomer;
        this.type = type;
        this.date = date;
    }

    public Invite() {
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

    @Override
    public String toString() {
        return nomer +" " + type + " " +
                 date ;
    }
}
