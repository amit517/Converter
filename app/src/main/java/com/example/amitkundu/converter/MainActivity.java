package com.example.amitkundu.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.currency).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent currencyIntent = new Intent(MainActivity.this,currency.class);
                startActivity(currencyIntent);

            }
        });

        findViewById(R.id.temp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent temp = new Intent(MainActivity.this,Temperature.class);
                startActivity(temp);
            }
        });

        findViewById(R.id.weight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weight = new Intent(MainActivity.this,WeightConverter.class);
                startActivity(weight);
            }
        });


    }
}
