package com.example.shlomo.takego.controller;

import android.app.Activity;
import android.content.Context;
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
import com.example.shlomo.takego.model.entities.Branch;
import com.example.shlomo.takego.model.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class ShowBranchesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_branches);

        class myadapter extends ArrayAdapter<Branch>
        {
            private Context context;
            private List<Branch> branchList;
            //constructor, call on creation
            public myadapter(Context context, int resource, ArrayList<Branch> objects) {
                super(context, resource, objects);
                this.context = context;
                this.branchList = objects;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Branch branch = branchList.get(position);

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.branch_layout, null);
                TextView branchNumber = (TextView) view.findViewById(R.id.branchNumber_forlist);
                TextView city = (TextView) view.findViewById(R.id.city_forlist);
                TextView street = (TextView) view.findViewById(R.id.street_forlist);
                TextView parkingSpots = (TextView) view.findViewById(R.id.parkingSpots_forlist);
                //ImageView image = (ImageView) view.findViewById(R.id.image);
                branchNumber.setText("Branch number:" + String.valueOf(branch.get_branch_number()));
                city.setText("City:" +branch.get_city());
                street.setText("Street:"+branch.get_street());
                parkingSpots.setText("Parking spots:"+ branch.get_parking_spots());
                return view;
            }
        }
        DB_Manager db_manager= Factory_DBManager.getManager();
        ListView listView=(ListView)findViewById(R.id.branchesList);
        ArrayAdapter<Branch> adapter = new myadapter(this, 0, db_manager.getBranchess());
        listView.setAdapter(adapter);

    }
    }

