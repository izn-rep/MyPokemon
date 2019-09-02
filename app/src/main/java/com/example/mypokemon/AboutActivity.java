package com.example.mypokemon;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Author");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
