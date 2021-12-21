package com.example.pafitness;

import android.content.Intent;
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
        final RecyclerModel data = dataRecycler.get(position);
        TextView text_judul = holder.textJudul;
        TextView text_alamat = holder.textAlamat;
        ImageView image_fitness = holder.fotofitness;

        text_judul.setText(data.getName());
        text_alamat.setText(data.getAddress());
        image_fitness.setImageResource(data.getFitness());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("RecyclerModel", data);
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataRecycler.size();
    }

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


}
