package de.spiceitup.web.api;

public class GewuerzManipulationRequest {

    private String name;
    private boolean vorraetig;
    private int menge;

    public GewuerzManipulationRequest(String name, boolean vorraetig, int menge) {
        this.name = name;
        this.vorraetig = vorraetig;
        this.menge = menge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVorraetig() {
        return vorraetig;
    }

    public void setVorraetig(boolean vorraetig) {
        this.vorraetig = vorraetig;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
}
