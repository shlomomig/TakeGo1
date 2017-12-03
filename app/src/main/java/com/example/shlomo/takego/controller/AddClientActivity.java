package com.example.shlomo.takego.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shlomo.takego.R;
import com.example.shlomo.takego.model.backend.DB_Manager;
import com.example.shlomo.takego.model.backend.Factory_DBManager;
import com.example.shlomo.takego.model.datasource.Tools;
import com.example.shlomo.takego.model.entities.Client;

public class AddClientActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclient);



        Button addButton=(Button)findViewById(R.id.addClientButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText IdEditText;
                EditText FirstNameEditText;
                EditText LastNameEditText;
                EditText PhoneEditText;
                EditText EMailEditText;
                EditText CreditCardEditText;
                IdEditText = (EditText)findViewById( R.id.IdEditText );
                FirstNameEditText = (EditText)findViewById( R.id.FirstNameEditText );
                LastNameEditText = (EditText)findViewById( R.id.LastNameEditText );
                PhoneEditText = (EditText)findViewById( R.id.PhoneEditText );
                EMailEditText = (EditText)findViewById( R.id.EMailEditText );
                CreditCardEditText = (EditText)findViewById( R.id.CreditCardEditText );
                        Client client=new Client();
                try{
                    client.set_id((Integer.valueOf(IdEditText.getText().toString())));
                    client.set_first_name(FirstNameEditText.getText().toString());
                    client.set_last_name(LastNameEditText.getText().toString());
                    client.set_phone_number(Integer.valueOf(PhoneEditText.getText().toString()));
                    client.set_email(EMailEditText.getText().toString());
                    client.set_credit_card(Long.valueOf(CreditCardEditText.getText().toString()));
                }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"gg",Toast.LENGTH_LONG).show();
            }


        DB_Manager db_manager= Factory_DBManager.getManager();
        db_manager.addClient(Tools.ClientToContentValues(client));
            }
        });



    }
}
