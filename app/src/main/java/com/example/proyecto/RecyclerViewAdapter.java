package com.example.proyecto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    private ArrayList<String> texto_inc = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> texto_inc, Context mContext) {
        this.texto_inc = texto_inc;
        this.mContext = mContext;
    }

    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incubacion_items,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.texto.setText(texto_inc.get(i));
    }

    @Override
    public int getItemCount() {
        return texto_inc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView texto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            texto = itemView.findViewById(R.id.texto_incubacion);

        }
    }
}
