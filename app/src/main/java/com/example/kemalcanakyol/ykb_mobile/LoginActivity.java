package com.example.kemalcanakyol.ykb_mobile;

import android.app.ActionBar;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button rocketButton,closeButton,payButton;
    private ConstraintLayout mLayout;


    private void init(){
        rocketButton = findViewById(R.id.rocketButtonId);
        mLayout = findViewById(R.id.mainLayoutId);
        closeButton = findViewById(R.id.closeButton);
        payButton = findViewById(R.id.payButtonId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        rocketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rocketButton.setVisibility(View.GONE);
                mLayout.setBackgroundResource(R.drawable.image2);
                closeButton.setVisibility(View.VISIBLE);
                payButton.setVisibility(View.VISIBLE);
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rocketButton.setVisibility(View.VISIBLE);
                mLayout.setBackgroundResource(R.drawable.ykb_vp);
                closeButton.setVisibility(View.GONE);

            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });



    }

    public void onButtonClicked(View v) {


        startActivity(new Intent(this,MainActivity.class));
    }
}

