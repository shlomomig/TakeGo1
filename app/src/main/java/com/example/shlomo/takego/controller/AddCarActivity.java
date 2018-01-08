package com.example.shlomo.takego.controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shlomo.takego.R;
import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.backend.Factory_DBManager;
import com.example.shlomo.takego.model.datasource.Tools;
import com.example.shlomo.takego.model.entities.Branch;
import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;
import com.example.shlomo.takego.model.entities.Client;

import java.util.ArrayList;

public class AddCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);


        final Spinner spinner=(Spinner)findViewById(R.id.modelspinner);
        final Spinner spinner2=(Spinner)findViewById(R.id.branchesSpinner);
        new AsyncTask<Void, Void, ArrayList<CarModel>>() {
            @Override
            protected void onPostExecute(ArrayList<CarModel> arr) {
                super.onPostExecute(arr);
                ArrayList<String> items=new ArrayList<>();
                for(CarModel carModel : arr)
                {
                    items.add(carModel.get_model_name());

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddCarActivity.this, android.R.layout.simple_spinner_dropdown_item, items);
                spinner.setAdapter(adapter);
            }

            @Override
            protected ArrayList<CarModel> doInBackground(Void... params) {
                DB_Manager db_manager = Factory_DBManager.getManager();
                ArrayList<CarModel> arr=db_manager.getCarModels();
                return arr;
            }
        }.execute();

        new AsyncTask<Void, Void, ArrayList<Branch>>() {
            @Override
            protected void onPostExecute(ArrayList<Branch> arr) {
                super.onPostExecute(arr);
                ArrayList<String> items2=new ArrayList<>();
                for(Branch branch : arr)
                {
                    items2.add(String.valueOf(branch.get_branch_number()));

                }
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(AddCarActivity.this, android.R.layout.simple_spinner_dropdown_item, items2);
                spinner2.setAdapter(adapter2);
            }

            @Override
            protected ArrayList<Branch> doInBackground(Void... params) {
                DB_Manager db_manager = Factory_DBManager.getManager();
                ArrayList<Branch> arr=db_manager.getBranchess();
                return arr;
            }
        }.execute();



        Button addButton=(Button)findViewById(R.id.addCarButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //EditText CarModelEditText;
                EditText MilageEditText;
               // EditText BrachNumberEditText;
                EditText LiscenceEditText;
                //CarModelEditText = (EditText) findViewById(R.id.CarModelEditText);
                MilageEditText = (EditText) findViewById(R.id.MilageEditText);
                //BrachNumberEditText = (EditText) findViewById(R.id.BrachNumberEditText);
                LiscenceEditText = (EditText) findViewById(R.id.LiscenceEditText);
                Spinner spinner1=(Spinner)findViewById(R.id.modelspinner);
                Spinner spinner2=(Spinner)findViewById(R.id.branchesSpinner);
                final Car car = new Car();
                try {
                    //car.set_car_model(CarModelEditText.getText().toString());

                    String model=spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString();
                    String branch=spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString();
                    car.set_car_model(model);
                    car.set_milage(Integer.valueOf(MilageEditText.getText().toString()));
                    car.set_liscene_number(Integer.valueOf(LiscenceEditText.getText().toString()));
                    car.set_branch_number(Integer.valueOf(branch));


                    new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected void onPostExecute(Void kuku) {
                            super.onPostExecute(kuku);
                            Toast.makeText(getApplicationContext(), "Added succssfully!", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        protected Void doInBackground(Void... params) {
                            DB_Manager db_manager = Factory_DBManager.getManager();
                            db_manager.addCar(Tools.CarToContentValues(car));
                            return null;
                        }
                    }.execute();



                    //CarModelEditText.setText("");
                    MilageEditText.setText("");
                    //BrachNumberEditText.setText("");
                    LiscenceEditText.setText("");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "You should enter a number where needed", Toast.LENGTH_LONG).show();
                }



            }
    });}}

