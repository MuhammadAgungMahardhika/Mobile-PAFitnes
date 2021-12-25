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
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHolder>{


    private final Context context;
    private final List<GetFitnes> fitnesList;

    //konstruktor
    public Adapter(Context context , List<GetFitnes> fitnesList){
        this.context = context;
        this.fitnesList = fitnesList;
    }

    @NonNull
    @Override
    public Adapter.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_activity, parent, false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterHolder holder, int position) {
        final GetFitnes getFitnes = fitnesList.get(position);

        String nama_fitnes = getFitnes.getNamaFitnes();
        String alamat_fitnes = getFitnes.getAlamatFitnes();
        String fasilitas = getFitnes.getFasilitas();
        Integer harga_perbulan = getFitnes.getHargaPerbulan();
        String jam_buka = getFitnes.getJamBuka();
        String gambar_fitnes = getFitnes.getGambarFitnes();

        holder.nama_fitnes.setText(nama_fitnes);
        holder.alamat_fitnes.setText(alamat_fitnes);

        Glide.with(holder.itemView.getContext())
                .load(gambar_fitnes)
                .apply(new RequestOptions().fitCenter())
                .into(holder.gambar_fitnes);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("GetFitnes", (Parcelable) getFitnes);
                holder.itemView.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return fitnesList.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {

        TextView nama_fitnes;
        TextView alamat_fitnes;
        ImageView gambar_fitnes;

        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            nama_fitnes = itemView.findViewById(R.id.text_judul);
            alamat_fitnes = itemView.findViewById(R.id.text_alamat);
            gambar_fitnes = itemView.findViewById(R.id.image_fitness);
        }
    }
}
