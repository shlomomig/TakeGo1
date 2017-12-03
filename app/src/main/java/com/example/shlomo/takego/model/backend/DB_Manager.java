package com.example.shlomo.takego.model.backend;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;
import com.example.shlomo.takego.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shlomo on 19/11/2017.
 */

public interface DB_Manager {
    boolean isClientExists(ContentValues contentValues);

    void addClient(ContentValues values);

    void addCarModel(ContentValues contentValues);

    void addCar(ContentValues contentValues);

    List<Car> getCars();
    List<CarModel> getCarModels();
    ArrayList<Client> getClients();
}
