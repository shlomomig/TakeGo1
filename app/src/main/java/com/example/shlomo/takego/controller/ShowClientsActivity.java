package com.example.shlomo.takego.controller;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.shlomo.takego.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ShowClientsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_clients);

        class myadapter extends ArrayAdapter<Client>
        {
            private Context context;
            private List<Client> clientList;
            //constructor, call on creation
            public myadapter(Context context, int resource, ArrayList<Client> objects) {
                super(context, resource, objects);
                this.context = context;
                this.clientList = objects;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Client client = clientList.get(position);

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.client_layout, null);
                TextView description = (TextView) view.findViewById(R.id.description);
                TextView address = (TextView) view.findViewById(R.id.address);
                TextView bedroom = (TextView) view.findViewById(R.id.bedroom);
                TextView bathroom = (TextView) view.findViewById(R.id.bathroom);
                TextView carspot = (TextView) view.findViewById(R.id.carspot);
                TextView price = (TextView) view.findViewById(R.id.price);
                //ImageView image = (ImageView) view.findViewById(R.id.image);
                address.setText(client.get_email());
                price.setText("$" + Integer.valueOf(client.get_id()));

                //int imageID = context.getResources().getIdentifier(property.getImage(), "drawable", context.getPackageName());
                //image.setImageResource(imageID);
                return view;
            }
        }
        DB_Manager db_manager=Factory_DBManager.getManager();
        ListView listView=(ListView)findViewById(R.id.clientList);
        ArrayAdapter<Client> adapter = new myadapter(this, 0, db_manager.getClients());
        listView.setAdapter(adapter);

    }
}
