package com.example.shlomo.takego.model.entities;

/**
 * Created by Shlomo on 19/11/2017.
 */

public class Client {
    public String get_last_name() {
        return _last_name;
    }

    public void set_last_name(String _last_name) {
        this._last_name = _last_name;
    }

    public String get_first_name() {
        return _first_name;
    }

    public void set_first_name(String _first_name) {
        this._first_name = _first_name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public long get_phone_number() {
        return _phone_number;
    }

    public void set_phone_number(long _phone_number) {
        this._phone_number = _phone_number;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public long get_credit_card() {
        return _credit_card;
    }

    public void set_credit_card(long _credit_card) {
        this._credit_card = _credit_card;
    }

    private String _last_name;
    private String _first_name;
    private int _id;
    private  long _phone_number;
    private String _email;
    private long _credit_card;
}
