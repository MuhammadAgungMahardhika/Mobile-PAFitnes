package com.example.pafitness.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.pafitness.Adapter.Adapter;
import com.example.pafitness.Adapter.AdapterClass;
import com.example.pafitness.Model.GetBookingClass;
import com.example.pafitness.R;
import com.example.pafitness.Rest.ApiClient;
import com.example.pafitness.Rest.ApiInterface;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ApiInterface apiInterface;
    RecyclerView.LayoutManager layoutManager;
    AdapterClass adapterClass;
    ProgressBar pb;
    int counter = 0;
    FirebaseAuth mAuth;
    String id_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        pb = (ProgressBar) findViewById(R.id.pb2);
        //set progres bar
        probar();

        //firebase
        mAuth = FirebaseAuth.getInstance();

        id_user = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();


        //Retrofit Recycler View

        recyclerView = findViewById(R.id.recycler_view2);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        callRetrofit();

    }

    private void probar() {
        pb = (ProgressBar) findViewById(R.id.pb2);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);
                if (counter==100)
                    t.cancel();



            }
        };
        t.schedule(tt,0,100);
    }

    //menghubungi server
    private void callRetrofit() {
        //membuat object retrofit
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<GetBookingClass>> call = apiInterface.getBookingClass(id_user);

        call.enqueue(new Callback<List<GetBookingClass>>() {
            @Override
            public void onResponse(Call<List<GetBookingClass>> call, Response<List<GetBookingClass>> response) {

                if (response.isSuccessful()){

                    List<GetBookingClass> gets = response.body();
                    adapterClass = new AdapterClass(ClassActivity.this,gets);
                    recyclerView.setAdapter(adapterClass);

                }
            }

            @Override
            public void onFailure(Call<List<GetBookingClass>> call, Throwable t) {

            }



        });



    }

}