package com.example.shlomo.takego.controller;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shlomo.takego.R;
import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.backend.Factory_DBManager;
import com.example.shlomo.takego.model.entities.Client;

public class MainActivity extends AppCompatActivity {


    private Spinner spinner1;
    private Spinner spinner2;


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
/*
        Button addclientButton = (Button) findViewById(R.id.addClientButton);
        addclientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddClientActivity.class);
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

        Button addModelButton = (Button) findViewById(R.id.addModelButton);
        addModelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddModelActivity.class);
                startActivity(intent);
            }

        });

        addBrnachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBranchActivity.class);
                startActivity(intent);
            }
        });
  */
/*
        //show
        Button showClentButton = (Button) findViewById(R.id.showClientListButton);
        showClentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowClientsActivity.class);
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

        Button addBrnachButton = (Button) findViewById(R.id.addBBranchButton);

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
        */
    }

  //  boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.sp);

        spinner2 =(Spinner) findViewById(R.id.sp2);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
             //   Toast.makeText(MainActivity.this, "position" + i, Toast.LENGTH_SHORT).show();
                switch(i)
                {
                    case 0:

                        break;

                    case 1:
                        intent = new Intent(MainActivity.this, ShowClientsActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ShowCarActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, ShowBranchesActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, ShowModelsActivity.class);
                        startActivity(intent);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                //if (!firstTime) {
              //  Toast.makeText(MainActivity.this, "position:" + i, Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:

                        break;

                    case 1:
                        intent = new Intent(MainActivity.this, AddClientActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, AddCarActivity.class);
                        startActivity(intent);

                        break;

                    case 3:
                        intent = new Intent(MainActivity.this, AddModelActivity.class);
                        startActivity(intent);

                        break;

                    case 4:

                        intent = new Intent(MainActivity.this, AddBranchActivity.class);
                        startActivity(intent);
                        break;

                }
//                } else {
//                    firstTime = false;
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        spinner1.setSelection(0);
        spinner2.setSelection(0);
    }



}
