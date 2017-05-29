package com.johnotu.apps.cheddermobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class InitiateTransferActivity extends AppCompatActivity {

    private Spinner countryspinner, bankspinner;
    private Button confirmTransferButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initiate_transfer);

        countryspinner = (Spinner) findViewById(R.id.country_spinner);
        ArrayAdapter<CharSequence> countryadapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_dropdown_item);
        countryspinner.setAdapter(countryadapter);

        countryspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCountry = (String) parent.getItemAtPosition(position);
                setCountry(selectedCountry);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bankspinner = (Spinner) findViewById(R.id.bank_spinner);
        setCountry("");

        confirmTransferButton = (Button) findViewById(R.id.confirm_transfer);

        confirmTransferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Please confirm the transaction details", Toast.LENGTH_LONG).show();
                Intent confirmtransfer = new Intent(v.getContext(), ConfirmTransactionActivity.class);
                startActivity(confirmtransfer);
            }
        });



    }

    private void setCountry (String country){
        Log.d("setCountry active", country);
        int countryBanks;
        switch(country){
            case "Kenya":
                countryBanks = R.array.banksKE;
                break;
            case "Ghana":
                countryBanks = R.array.banksGH;
                break;
            case "Nigeria":
            default:
                countryBanks = R.array.banksNG;
                break;
        }
        ArrayAdapter<CharSequence> bankadapter = ArrayAdapter.createFromResource(this, countryBanks, android.R.layout.simple_spinner_dropdown_item);
        bankspinner.setAdapter(bankadapter);
    }
}
