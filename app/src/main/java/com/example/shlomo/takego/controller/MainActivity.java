package com.example.shlomo.takego.controller;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.shlomo.takego.R;
import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.backend.Factory_DBManager;
import com.example.shlomo.takego.model.datasource.Tools;
import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;
import com.example.shlomo.takego.model.entities.Geer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Car carModel=new Car();
        carModel.set_branch_number(2);
        carModel.set_milage(3);
        carModel.set_liscene_number(123456);
        carModel.set_car_model("focus");
        Car carModel2=new Car();
        carModel2.set_branch_number(2);
        carModel2.set_milage(3);
        carModel2.set_liscene_number(126);
        carModel2.set_car_model("focus2");
        DB_Manager manager= Factory_DBManager.getManager();
        manager.addCar(Tools.CarToContentValues(carModel));
        manager.addCar(Tools.CarToContentValues(carModel2));
        for (Car car :manager.getCars()
             ) {
            android.util.Log.d("hh",String.valueOf(car.get_liscene_number()));
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
