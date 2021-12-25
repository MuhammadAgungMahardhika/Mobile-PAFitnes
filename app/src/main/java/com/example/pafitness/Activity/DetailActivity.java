package com.example.pafitness.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.R;

public class DetailActivity extends AppCompatActivity {

    TextView nama_fitnes , alamat_fitnes , fasilitas , jam_buka , harga_perbulan;
    ImageView gambar_fitnes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama_fitnes = findViewById(R.id.text_judul);
        alamat_fitnes = findViewById(R.id.text_alamat);
        fasilitas = findViewById(R.id.text_fasilitas);
        harga_perbulan = findViewById(R.id.text_harga_perbulan);
        jam_buka = findViewById(R.id.text_jam_buka);


        gambar_fitnes = findViewById(R.id.image_fitness);

        GetFitnes model = getIntent().getParcelableExtra("GetFitnes");
        String gambar_fitness = model.getGambarFitnes();

        nama_fitnes.setText(model.getNamaFitnes());
        alamat_fitnes.setText( model.getAlamatFitnes());
        fasilitas.setText(model.getFasilitas());
        jam_buka.setText("Jam operasi : "+model.getJamBuka());


        Glide.with(this)
                .load(gambar_fitness)
                .into(gambar_fitnes);



    }
}