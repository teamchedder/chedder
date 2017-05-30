package com.johnotu.apps.cheddermobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.johnotu.apps.cheddermobile.adapters.TransactionHistoryAdapter;
import com.johnotu.apps.cheddermobile.models.TransactionItem;

import java.util.ArrayList;
import java.util.Arrays;

public class TransactionHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        RecyclerView rvItems = (RecyclerView) findViewById(R.id.transaction_history);

        ArrayList<TransactionItem> items = TransactionItem.genItems();

        TransactionHistoryAdapter adapter = new TransactionHistoryAdapter(this, items);

        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
    }
}
