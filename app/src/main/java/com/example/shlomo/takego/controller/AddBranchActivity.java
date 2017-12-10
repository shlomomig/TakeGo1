package com.example.shlomo.takego.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class AddBranchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);

        Button addButton=(Button)findViewById(R.id.addBranchButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText branchNumberEditText = (EditText)findViewById(R.id.BranchNumberEditText);
                EditText cityEditText = (EditText)findViewById(R.id.CityEditText);
                EditText streetEditText = (EditText)findViewById(R.id.StreetEditText);
                EditText parkingSpotsEditText=(EditText)findViewById(R.id.ParkingSpotseEditText) ;

                Branch branch=new Branch();
                try {
                    branch.set_branch_number(Integer.valueOf(branchNumberEditText.getText().toString()));
                    branch.set_city(cityEditText.getText().toString());
                    branch.set_parking_spots(Integer.valueOf(parkingSpotsEditText.getText().toString()));
                    branch.set_street(streetEditText.getText().toString());
                    DB_Manager db_manager = Factory_DBManager.getManager();
                    db_manager.addBranch(Tools.BranchToContentValues(branch));
                    Toast.makeText(getApplicationContext(), "Added succssfully!", Toast.LENGTH_LONG).show();

                    //CarModelEditText.setText("");
                    branchNumberEditText.setText("");
                    cityEditText.setText("");
                    streetEditText.setText("");
                    parkingSpotsEditText.setText("");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "You should enter a number where needed", Toast.LENGTH_LONG).show();
                }



            }
        });}}

