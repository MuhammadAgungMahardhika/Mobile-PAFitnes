package com.example.pafitness.Activity;

import static android.os.Build.VERSION_CODES.O;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import com.example.pafitness.Model.PostBooking;
import com.example.pafitness.R;
import com.example.pafitness.Rest.ApiClient;
import com.example.pafitness.Rest.ApiInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    TextView  nama_fitnes , alamat_fitnes , fasilitas  , harga_perbulan,no_fitnes, jam_buka ;
    ImageView gambar_fitnes;
//  public TextView tanggal;
    private Spinner spBulan;

    //id channel notification
    private static final String CHANNEL_ID = "com.pafitnes.herokuapp.CH01";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //spinner bulan
        spBulan = findViewById(R.id.sp_bulan);

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
        harga_perbulan.setText("Price/Month -> Rp."+harga_perbulan_string);
        no_fitnes.setText("Contact Person -> +62 "+no_fitnes_string);
        jam_buka.setText("Operational time -> "+model.getJamBuka());

//menambil gambar

        Glide.with(this)
                .load(gambar_fitness)
                .into(gambar_fitnes);

        Button btBook = (Button) findViewById(R.id.button_book);
        btBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification();
                Toast.makeText(DetailActivity.this, "Selected "+ spBulan.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //Firebase subscription
        FirebaseMessaging.getInstance().subscribeToTopic("Update");

        //Firebase token
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isSuccessful()){
                    String token = task.getResult();
                    Log.d("fcm-token",token);

                }
            }
        });
    }

    //membuat notification
    private void showNotification() {
        //Ambil objeck notification
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);


        //buat channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID,
                            "Channel Fitnes",
                            NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        //buat pending intent
        Intent notificationIntent = new Intent(this,NotificationActivity.class);

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity(
          this,
          123,
          notificationIntent,
          PendingIntent.FLAG_UPDATE_CURRENT

        );

        //buat notifikasi
        NotificationCompat.Builder builder =  new
                NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_meeting_room_24)
                .setContentTitle("Succes booking class")
                .setContentText("You have succesfull booking the class")
                .setContentIntent(pendingNotificationIntent)
                .addAction(R.drawable.ic_baseline_remove_red_eye_24,"Check",pendingNotificationIntent);


        Notification notification = builder.build();

        //tampilkan notifikasi
        notificationManager.notify(123,notification);


    }


    //booking fitnes

//    private void postBooking() {
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//
//        String userID = mAuth.getCurrentUser().getUid();
//        Call<PostBooking> call = apiInterface.postBooking( idFitnes.getText().,userID);
//
//        call.enqueue(new Callback<PostBooking>() {
//            @Override
//            public void onResponse(Call<PostBooking> call, Response<PostBooking> response) {
//                if (response.isSuccessful()){
//                    Toast.makeText(DetailActivity.this, "Succesfull booking out ",
//                            Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PostBooking> call, Throwable t) {
//
//            }
//        });
//
//
//
//    }

    // pilih tanggal fitnes

//    public void showDatePickerDialog(View v) {
//        DialogFragment newFragment = new DatePickerFragment();
//        newFragment.show(getSupportFragmentManager(), "datePicker");
//
//
//
//    }


}