package com.example.shlomo.takego.model.datasource;

import android.content.ContentValues;

import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.entities.Branch;
import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;
import com.example.shlomo.takego.model.entities.Client;
import com.example.shlomo.takego.model.entities.Geer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shlomo on 21/12/2017.
 */

public class MySQL_DBManager implements DB_Manager{

    private final String UserName="smigdalo";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il";

    @Override
    public boolean isClientExists(ContentValues contentValues) {

        List<Client> list=getClients();
        Client client=Tools.ContentValuesToClient(contentValues);
        for (Client c : list) {
            if(c.get_id()==client.get_id())
                return true;
        }
        return  false;
    }

    @Override
    public boolean addClient(ContentValues values) {
        try {
            if (!isClientExists(values)) {
                PHPtools.POST(WEB_URL + "/add_client.php", values);
                return true;
            }
            else
                return false;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public void addCarModel(ContentValues contentValues) {
        try {
            String result = PHPtools.POST(WEB_URL + "/add_model.php", contentValues);

        } catch (IOException e) {
        }
    }

    @Override
    public void addCar(ContentValues contentValues) {
        try {
            String result = PHPtools.POST(WEB_URL + "/add_car.php", contentValues);

        } catch (IOException e) {
        }
    }

    @Override
    public void addBranch(ContentValues contentValues) {
        try {
            String result = PHPtools.POST(WEB_URL + "/add_branch.php", contentValues);

        } catch (IOException e) {
        }
    }

    @Override
    public ArrayList<Car> getCars() {

        try {
            ArrayList<Car> result = new ArrayList<Car>();
            String str = PHPtools.GET(WEB_URL + "/get_cars.php");
            JSONArray array = new JSONObject(str).getJSONArray("cars");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                Car car = new Car();
                car.set_liscene_number(jsonObject.getInt("_id"));
                car.set_car_model(jsonObject.getString("car_model"));
                car.set_milage(jsonObject.getInt("milage"));
                car.set_branch_number(jsonObject.getInt("branch_number"));
                result.add(car);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<CarModel> getCarModels() {
        try {
            ArrayList<CarModel> result = new ArrayList<CarModel>();
            String str = PHPtools.GET(WEB_URL + "/get_models.php");
            JSONArray array = new JSONObject(str).getJSONArray("models");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

            CarModel car_model = new CarModel();
            car_model.set_model_code(jsonObject.getString("_id"));
            car_model.set_model_name(jsonObject.getString("model_name"));
            car_model.set_company_name(jsonObject.getString("company_name"));
            car_model.set_engine_volume(jsonObject.getInt("engine_volume"));
            car_model.set_seat_number(jsonObject.getInt("seat_number"));
            car_model.set_geer(Geer.valueOf(jsonObject.getString("geer")));
            result.add(car_model);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Client> getClients() {

        try {
            ArrayList<Client> result = new ArrayList<Client>();
            String str = PHPtools.GET(WEB_URL + "/get_clients.php");
            JSONArray array = new JSONObject(str).getJSONArray("clients");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                Client client = new Client();
                client.set_id(jsonObject.getInt("_id"));
                client.set_credit_card(jsonObject.getInt("credit_card"));
                client.set_email(jsonObject.getString("email"));
                client.set_phone_number(jsonObject.getInt("phone"));
                client.set_first_name(jsonObject.getString("first_name"));
                client.set_last_name(jsonObject.getString("last_name"));
                result.add(client);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Branch> getBranchess() {

        try {
            ArrayList<Branch> result = new ArrayList<Branch>();
            String str = PHPtools.GET(WEB_URL + "/get_branches.php");
            JSONArray array = new JSONObject(str).getJSONArray("branches");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                Branch branch = new Branch();
                branch.set_branch_number(jsonObject.getInt("_id"));
                branch.set_city(jsonObject.getString("city"));
                branch.set_street(jsonObject.getString("street"));
                branch.set_parking_spots(jsonObject.getInt("parking_spots"));
                result.add(branch);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
