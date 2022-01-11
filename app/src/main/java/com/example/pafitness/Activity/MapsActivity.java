package com.example.pafitness.Activity;



import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity {



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


                            //membuat object retrofit
                            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

                            Call<List<GetLocation>> call = apiInterface.getLocation();


                            call.enqueue(new Callback<List<GetLocation>>() {
                                @Override
                                public void onResponse(Call<List<GetLocation>> call, Response<List<GetLocation>> response) {
                                    //dapatkan hasil parsing dari method response.body()
                                    if (response.isSuccessful()){
                                        for (GetLocation getLocation:response.body()){
                                            String nama_fitnes = getLocation.getNamaFitnes();
                                            String jam_buka = getLocation.getJamBuka();
                                            String lat = getLocation.getLat();
                                            String lng = getLocation.getLng();

                                            LatLng Koordinat = new LatLng( Double.parseDouble(lat),Double.parseDouble(lng));
                                            googleMap.addMarker(new MarkerOptions().position(Koordinat).
                                                    title(nama_fitnes).snippet(jam_buka));

                                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Koordinat, 11));
                                            googleMap.addMarker(options);

                                        }

                                    }


                                }

                                @Override
                                public void onFailure(Call<List<GetLocation>> call, Throwable t) {
                                    Toast.makeText(MapsActivity.this, "Failed to load map" + t.getMessage(), Toast.LENGTH_SHORT).show();

                                }


                            });


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