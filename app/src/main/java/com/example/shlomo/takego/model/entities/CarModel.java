package com.example.shlomo.takego.model.entities;

/**
 * Created by Shlomo on 19/11/2017.
 */

public class CarModel {
    public String get_model_code() {
        return _model_code;
    }

    public void set_model_code(String _model_code) {
        this._model_code = _model_code;
    }

    public String get_company_name() {
        return _company_name;
    }

    public void set_company_name(String _company_name) {
        this._company_name = _company_name;
    }

    public String get_model_name() {
        return _model_name;
    }

    public void set_model_name(String _model_name) {
        this._model_name = _model_name;
    }

    public int get_engine_volume() {
        return _engine_volume;
    }

    public void set_engine_volume(int _engine_volume) {
        this._engine_volume = _engine_volume;
    }

    public Geer get_geer() {
        return _geer;
    }

    public void set_geer(Geer _geer) {
        this._geer = _geer;
    }

    public int get_seat_number() {
        return _seat_number;
    }

    public void set_seat_number(int _seat_number) {
        this._seat_number = _seat_number;
    }

    String _model_code;
    String _company_name;
    String _model_name;
    int _engine_volume;
    Geer _geer;
    int _seat_number;
}
