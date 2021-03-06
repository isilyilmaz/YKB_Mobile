package com.example.kemalcanakyol.ykb_mobile;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PaymentInfoActivity extends Activity {


    private RecyclerView recycler_view;
    private List<CreditCard> credit_card_list;
    private TextView tarih;
    private TextView geriSayim;
    private TextView tutar_cvp;
    private Button btnOnayClicked;
    private Button btnBackClicked;

    private LinearLayout layout;
    private ActionBarContainer actionBar;
    private Toolbar toolbar;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Toast.makeText(this,"geriye basıldı",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);

getActionBar().setTitle("Qr Code İle Ödeme Ekranı");
getActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        layout = findViewById(R.id.layout);

        layout.setBackgroundColor(Color.WHITE);

       /* toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My titl");*/



        Activity activity = this;
        /*Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar2);
        if (toolbar != null) {
            activity.setTitle("Title");
        }
       // toolbar.setTitle("QR Kod ile Ödeme");

        btnBackClicked = findViewById(R.id.btnBackClicked);

        btnBackClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentInfoActivity.this, LoginActivity.class);
               // intent.putExtra("barcode",getIntent().getStringExtra("barcode"));
                startActivity(intent);

            }
        });
*/



        btnOnayClicked = findViewById(R.id.btnOnayClicked);

        btnOnayClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentInfoActivity.this, CheckMarkActivity.class);
                intent.putExtra("barcode",getIntent().getStringExtra("barcode"));
                startActivity(intent);

            }
        });

        tarih = findViewById(R.id.islem_tarihi_cvp);
        tarih.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date())+"");
        tutar_cvp = findViewById(R.id.tutar_cvp);

        tutar_cvp.setText(getIntent().getStringExtra("barcode"));


        geriSayim = findViewById(R.id.timer_cvp);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                geriSayim.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                geriSayim.setText("done!");
            }
        }.start();

        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);

        recycler_view.setLayoutManager(layoutManager);

        credit_card_list = new ArrayList<CreditCard>();



        credit_card_list.add(new CreditCard("MasterCard", "89584******4387", R.drawable.mastercard_transparent));
        credit_card_list.add(new CreditCard("Visa", "4937********6784", R.drawable.visa_transparent));
        credit_card_list.add(new CreditCard("Kredi Kartı", "9865********1234", R.drawable.american_express));


        SimpleRecyclerAdapter adapter_items = new SimpleRecyclerAdapter(credit_card_list, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.d("position", "Tıklanan Pozisyon:" + position);
                CreditCard creditCard = credit_card_list.get(position);
                Toast.makeText(getApplicationContext(),"pozisyon:"+" "+position+" "+"Ad:"+creditCard.getCardName(),Toast.LENGTH_SHORT).show();
            }
        });
        recycler_view.setHasFixedSize(true);

        recycler_view.setAdapter(adapter_items);

        recycler_view.setItemAnimator(new DefaultItemAnimator());


    }




}
