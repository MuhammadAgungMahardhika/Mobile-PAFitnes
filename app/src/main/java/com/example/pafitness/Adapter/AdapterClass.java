package com.example.pafitness.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pafitness.Activity.DetailActivity;
import com.example.pafitness.Model.GetBookingClass;
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.R;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.AdapterHolders>{


    private final Context context;
    private final List<GetBookingClass> classList;

    //konstruktor
    public AdapterClass(Context context , List<GetBookingClass> classList){
        this.context = context;
        this.classList = classList;
    }

    @NonNull
    @Override
    public AdapterClass.AdapterHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_activity2, parent, false);
        return new AdapterHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.AdapterHolders holder, int position) {
        final GetBookingClass getBookingClass = classList.get(position);

        String nama_fitnes = getBookingClass.getNamaFitnes();
        String alamatFitnes = getBookingClass.getAlamatFitnes();
        Integer harga_perbulan = getBookingClass.getHargaPerbulan();
        String tanggal_booking = getBookingClass.getTanggalBooking();

        holder.nama_fitnes.setText(nama_fitnes);
        holder.alamat_fitnes.setText(alamatFitnes);
        holder.tanggal_booking.setText(tanggal_booking);



    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    public class AdapterHolders extends RecyclerView.ViewHolder {

        TextView nama_fitnes;
        TextView alamat_fitnes;
        TextView harga_perbulan;
        TextView tanggal_booking;

        public AdapterHolders(@NonNull View itemView) {
            super(itemView);
            nama_fitnes = itemView.findViewById(R.id.text_judul1);
            alamat_fitnes = itemView.findViewById(R.id.text_alamat1);
            harga_perbulan = itemView.findViewById(R.id.harga_perbulan1);
            tanggal_booking = itemView.findViewById(R.id.tanggal_perbulan1);
        }
    }
}
