package com.example.mypokemon;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import javax.microedition.khronos.opengles.GL;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_IMG = "extra_img";
    private TextView tv_item_name;
    private TextView tv_item_detail;
    private ImageView img_item_photo;
    private Context  context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pokemon);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pokemon Detail");

        int pokemonImage = getIntent().getIntExtra(EXTRA_IMG,0);
        String pokemonName = getIntent().getStringExtra(EXTRA_NAME);
        String pokemonDetail = getIntent().getStringExtra(EXTRA_DETAIL);

        tv_item_name = findViewById(R.id.tv_item_name);
        tv_item_name.setText(pokemonName);

        tv_item_detail = findViewById(R.id.tv_item_detail);
        tv_item_detail.setText(pokemonDetail);

        img_item_photo = findViewById(R.id.img_item_photo);
        img_item_photo.setImageResource(pokemonImage);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
