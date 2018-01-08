package com.example.shlomo.takego.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shlomo.takego.R;
import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.backend.Factory_DBManager;
import com.example.shlomo.takego.model.entities.Client;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
//        Car carModel=new Car();
//        carModel.set_branch_number(2);
//        carModel.set_milage(3);
//        carModel.set_liscene_number(123456);
//        carModel.set_car_model("focus");
//        Car carModel2=new Car();
//        carModel2.set_branch_number(2);
//        carModel2.set_milage(3);
//        carModel2.set_liscene_number(126);
//        carModel2.set_car_model("focus2");
//        DB_Manager manager= Factory_DBManager.getManager();
//        manager.addCar(Tools.CarToContentValues(carModel));
//        manager.addCar(Tools.CarToContentValues(carModel2));

        Button addclientButton = (Button) findViewById(R.id.addClientButton);
        addclientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddClientActivity.class);
                startActivity(intent);
            }
        });
        Button showClentButton = (Button) findViewById(R.id.showClientListButton);
        showClentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowClientsActivity.class);
                startActivity(intent);
            }
        });
        Button addCarButton = (Button) findViewById(R.id.addCarButton);
        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCarActivity.class);
                startActivity(intent);
            }
        });
        Button showCarButton = (Button) findViewById(R.id.showCarListButton);
        showCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowCarActivity.class);
                startActivity(intent);
            }

        });
        Button addModelButton = (Button) findViewById(R.id.addModelButton);
        addModelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddModelActivity.class);
                startActivity(intent);
            }

        });
        Button addBrnachButton = (Button) findViewById(R.id.addBBranchButton);
        addBrnachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBranchActivity.class);
                startActivity(intent);
            }
        });
        Button showbracnhesButton = (Button) findViewById(R.id.showBranchesListButton);
        showbracnhesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowBranchesActivity.class);
                startActivity(intent);
            }
        });

        Button showmodelsButton = (Button) findViewById(R.id.showModelsListButton);
        showmodelsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowModelsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
