package com.johnotu.apps.cheddermobile.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by John Otu on 5/29/2017.
 */


public class TransactionItem {
    private String receiverName;
    private boolean isSuccessful;
    private Currency currency;
    private Date transactionDate;
    private double transactionAmount;
    private Mode transactionMode;


    public TransactionItem(String receiverName, boolean isSuccessful, Currency currency, Date transactionDate, double transactionAmount, Mode transactionMode) {
        this.receiverName = receiverName;
        this.isSuccessful = isSuccessful;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionMode = transactionMode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Mode getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(Mode transactionMode) {
        this.transactionMode = transactionMode;
    }

    public static ArrayList<TransactionItem> genItems (){
        ArrayList transactionItems = new ArrayList(Arrays.asList(
                new TransactionItem("John Doe", true, Currency.GHC, new Date(), 2500.00, Mode.BANKACCOUNT),
                new TransactionItem("Jane Johnson", true, Currency.KSH, new Date(), 1500.00, Mode.MOBILEMONEY),
                new TransactionItem("Ubong Akpan", false, Currency.NGN, new Date(), 2000.00, Mode.BANKACCOUNT)
        ));

        return transactionItems;
    }
}
