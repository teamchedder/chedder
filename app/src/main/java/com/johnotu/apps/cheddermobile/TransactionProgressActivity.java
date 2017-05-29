package com.johnotu.apps.cheddermobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class TransactionProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_progress);

        RotateAnimation processing;

        processing = new RotateAnimation(360f, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        processing.setInterpolator(new LinearInterpolator());
        processing.setDuration(1000);
        processing.setRepeatCount(Animation.INFINITE);

        findViewById(R.id.processing_image).startAnimation(processing);

    }
}
