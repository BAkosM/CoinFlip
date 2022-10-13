package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private AlertDialog.Builder builder;
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
        builder = new AlertDialog.Builder(MainActivity.this);
    }
    private void addListeners(){
        btnfej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 0;
                ermedobas(tipp);
            }
        });
        btniras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 1;
                ermedobas(tipp);
            }
        });
    }
    private void newgame(){
        db = 0;
        gydb = 0;
        dobasok.setText("Dobások: "+db);
        gyozelem.setText("Győzelem: "+gydb);
        vereseg.setText("Veresség: "+(db-gydb));
    }
    private void ermedobas(int tipp){
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
        if (db>4) {
            if (gydb > 2) {
                builder.setMessage("Győzelem!");
                builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newgame();
                    }
                });
                builder.create().show();
            } else {
                builder.setMessage("Vereség!");
                builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newgame();
                    }
                });
                builder.create().show();
            }
        }
    }
}