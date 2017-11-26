package com.example.shlomo.takego.model.datasource;

import android.content.ContentValues;

import com.example.shlomo.takego.model.backend.CarRentelConst;
import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;
import com.example.shlomo.takego.model.entities.Client;
import com.example.shlomo.takego.model.entities.Geer;

/**
 * Created by Shlomo on 19/11/2017.
 */

public class Tools {


    private int i;
    public static ContentValues CarToContentValues(Car car) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CarRentelConst.CarConst.ID, car.get_liscene_number());
        contentValues.put(CarRentelConst.CarConst.MILAGE, car.get_milage());
        contentValues.put(CarRentelConst.CarConst.BRANCH_NUMBER, car.get_branch_number());
        contentValues.put(CarRentelConst.CarConst.CAR_MODEL, car.get_car_model());
        return contentValues; 
    }
    
    public static Car ContentValuesToCar(ContentValues contentValues) {
        Car car = new Car();
        car.set_liscene_number(contentValues.getAsInteger(CarRentelConst.CarConst.ID));
        car.set_milage(contentValues.getAsInteger(CarRentelConst.CarConst.MILAGE));
        car.set_branch_number(contentValues.getAsInteger(CarRentelConst.CarConst.BRANCH_NUMBER));
        car.set_car_model(contentValues.getAsString(CarRentelConst.CarConst.CAR_MODEL));
        return car;
    }
    public static ContentValues CarModelToContentValus(CarModel carModel)
    {
        int _seat_number;
        ContentValues contentValues = new ContentValues();
        contentValues.put(CarRentelConst.CarModelConst.ID, carModel.get_model_code());
        contentValues.put(CarRentelConst.CarModelConst.COMPANY_NAME, carModel.get_company_name());
        contentValues.put(CarRentelConst.CarModelConst.MODEL_NAME, carModel.get_model_name());
        contentValues.put(CarRentelConst.CarModelConst.ENGINE_VOLUME, carModel.get_engine_volume());
        contentValues.put(CarRentelConst.CarModelConst.GEER, (carModel.get_geer().toString()));
        contentValues.put(CarRentelConst.CarModelConst.SEAT_NUMBER, carModel.get_seat_number());
        return contentValues;
    }

    public  static  CarModel ContentValuesToCarModel (ContentValues contentValues)
    {
        CarModel carModel = new CarModel();
        carModel.set_model_code(contentValues.getAsString(CarRentelConst.CarModelConst.ID));
        carModel.set_company_name(contentValues.getAsString(CarRentelConst.CarModelConst.COMPANY_NAME));
        carModel.set_model_name(contentValues.getAsString(CarRentelConst.CarModelConst.MODEL_NAME));
        carModel.set_engine_volume(contentValues.getAsInteger(CarRentelConst.CarModelConst.ENGINE_VOLUME));
        carModel.set_geer(Geer.valueOf(contentValues.getAsString(CarRentelConst.CarModelConst.GEER)));
        carModel.set_seat_number(contentValues.getAsInteger(CarRentelConst.CarModelConst.SEAT_NUMBER));
        return carModel;
    }
    public static ContentValues ClientToContentValues(Client client) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CarRentelConst.ClientConst.ID, client.get_id());
        contentValues.put(CarRentelConst.ClientConst.FIRST_NAME, client.get_first_name());
        contentValues.put(CarRentelConst.ClientConst.LAST_NAME, client.get_last_name());
        contentValues.put(CarRentelConst.ClientConst.PHONE, client.get_phone_number());
        contentValues.put(CarRentelConst.ClientConst.EMAIL, client.get_email());
        contentValues.put(CarRentelConst.ClientConst.CREDIT_CARD, client.get_credit_card());
        return contentValues;
    }
    public  static  Client ContentValuesToClient (ContentValues contentValues)
    {
        Client client = new Client();
        client.set_id(contentValues.getAsInteger(CarRentelConst.ClientConst.ID));
        client.set_first_name(contentValues.getAsString(CarRentelConst.ClientConst.FIRST_NAME));
        client.set_last_name(contentValues.getAsString(CarRentelConst.ClientConst.LAST_NAME));
        client.set_credit_card(contentValues.getAsLong(CarRentelConst.ClientConst.CREDIT_CARD));
        client.set_email(contentValues.getAsString(CarRentelConst.ClientConst.EMAIL));
        client.set_phone_number(contentValues.getAsLong(CarRentelConst.ClientConst.PHONE));
        return client;
    }
}

    
