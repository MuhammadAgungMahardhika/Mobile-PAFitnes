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

    TextView nama_fitnes , alamat_fitnes , fasilitas  , harga_perbulan,no_fitnes, jam_buka ;
    ImageView gambar_fitnes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama_fitnes = findViewById(R.id.text_judul);
        alamat_fitnes = findViewById(R.id.text_alamat);
        fasilitas = findViewById(R.id.text_fasilitas);
        harga_perbulan = findViewById(R.id.text_harga_perbulan);
        no_fitnes = findViewById(R.id.text_no_fitnes);
        jam_buka = findViewById(R.id.text_jam_buka);


        gambar_fitnes = findViewById(R.id.image_fitness);

        GetFitnes model = getIntent().getParcelableExtra("GetFitnes");
        String gambar_fitness = model.getGambarFitnes();

        //convert harga perbulan to string
        Integer harga_tukar = model.getHargaPerbulan();
        String harga_perbulan_string =  harga_tukar.toString();

        //convert no fitnes
        Integer no_tukar = model.getNoFitnes();
        String no_fitnes_string = no_tukar.toString();

        nama_fitnes.setText(model.getNamaFitnes());
        alamat_fitnes.setText( model.getAlamatFitnes());
        fasilitas.setText(model.getFasilitas());
        harga_perbulan.setText(harga_perbulan_string);
        no_fitnes.setText(no_fitnes_string);
        jam_buka.setText("Jam operasi : "+model.getJamBuka());


        Glide.with(this)
                .load(gambar_fitness)
                .into(gambar_fitnes);



    }
}