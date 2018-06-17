package com.uca.gamenews.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uca.gamenews.R;
import com.uca.gamenews.Tablas.New;

public class Info_New extends AppCompatActivity {

    public ImageView more_image;
    public TextView more_title;
    public TextView more_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__new);

        more_image = findViewById(R.id.more_info_image);
        more_title = findViewById(R.id.more_info_title);
        more_detail = findViewById(R.id.more_info_Desc);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        New news = (New) bundle.getSerializable("KEY");

        more_title.setText(news.title);
        more_detail.setText(news.description);

        if (news.getCoverImage().isEmpty()){
            Picasso.get().load(news.getCoverImage()).into(more_image);

        }else{
            Picasso.get().load(news.getCoverImage()).error(R.drawable.ic_launcher_background).into(more_image);

        }




    }





}
