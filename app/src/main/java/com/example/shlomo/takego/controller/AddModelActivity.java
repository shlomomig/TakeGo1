package com.example.shlomo.takego.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shlomo.takego.R;
import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.backend.Factory_DBManager;
import com.example.shlomo.takego.model.datasource.Tools;
import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;
import com.example.shlomo.takego.model.entities.Geer;

public class AddModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);

        Button addButton=(Button)findViewById(R.id.addModelButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText modelCodeEditText;
                EditText companyNameEditText;
                EditText ModelNameEditText;
                EditText volumeEditText;
                EditText geerEditText;
                EditText seatNumberEditText;
                modelCodeEditText = (EditText) findViewById(R.id.modelcodeEditText);
                companyNameEditText = (EditText) findViewById(R.id.companynameEditText);
                ModelNameEditText = (EditText) findViewById(R.id.modelnameEditText);
                volumeEditText = (EditText) findViewById(R.id.volumeEditText);
                //geerEditText = (EditText) findViewById(R.id.geerEditText);
                RadioGroup geerGroup=(RadioGroup)findViewById(R.id.radioGeer);
                seatNumberEditText = (EditText) findViewById(R.id.seatnumberEditText);
//                Spinner spinner=(Spinner)findViewById(R.id.modelspinner);
//                String model=spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                CarModel carModel=new CarModel();
                try {
                    //carModel.set_geer(Geer.valueOf(geerEditText.getText().toString()));
                    int geer=geerGroup.getCheckedRadioButtonId();
                    RadioButton geerButton=(RadioButton)findViewById(geer);
                    carModel.set_geer(Geer.valueOf(geerButton.getText().toString()));
                    carModel.set_model_code(modelCodeEditText.getText().toString());
                    carModel.set_model_name(ModelNameEditText.getText().toString());
                    carModel.set_seat_number(Integer.valueOf(seatNumberEditText.getText().toString()));
                    carModel.set_engine_volume(Integer.valueOf(volumeEditText.getText().toString()));
                    carModel.set_company_name(companyNameEditText.getText().toString());

                    DB_Manager db_manager = Factory_DBManager.getManager();
                    db_manager.addCarModel(Tools.CarModelToContentValus(carModel));
                    Toast.makeText(getApplicationContext(), "Added succssfully!", Toast.LENGTH_LONG).show();
                    modelCodeEditText.setText("");
                    ModelNameEditText.setText("");
                    //geerEditText.setText("");
                    volumeEditText.setText("");
                    companyNameEditText.setText("");
                    seatNumberEditText.setText("");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "You should enter a number where needed", Toast.LENGTH_LONG).show();
                }

    }
});}}
