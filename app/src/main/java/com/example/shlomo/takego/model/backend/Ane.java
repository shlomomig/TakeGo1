package com.example.shlomo.takego.model.backend;

/**
 * Created by Shlomo on 26/11/2017.
 */

public class Ane {
    private static final Ane ourInstance = new Ane();

    public static Ane getInstance() {
        return ourInstance;
    }

    private Ane() {
    }
}
