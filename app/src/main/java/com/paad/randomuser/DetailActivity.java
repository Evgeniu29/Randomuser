package com.paad.randomuser;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class DetailActivity extends Activity implements Serializable {


    TextView name;

    TextView gender;

    TextView phone;


    TextView email;

    TextView town;

    ImageView fullimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail);

        RecyclerView rvCharacters;

        name= (TextView) findViewById(R.id.fullname);
        gender = (TextView) findViewById(R.id.gender);
        phone = (TextView) findViewById(R.id.phone);
        email = (TextView) findViewById(R.id.email);
        town = (TextView) findViewById(R.id.town);

        fullimage = (ImageView) findViewById(R.id.fullimage);

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", 0);

        name.setText(Singlton.getInstance().characterList.get(position).name.getFirst()+" "+ Singlton.getInstance().characterList.get(position).name.getLast());

        gender.setText(Singlton.getInstance().characterList.get(position).gender);


        phone.setText(Singlton.getInstance().characterList.get(position).phone);

        email.setText(Singlton.getInstance().characterList.get(position).email);

        town.setText(Singlton.getInstance().characterList.get(position).location.getCity());

        Glide.with(this).load(Singlton.getInstance().characterList.get(position).picture.getLarge())
                .into(fullimage);

    }
}
