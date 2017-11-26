package com.example.shlomo.takego.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;
import com.example.shlomo.takego.model.entities.Client;

import java.util.List;

import static com.example.shlomo.takego.model.datasource.ListDS.*;

//hi
/**
 * Created by Shlomo on 21/11/2017.
 */

public class List_DBManager implements DB_Manager {
    @Override
    public boolean isClientExists(ContentValues contentValues) {
        Client client=Tools.ContentValuesToClient(contentValues);
        if(clients.contains(client))
            return true;
        else
            return  false;
    }

    @Override
    public void addClient(ContentValues contentValues) {
        Client client=Tools.ContentValuesToClient(contentValues);
        clients.add(client);
    }

    @Override
    public void addCarModel(ContentValues contentValues) {
        CarModel carModel=Tools.ContentValuesToCarModel(contentValues);
        carModels.add(carModel);
    }

    @Override
    public void addCar(ContentValues contentValues) {
        Car car=Tools.ContentValuesToCar(contentValues);
        cars.add(car);
    }

    @Override
    public List getCars() {
        return cars;
    }

    @Override
    public List getCarModels() {
        return carModels;
    }

    @Override
    public List getClients() {
        return clients;
    }


}
