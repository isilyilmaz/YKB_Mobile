package com.example.kemalcanakyol.ykb_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.circulardialog.CDialog;
import com.example.circulardialog.extras.CDConstants;

public class CheckMarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_mark);

        String barcode = getIntent().getStringExtra("barcode");

        new CDialog(this).createAlert("Tutar: "+barcode,
                CDConstants.SUCCESS,   // Type of dialog
                CDConstants.LARGE)    //  size of dialog
                .setAnimation(CDConstants.SCALE_FROM_BOTTOM_TO_TOP)     //  Animation for enter/exit
                .setDuration(2000)   // in milliseconds
                .setTextSize(CDConstants.NORMAL_TEXT_SIZE)  // CDConstants.LARGE_TEXT_SIZE, CDConstants.NORMAL_TEXT_SIZE
                .show();

        new Thread(new Runnable() {

            public void run() {
                try {
                    synchronized (this) {
                        wait(2300);
                        startActivity(new Intent(CheckMarkActivity.this,LoginActivity.class));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();



    }
}