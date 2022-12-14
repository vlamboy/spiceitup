package de.spiceitup.web.api;

public class Gewuerz {
    private long id;
    private String name;
    private boolean vorraetig;
    private int menge;

    public Gewuerz(long id, String name, boolean vorraetig, int menge) {
        this.id = id;
        this.name = name;
        this.vorraetig = vorraetig;
        this.menge = menge;
    }

    public long getId() {
        return id;
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
