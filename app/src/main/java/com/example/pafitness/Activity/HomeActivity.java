package com.example.pafitness.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SearchView;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pafitness.Adapter.Adapter;
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.R;
import com.example.pafitness.Rest.ApiClient;
import com.example.pafitness.Rest.ApiInterface;




import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    private SearchView searchView;
    RecyclerView.LayoutManager layoutManager;
     ProgressBar pb;
     int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //set progres bar
        probar();

        //Home intent
        ImageButton home = findViewById(R.id.homeButton);

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

    private void probar() {
        pb = (ProgressBar) findViewById(R.id.pb);

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


// MENU HOME
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.buttonNotification:
                Intent intent2 = new Intent(HomeActivity.this,NotificationActivity.class);
                HomeActivity.this.startActivity(intent2);
                return true;
            case R.id.search:

                return true;
            case R.id.button_class:
                Intent intent3 = new Intent(HomeActivity.this,NotificationActivity.class);
                HomeActivity.this.startActivity(intent3);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}