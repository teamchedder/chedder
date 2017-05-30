package com.johnotu.apps.cheddermobile.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.johnotu.apps.cheddermobile.R;
import com.johnotu.apps.cheddermobile.models.Currency;
import com.johnotu.apps.cheddermobile.models.Mode;
import com.johnotu.apps.cheddermobile.models.TransactionItem;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by John Otu on 5/29/2017.
 */

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView receiverName, transactionStatus,
                transactionCurrency, transactionAmount,
                transactionMode, transactionDate;


        public ViewHolder(View itemView) {
            super(itemView);

            receiverName = (TextView) itemView.findViewById(R.id.receiver_name);
            transactionStatus = (TextView) itemView.findViewById(R.id.transaction_status);
            transactionCurrency = (TextView) itemView.findViewById(R.id.transaction_currency);
            transactionMode = (TextView) itemView.findViewById(R.id.transaction_mode);
            transactionDate = (TextView) itemView.findViewById(R.id.transaction_date);
        }
    }

    private List<TransactionItem> mItems;
    private Context mContext;

    public TransactionHistoryAdapter(Context context, List<TransactionItem> list ) {
        mItems = list;
        mContext = context;
    }

    @Override
    public TransactionHistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.activity_transaction_history, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TransactionHistoryAdapter.ViewHolder holder, int position) {
        TransactionItem item = mItems.get(position);

        holder.receiverName.setText(item.getReceiverName());
        holder.transactionStatus.setText(item.isSuccessful() ? "Success" : "Fail");
        holder.transactionCurrency.setText(currencyHelper(item.getCurrency()));
        holder.transactionAmount.setText(String.valueOf(item.getTransactionAmount()));
        holder.transactionMode.setText(item.getTransactionMode() == Mode.BANKACCOUNT ? "BANKACCOUNT" : "MOBILEMONEY");
        SimpleDateFormat sdf = new SimpleDateFormat("d:M:y");
        holder.transactionDate.setText(sdf.format(item.getTransactionDate()));

    }

    private String currencyHelper(Currency currency){
        String currencyStr = "";
        if(currency == Currency.GHC){
            currencyStr = mContext.getString(R.string.naira);
        } else if (currency == Currency.KSH){
            currencyStr = mContext.getString(R.string.naira);
        }

        return currencyStr;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
        //return 0;
    }
}
