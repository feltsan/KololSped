package com.thinkmobiles.koroltrans.model;

/**
 * Created by john on 28.09.tacho.
 */
public class TruckDocuments extends TrailerDocuments {

    private Tacho tacho;

    public TruckDocuments(GreenCard greenCard, WhiteCertf whiteCertf, ProtocolEURO protocolEURO, PolicyUA policyUA, YellowCerf yellowCerf, Tacho tacho) {
        super(greenCard, whiteCertf, protocolEURO, policyUA, yellowCerf);
        this.tacho = tacho;
    }

    public Tacho getTacho() {
        return tacho;
    }

    public void setTacho(Tacho tacho) {
        this.tacho = tacho;
    }
}
