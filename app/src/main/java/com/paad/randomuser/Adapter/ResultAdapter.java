package com.paad.randomuser.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.paad.randomuser.API.Result;
import com.paad.randomuser.DetailActivity;
import com.paad.randomuser.R;
import com.paad.randomuser.Singlton;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    private List<Result> results ;
    private Context context;
    private int index;


    public ResultAdapter(List<Result> results, Context context){
        this.results = results;
        this.context = context;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, @SuppressLint("RecyclerView") final int i) {
        final int index = i;
        Glide.with(context).load(Singlton.getInstance().characterList.get(i).picture.getMedium())
                .into(holder.image);
        holder.textName.setText(results.get(i).getName().getFirst());

        holder.textName.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("position", index);
                startActivity(context, intent, null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder{

        TextView textName;
        ImageView image;

        ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);

        }
    }
}