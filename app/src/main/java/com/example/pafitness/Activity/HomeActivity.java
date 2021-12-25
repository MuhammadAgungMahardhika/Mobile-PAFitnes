package com.example.pafitness.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pafitness.Adapter.Adapter;
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.R;
import com.example.pafitness.Rest.ApiClient;
import com.example.pafitness.Rest.ApiInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    private SearchView searchView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<GetFitnes> fitnes;
    FirebaseAuth mAuth;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Notification intent
//        FloatingActionButton Notification = (FloatingActionButton) findViewById(R.id.buttonNotification);
//
//        Notification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(HomeActivity.this,NotificationActivity.class);
//                HomeActivity.this.startActivity(intent2);
//
//            }
//        });
        //Home intent
        ImageButton home = (ImageButton) findViewById(R.id.homeButton);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomeActivity.this,HomeActivity.class);
                HomeActivity.this.startActivity(intent2);

            }
        });

        //Arroundyou intent
        ImageButton arroundYou = (ImageButton) findViewById(R.id.arroundYouButton);

        arroundYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomeActivity.this,MapsActivity.class);
                HomeActivity.this.startActivity(intent2);

            }
        });

        //Profile intent
        ImageButton profile = (ImageButton) findViewById(R.id.profileButton);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomeActivity.this,ProfileActivity.class);
                HomeActivity.this.startActivity(intent2);

            }
        });

        //Retrofit Recycler View

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        callRetrofit();


    }

    //menghubungi server
    private void callRetrofit() {
        //membuat object retrofit
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<GetFitnes>> call = apiInterface.getFitnes();

        call.enqueue(new Callback<List<GetFitnes>>() {
            @Override
            public void onResponse(Call<List<GetFitnes>> call, Response<List<GetFitnes>> response) {

                if (response.isSuccessful()){
                    List<GetFitnes> get = response.body();
                    adapter = new Adapter(HomeActivity.this, get);
                    recyclerView.setAdapter(adapter);

                    return;

                }else{

                }
            }

            @Override
            public void onFailure(Call<List<GetFitnes>> call, Throwable t) {

            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}