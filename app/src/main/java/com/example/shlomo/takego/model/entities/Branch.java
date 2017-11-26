package com.example.shlomo.takego.model.entities;

/**
 * Created by Shlomo on 19/11/2017.
 */

public class Branch {


    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_street() {
        return _street;
    }

    public void set_street(String _street) {
        this._street = _street;
    }

    public int get_parking_spots() {
        return _parking_spots;
    }

    public void set_parking_spots(int _parking_spots) {
        this._parking_spots = _parking_spots;
    }

    public int get_branch_number() {
        return _branch_number;
    }

    public void set_branch_number(int _branch_number) {
        this._branch_number = _branch_number;
    }

    private String _city;
    private String _street;
    private int _parking_spots;
    private int _branch_number;

}
