package com.thinkmobiles.koroltrans.model;

/**
 * Created by john on 28.09.tacho.
 */
public class Oil  extends Repair{
    private String airFiltre, fuelFiltre, oilFiltre;

    public Oil(String id, String truckId, String name, String distance, String date, String marka, String price, String airFiltre, String fuelFiltre, String oilFiltre) {
        super(id, truckId, name, distance, date, marka, price);
        this.airFiltre = airFiltre;
        this.fuelFiltre = fuelFiltre;
        this.oilFiltre = oilFiltre;
    }

    public String getAirFiltre() {
        return airFiltre;
    }

    public void setAirFiltre(String airFiltre) {
        this.airFiltre = airFiltre;
    }

    public String getFuelFiltre() {
        return fuelFiltre;
    }

    public void setFuelFiltre(String fuelFiltre) {
        this.fuelFiltre = fuelFiltre;
    }

    public String getOilFiltre() {
        return oilFiltre;
    }

    public void setOilFiltre(String oilFiltre) {
        this.oilFiltre = oilFiltre;
    }
}
