package com.example.shlomo.takego.model.entities;

/**
 * Created by Shlomo on 19/11/2017.
 */

public class Car {
    public int get_branch_number() {
        return _branch_number;
    }

    public void set_branch_number(int _branch_number) {
        this._branch_number = _branch_number;
    }

    public String get_car_model() {
        return _car_model;
    }

    public void set_car_model(String _car_model) {
        this._car_model = _car_model;
    }

    public int get_milage() {
        return _milage;
    }

    public void set_milage(int _milage) {
        this._milage = _milage;
    }

    public int get_liscene_number() {
        return _liscene_number;
    }

    public void set_liscene_number(int _liscene_number) {
        this._liscene_number = _liscene_number;
    }

    int _branch_number;
    String _car_model;
    int _milage;
    int _liscene_number;
}
