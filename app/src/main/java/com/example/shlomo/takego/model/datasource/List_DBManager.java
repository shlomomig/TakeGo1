package com.example.shlomo.takego.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.entities.Branch;
import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;
import com.example.shlomo.takego.model.entities.Client;

import java.util.ArrayList;
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
        for (Client c : clients)
        {
            if(c.get_id()==client.get_id())
                return true;
        }
        return false;
    }

    @Override
    public boolean addClient(ContentValues contentValues) {
        Client client=Tools.ContentValuesToClient(contentValues);
        if(isClientExists(Tools.ClientToContentValues(client)))
            return false;
        else
            {clients.add(client);
            return true;}
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
    public void addBranch(ContentValues contentValues) {
        Branch branch=Tools.ContentValuesToBranch(contentValues);
        branches.add(branch);
    }

    @Override
    public ArrayList<Car> getCars() {
        return cars;
    }

    @Override
    public ArrayList<CarModel> getCarModels() {
        return carModels;
    }

    @Override
    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public ArrayList<Branch> getBranchess() {
        return branches;
    }


}
