package com.johnotu.apps.cheddermobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button initiateTransferButton = (Button) findViewById(R.id.initiate_transfer);

        initiateTransferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Initiate a new transfer", Toast.LENGTH_LONG).show();
                Intent initiatetransfer = new Intent(v.getContext(), InitiateTransferActivity.class);
                startActivity(initiatetransfer);
            }
        });
    }
}
