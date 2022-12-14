package de.spiceitup.persistence;

import jakarta.persistence.*;

@Entity(name = "gewuerze")
public class GewuerzEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "vorraetig")
    private boolean vorraetig;

    @Column(name = "menge")
    private int menge;

    public GewuerzEntity(String name, boolean vorraetig, int menge) {
        this.name = name;
        this.vorraetig = vorraetig;
        this.menge = menge;
    }

    public GewuerzEntity() {}

    public Long getId() {
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
