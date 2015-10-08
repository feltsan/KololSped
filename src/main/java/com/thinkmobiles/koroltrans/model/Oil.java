package com.thinkmobiles.koroltrans.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.UUID;

/**
 * Created by john on 05.10.15.
 */

@ParseClassName("Oil")
public class Oil extends ParseObject {
    public Oil() {
        super();
    }

    public Oil(String date, String distance, String brend, String oilFiter,
              String airFilter, String fuelFilter, String glagodel,
               String price, String service, Truck truck) {
        super();
    }

    public void setDate(String date){
        put("date", date);
    }

    public void setDistance(String distance){
        put("distance", distance);
    }

    public void setBrend(String brend){
        put("brend", brend);
    }

    public void setOilFiter(String oilFilter){
        put("oil_filter", oilFilter);
    }

    public void setAirFilter(String airFilter){
        put("air_filter", airFilter);
    }

    public void setFuelFilter(String fuelFilter){
        put("fuel_filter", fuelFilter);
    }

    public void setGlagoDel(String glagodel){
        put("glagodel", glagodel);
    }

    public void setPrice(String price){
        put("price", price);
    }

    public void setService(String service){
        put("service", service);
    }

    public void setTruck(Truck truck){
        put("truck", truck);
    }

    public void setUuidString() {
        UUID uuid = UUID.randomUUID();
        put("uuid", uuid.toString());
    }

    public String getUuidString() {
        return getString("uuid");
    }

    public static ParseQuery<Oil> getQuery() {
        return ParseQuery.getQuery(Oil.class);
    }

    public String getDate(){
       return getString("date");
    }

    public String getDistance(){
        return getString("distance");
    }

    public String getBrend(){
        return getString("brend");
    }

    public String getOilFiter(){
        return getString("oil_filter");
    }

    public String getAirFilter(){
        return getString("air_filter");
    }

    public String getFuelFilter(){
        return getString("fuel_filter");
    }

    public String getGlagoDel(){
        return getString("glagodel");
    }

    public String getPrice(){
        return getString("price");
    }

    public String getService(){
        return getString("service");
    }

    public Truck getTruck(){
        return (Truck) getParseObject("truck");
    }
}
