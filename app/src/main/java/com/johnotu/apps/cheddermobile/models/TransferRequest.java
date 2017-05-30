package com.johnotu.apps.cheddermobile.models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by John Otu on 5/29/2017.
 */
public class TransferRequest {
    public TransferRequest(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double totalAmount;
}
