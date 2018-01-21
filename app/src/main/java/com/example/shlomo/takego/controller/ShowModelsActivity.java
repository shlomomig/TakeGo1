package com.example.shlomo.takego.controller;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shlomo.takego.R;
import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.backend.Factory_DBManager;
import com.example.shlomo.takego.model.entities.Car;
import com.example.shlomo.takego.model.entities.CarModel;

import java.util.ArrayList;
import java.util.List;

public class ShowModelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_models);
        class myadapter extends ArrayAdapter<CarModel>
        {
            private Context context;
            private List<CarModel> carModelsList;
            //constructor, call on creation
            public myadapter(Context context, int resource, ArrayList<CarModel> objects) {
                super(context, resource, objects);
                this.context = context;
                this.carModelsList = objects;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                CarModel carModel = carModelsList.get(position);

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.car_model_layout, null);
                TextView id = (TextView) view.findViewById(R.id.carmodeloflayout);
               // TextView liscence = (TextView) view.findViewById(R.id.liscencenumber);
                //TextView milage = (TextView) view.findViewById(R.id.milage);
                //TextView branch = (TextView) view.findViewById(R.id.brachnumber);
                //ImageView image = (ImageView) view.findViewById(R.id.image);
                id.setText("Car model: " + String.valueOf(carModel.get_model_code()));
                //liscence.setText("Liscence:" +car.get_liscene_number());
                //milage.setText("Milage:"+car.get_milage());
                //branch.setText("Brach:"+ car.get_branch_number());

                //int imageID = context.getResources().getIdentifier(property.getImage(), "drawable", context.getPackageName());
                //image.setImageResource(imageID);
                return view;
            }
        }
            final ListView listView=(ListView)findViewById(R.id.modelList);
            new AsyncTask<Void, Void, ArrayAdapter<CarModel>>() {
            @Override
            protected void onPostExecute(ArrayAdapter<CarModel> adapter) {
                super.onPostExecute(adapter);

                listView.setAdapter(adapter);
            }

            @Override
            protected ArrayAdapter<CarModel> doInBackground(Void... params) {
                DB_Manager db_manager= Factory_DBManager.getManager();
                ArrayAdapter<CarModel> adapter = new myadapter(ShowModelsActivity.this, 0, db_manager.getCarModels());
                return adapter;
            }
        }.execute();


    }
}
