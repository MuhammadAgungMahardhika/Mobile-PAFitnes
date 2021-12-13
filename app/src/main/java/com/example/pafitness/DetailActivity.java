package com.example.pafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView text_judul , text_alamat;
    ImageView fotofitnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        text_judul = findViewById(R.id.text_judul);
        text_alamat = findViewById(R.id.text_alamat);
        fotofitnes = findViewById(R.id.image_fitness);

        RecyclerModel model = getIntent().getParcelableExtra("RecyclerModel");
        text_alamat.setText(model.getAddress());
        text_judul.setText(model.getName());
        fotofitnes.setImageResource(model.getFitness());

    }
}