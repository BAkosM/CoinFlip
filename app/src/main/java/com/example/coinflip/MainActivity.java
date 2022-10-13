package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView coin;
    private Button btnfej;
    private Button btniras;
    private TextView dobasok;
    private TextView gyozelem;
    private TextView vereseg;
    private int tipp;
    private Random rnd;
    private int erme;
    private int db;
    private int gydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();
    }
    private void init(){
        btnfej = findViewById(R.id.fej);
        btniras = findViewById(R.id.iras);
        rnd = new Random();
        coin = findViewById(R.id.coin);
        dobasok = findViewById(R.id.dobasok);
        gyozelem = findViewById(R.id.gyozelem);
        vereseg = findViewById(R.id.vereseg);
        db = 0;
        gydb = 0;
    }
    private void addListeners(){
        btnfej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 0;
                erme = rnd.nextInt(2);
                if(erme == 0){
                    coin.setImageResource(R.drawable.heads);
                }else{
                    coin.setImageResource(R.drawable.tails);
                }
                db++;
                dobasok.setText("Dobások: "+db);
                if(tipp == erme){
                    gydb++;
                    gyozelem.setText("Győzelem: "+gydb);
                }else{
                    vereseg.setText("Veresség: "+(db-gydb));
                }
            }
        });
        btniras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 1;
                erme = rnd.nextInt(2);
                if(erme == 0){
                    coin.setImageResource(R.drawable.heads);
                }else{
                    coin.setImageResource(R.drawable.tails);
                }
                db++;
                dobasok.setText("Dobások: "+db);
                if(tipp == erme){
                    gydb++;
                    gyozelem.setText("Győzelem: "+gydb);
                }else{
                    vereseg.setText("Veresség: "+(db-gydb));
                }
            }
        });
    }
}