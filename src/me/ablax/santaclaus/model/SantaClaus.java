package me.ablax.santaclaus.model;

public final class SantaClaus {

    private static final SantaClaus INSTANCE = new SantaClaus();

    private SantaClaus() {
        //Singleton
    }

    public static SantaClaus getInstance() {
        return SantaClaus.INSTANCE;
    }

}
