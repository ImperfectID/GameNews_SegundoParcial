package com.uca.gamenews.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uca.gamenews.Entitys.New_Entity;
import com.uca.gamenews.R;

import java.io.Serializable;
import java.util.List;

public class New_Adapter extends RecyclerView.Adapter<New_Adapter.New_VH> {

    private Context context;
    private List<New_Entity> new_entities;

    LayoutInflater layoutInflater;

    private New_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public New_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.card_view, parent, false);
        return new New_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull New_VH holder, int position) {

        final New_Entity new_entity = new_entities.get(position);
        holder.N_Title.setText(new_entity.getTitle());
        holder.N_Description.setText(new_entity.getDescription());

        if (new_entity.getCoverImage().isEmpty()) {
            Picasso.get().load(new_entity.getCoverImage()).error(R.drawable.ic_launcher_background).into(holder.N_image);


        } else {
            Picasso.get().load(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(holder.N_image);

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Info_New.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("KEY", (Serializable) new_entity);
                intent.putExtras(bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class New_VH extends RecyclerView.ViewHolder {

        private ScrollView cardView;
        private TextView N_Title;
        private TextView N_Description;
        private ImageView N_image;

        public New_VH(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.more);
            N_image = itemView.findViewById(R.id.cover_image);
            N_Title = itemView.findViewById(R.id.cv_title);
            N_Description = itemView.findViewById(R.id.description);
        }
    }
}
