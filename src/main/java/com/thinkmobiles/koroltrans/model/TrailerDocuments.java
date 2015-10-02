package com.thinkmobiles.koroltrans.model;

/**
 * Created by john on 28.09.tacho.
 */
public class TrailerDocuments {
    private GreenCard greenCard;
    private WhiteCertf whiteCertf;
    private ProtocolEURO protocolEURO;
    private PolicyUA policyUA;
    private YellowCerf yellowCerf;

    public TrailerDocuments(GreenCard greenCard, WhiteCertf whiteCertf, ProtocolEURO protocolEURO, PolicyUA policyUA, YellowCerf yellowCerf) {
        this.greenCard = greenCard;
        this.whiteCertf = whiteCertf;
        this.protocolEURO = protocolEURO;
        this.policyUA = policyUA;
        this.yellowCerf = yellowCerf;
    }

    public GreenCard getGreenCard() {
        return greenCard;
    }

    public void setGreenCard(GreenCard greenCard) {
        this.greenCard = greenCard;
    }

    public WhiteCertf getWhiteCertf() {
        return whiteCertf;
    }

    public void setWhiteCertf(WhiteCertf whiteCertf) {
        this.whiteCertf = whiteCertf;
    }

    public ProtocolEURO getProtocolEURO() {
        return protocolEURO;
    }

    public void setProtocolEURO(ProtocolEURO protocolEURO) {
        this.protocolEURO = protocolEURO;
    }

    public PolicyUA getPolicyUA() {
        return policyUA;
    }

    public void setPolicyUA(PolicyUA policyUA) {
        this.policyUA = policyUA;
    }

    public YellowCerf getYellowCerf() {
        return yellowCerf;
    }

    public void setYellowCerf(YellowCerf yellowCerf) {
        this.yellowCerf = yellowCerf;
    }
}
