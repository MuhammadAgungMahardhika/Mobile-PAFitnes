package com.example.pafitness.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.R;

import java.util.Calendar;

public class DetailActivity extends AppCompatActivity {

    TextView nama_fitnes , alamat_fitnes , fasilitas  , harga_perbulan,no_fitnes, jam_buka ;
    ImageView gambar_fitnes;
//    public TextView tanggal;
    private Spinner spBulan;


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

        spBulan = findViewById(R.id.sp_bulan);

        gambar_fitnes = findViewById(R.id.image_fitness);


//       tanggal = findViewById(R.id.tanggal);


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
        harga_perbulan.setText("Price/Month -> Rp."+harga_perbulan_string);
        no_fitnes.setText("Contact Person -> +62 "+no_fitnes_string);
        jam_buka.setText("Operational time -> "+model.getJamBuka());



        Glide.with(this)
                .load(gambar_fitness)
                .into(gambar_fitnes);

        Button btBook = (Button) findViewById(R.id.button_book);
        btBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(DetailActivity.this, "Selected "+ spBulan.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


//    public void showDatePickerDialog(View v) {
//        DialogFragment newFragment = new DatePickerFragment();
//        newFragment.show(getSupportFragmentManager(), "datePicker");
//
//
//
//    }


}