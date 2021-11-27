package com.example.pafitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    ArrayList<RecyclerModel> dataRecycler;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textJudul;
        TextView textAlamat;
        ImageView fotofitness;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textJudul = itemView.findViewById(R.id.text_judul);
            textAlamat = itemView.findViewById(R.id.text_alamat);
            fotofitness = itemView.findViewById(R.id.image_fitness);
        }
    }
    AdapterRecyclerView(ArrayList<RecyclerModel> data){
        this.dataRecycler = data;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {

        TextView text_judul = holder.textJudul;
        TextView text_alamat = holder.textAlamat;
        ImageView image_fitness = holder.fotofitness;

        text_judul.setText(dataRecycler.get(position).getName());
        text_alamat.setText(dataRecycler.get(position).getAddress());
        image_fitness.setImageResource(dataRecycler.get(position).getFitness());

    }

    @Override
    public int getItemCount() {
        return dataRecycler.size();
    }


}
