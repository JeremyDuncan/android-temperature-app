package com.example.introandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_results);

        Intent intent = getIntent();
        String season = intent.getStringExtra("season");
        int temperature = intent.getIntExtra("temperature", 70);
        String allergies = intent.getStringExtra("allergies");

        TextView txtSeason = (TextView) findViewById(R.id.txtSeason);
        TextView txtTemperature = (TextView) findViewById(R.id.txtTemperature);
        TextView txtAllergies = (TextView) findViewById(R.id.txtAllergies);
        txtSeason.setText("Your favorite season is " + season);
        txtTemperature.setText("Your favorite temperature is " + temperature);

        if (allergies.equals("yes")) {
            txtAllergies.setText("Sorry that you have allergies");
        } else {
            txtAllergies.setText("You don't have allergies");
        }

        Button btnMain = (Button) findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMain();
            }
        });
    }

    private void goMain() {
        Intent intent = new Intent(InformationResultsActivity.this, MainMenuActivity.class);
        this.startActivity(intent);
    }
}
