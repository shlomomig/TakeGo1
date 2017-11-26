package com.example.shlomo.takego.model.entities;

import java.util.Date;

/**
 * Created by Shlomo on 19/11/2017.
 */

public class Order {
    int _client_number;

    public int get_client_number() {
        return _client_number;
    }

    public void set_client_number(int _client_number) {
        this._client_number = _client_number;
    }

    public OrderStatus get_order_status() {
        return _order_status;
    }

    public void set_order_status(OrderStatus _order_status) {
        this._order_status = _order_status;
    }

    public int get_car_number() {
        return _car_number;
    }

    public void set_car_number(int _car_number) {
        this._car_number = _car_number;
    }

    public Date get_rental_begin() {
        return _rental_begin;
    }

    public void set_rental_begin(Date _rental_begin) {
        this._rental_begin = _rental_begin;
    }

    public Date get_renta_end() {
        return _renta_end;
    }

    public void set_renta_end(Date _renta_end) {
        this._renta_end = _renta_end;
    }

    public int get_milage_begin() {
        return _milage_begin;
    }

    public void set_milage_begin(int _milage_begin) {
        this._milage_begin = _milage_begin;
    }

    public int get_milage_end() {
        return _milage_end;
    }

    public void set_milage_end(int _milage_end) {
        this._milage_end = _milage_end;
    }

    public boolean is_is_gas_filled() {
        return _is_gas_filled;
    }

    public void set_is_gas_filled(boolean _is_gas_filled) {
        this._is_gas_filled = _is_gas_filled;
    }

    public int get_gas_filled_amount() {
        return _gas_filled_amount;
    }

    public void set_gas_filled_amount(int _gas_filled_amount) {
        this._gas_filled_amount = _gas_filled_amount;
    }

    public double get_price() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    public int get_order_number() {
        return _order_number;
    }

    public void set_order_number(int _order_number) {
        this._order_number = _order_number;
    }

    OrderStatus _order_status;
    int _car_number;
    Date _rental_begin;
    Date _renta_end;
    int _milage_begin;
    int _milage_end;
    boolean _is_gas_filled;
    int _gas_filled_amount;
    double _price;
    int _order_number;
}
