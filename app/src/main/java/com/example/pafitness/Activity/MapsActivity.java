package com.example.pafitness.Activity;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.pafitness.Adapter.Adapter;
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.R;
import com.example.pafitness.Rest.ApiClient;
import com.example.pafitness.Rest.ApiInterface;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.pafitness.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;
    ArrayList<GetFitnes> fitnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        client = LocationServices.getFusedLocationProviderClient(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        //cek permission
        if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
//            getMap();
        } else {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

        }


        //Home intent
        ImageButton home = (ImageButton) findViewById(R.id.homeButton);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MapsActivity.this, HomeActivity.class);
                MapsActivity.this.startActivity(intent2);

            }
        });

        //Arroundyou intent
        ImageButton arroundYou = (ImageButton) findViewById(R.id.arroundYouButton);

        arroundYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MapsActivity.this, MapsActivity.class);
                MapsActivity.this.startActivity(intent2);

            }
        });

        //Profile intent
        ImageButton profile = (ImageButton) findViewById(R.id.profileButton);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MapsActivity.this, ProfileActivity.class);
                MapsActivity.this.startActivity(intent2);

            }
        });
    }

//    private void getMap() {
//
//            //membuat object retrofit
//            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//            Call<List<GetFitnes>> call = apiInterface.getFitnes();
//
//            call.enqueue(new Callback<List<GetFitnes>>() {
//                @Override
//                public void onResponse(Call<List<GetFitnes>> call, Response<List<GetFitnes>> response) {
//
//
//
//
//                        //dapatkan hasil parsing dari method response.body()
//                    List<GetFitnes> get = response.body();
//                        String namaFitnes = response.body().
//
//
//
//                }
//
//                @Override
//                public void onFailure(Call<List<GetFitnes>> call, Throwable t) {
//
//                }
//
//
//            });
//
//        }


    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(@NonNull Location location) {
                if (location != null){
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(latlng).title("Your Location");

                            LatLng sydney = new LatLng(-33.852, 151.211);
                            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 11));
                            googleMap.addMarker(options);

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 11));
                            googleMap.addMarker(options);

                        }
                    });
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        }
    }
}