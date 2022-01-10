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
import com.example.pafitness.Model.GetBookingClass;
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.Model.GetLocation;
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


    }

//    private void getMap() {
//
//            //membuat object retrofit
//            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//            Call<List<GetLocation>> call = apiInterface.getLocation();
//
//            call.enqueue(new Callback<List<GetLocation>>() {
//                @Override
//                public void onResponse(Call<List<GetLocation>> call, Response<List<GetLocation>> response) {
//             //dapatkan hasil parsing dari method response.body()
//                    if (response.isSuccessful()){
//
//                        List<GetLocation> get = response.body();
//
//                    }
//
//
//
//                }
//
//                @Override
//                public void onFailure(Call<List<GetLocation>> call, Throwable t) {
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

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 11));
                            googleMap.addMarker(options);

                            //1
                            LatLng Gsport = new LatLng(-0.911293, 100.3624588);
                            googleMap.addMarker(new MarkerOptions().position(Gsport).title("G Sport Center Gym"));

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Gsport, 11));
                            googleMap.addMarker(options);

                            //2
                            LatLng sydney = new LatLng(-0.911293, 100.3624588);
                            googleMap.addMarker(new MarkerOptions().position(sydney).title("G Sport Center Gym"));

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 11));
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