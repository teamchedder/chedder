package com.johnotu.apps.cheddermobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.bluelinelabs.logansquare.LoganSquare;
import com.johnotu.apps.cheddermobile.models.TransferRequest;

public class InitiateTransferActivity extends AppCompatActivity {

    private Spinner countryspinner, bankspinner;
    private Button confirmTransferButton;
    private RadioGroup receiverType;
    private EditText accountNumber, amountToSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initiate_transfer);

        accountNumber = (EditText) findViewById(R.id.recipient_account);
        amountToSend = (EditText) findViewById(R.id.amount_to_send);
        receiverType = (RadioGroup) findViewById(R.id.receiver_type);

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
            startTransaction();
            }
        });
    }

    private void startTransaction (){
        String selectedType;


        int selectedId = receiverType.getCheckedRadioButtonId();
        if(validReceiverSelected(selectedId))
        {
            RadioButton selectedButton = (RadioButton) findViewById(selectedId);
            selectedType = selectedButton.getText().toString();
        } else {
            //TODO:show error
        }

        String country = (String) countryspinner.getSelectedItem();
        String bank = (String) bankspinner.getSelectedItem();
        String accountNumberStr = accountNumber.getText().toString();
        float amountToSendFlt = Float.parseFloat(amountToSend.getText().toString());  //TODO: Validate me to prevent crash

        TransferRequest request = new TransferRequest(amountToSendFlt);

    }

    private boolean validReceiverSelected(int selectedId){
        return selectedId != -1;
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
