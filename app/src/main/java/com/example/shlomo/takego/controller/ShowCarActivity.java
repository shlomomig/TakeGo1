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
import com.example.shlomo.takego.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ShowCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_car);

        class myadapter extends ArrayAdapter<Car>
        {
            private Context context;
            private List<Car> carList;
            //constructor, call on creation
            public myadapter(Context context, int resource, ArrayList<Car> objects) {
                super(context, resource, objects);
                this.context = context;
                this.carList = objects;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Car car = carList.get(position);

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.car_layout, null);
                TextView carModel = (TextView) view.findViewById(R.id.carmodel);
                TextView liscence = (TextView) view.findViewById(R.id.liscencenumber);
                TextView milage = (TextView) view.findViewById(R.id.milage);
                TextView branch = (TextView) view.findViewById(R.id.branchnumber);
                //ImageView image = (ImageView) view.findViewById(R.id.image);
                carModel.setText("Car model :" + String.valueOf(car.get_car_model()));
                liscence.setText("Liscence: " +car.get_liscene_number());
                milage.setText("Milage: "+car.get_milage());
                branch.setText("Branch: "+ car.get_branch_number());

                //int imageID = context.getResources().getIdentifier(property.getImage(), "drawable", context.getPackageName());
                //image.setImageResource(imageID);
                return view;
            }
        }

        final ListView listView=(ListView)findViewById(R.id.carList);

        new AsyncTask<Void, Void, ArrayAdapter<Car>>() {
            @Override
            protected void onPostExecute(ArrayAdapter<Car> adapter) {
                super.onPostExecute(adapter);

                listView.setAdapter(adapter);
            }

            @Override
            protected ArrayAdapter<Car> doInBackground(Void... params) {
                DB_Manager db_manager= Factory_DBManager.getManager();
                ArrayAdapter<Car> adapter = new myadapter(ShowCarActivity.this, 0, db_manager.getCars());
                return adapter;
            }
        }.execute();
    }
}
