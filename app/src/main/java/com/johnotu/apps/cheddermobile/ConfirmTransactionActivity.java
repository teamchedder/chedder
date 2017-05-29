package com.johnotu.apps.cheddermobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_transaction);

        Button sendMoneyButton = (Button) findViewById(R.id.send_money);

        sendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Processing request ...", Toast.LENGTH_LONG).show();
                Intent sendmoney = new Intent(v.getContext(), TransactionHistoryActivity.class);
                startActivity(sendmoney);
            }
        });
    }
}
