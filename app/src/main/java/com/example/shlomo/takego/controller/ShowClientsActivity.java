package com.example.shlomo.takego.controller;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
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
import com.example.shlomo.takego.model.entities.Car;
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
                View view = inflater.inflate(R.layout.client_layout2, null);
                TextView id = (TextView) view.findViewById(R.id.id);
                TextView first = (TextView) view.findViewById(R.id.first_name);
                TextView last = (TextView) view.findViewById(R.id.last);
                TextView email = (TextView) view.findViewById(R.id.email);
                TextView phone = (TextView) view.findViewById(R.id.phone);
                //ImageView image = (ImageView) view.findViewById(R.id.image);
                id.setText(String.valueOf(client.get_id()));
                first.setText("First name: " +client.get_first_name());
                last.setText("Last name: "+client.get_last_name());
                email.setText("Email: " +client.get_email());
                phone.setText("Phone number: " +client.get_phone_number());
                //int imageID = context.getResources().getIdentifier(property.getImage(), "drawable", context.getPackageName());
                //image.setImageResource(imageID);
                return view;
            }
        }
        final ListView listView=(ListView)findViewById(R.id.clientList);
        new AsyncTask<Void, Void, ArrayAdapter<Client>>() {
            @Override
            protected void onPostExecute(ArrayAdapter<Client> adapter) {
                super.onPostExecute(adapter);

                listView.setAdapter(adapter);
            }

            @Override
            protected ArrayAdapter<Client> doInBackground(Void... params) {
                DB_Manager db_manager= Factory_DBManager.getManager();
                ArrayAdapter<Client> adapter = new myadapter(ShowClientsActivity.this, 0, db_manager.getClients());
                return adapter;
            }
        }.execute();



    }
}
