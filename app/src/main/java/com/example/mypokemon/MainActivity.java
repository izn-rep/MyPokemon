package com.example.mypokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mypokemon.adapter.ListPokemonAdapter;
import com.example.mypokemon.model.Pokemon;
import com.example.mypokemon.model.PokemonData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean buttonBackToExit = false;
    private RecyclerView rvPokemon;
    private ArrayList<Pokemon> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Top 10 Pokemon");

        rvPokemon = findViewById(R.id.rv_pokemon);
        rvPokemon.setHasFixedSize(true);

        list.addAll(PokemonData.getListData());
        showRecyclerList();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.btn_about:
                Intent moveIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(moveIntent);
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void showRecyclerList(){
        rvPokemon.setLayoutManager(new LinearLayoutManager(this));
        ListPokemonAdapter listPokemonAdapter = new ListPokemonAdapter(list);
        rvPokemon.setAdapter(listPokemonAdapter);

        listPokemonAdapter.setOnItemClickCallback(new ListPokemonAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Pokemon data) {
                showSelectedPokemon(data);
            }
        });
    }

    private void showSelectedPokemon(Pokemon pokemon){
//        Toast.makeText(this,"You tap on "+ pokemon.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME,pokemon.getName());
        intent.putExtra(DetailActivity.EXTRA_DETAIL,pokemon.getDetail());
        intent.putExtra(DetailActivity.EXTRA_IMG,pokemon.getPhoto());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (buttonBackToExit) {
            super.onBackPressed();
            return;
        }

        this.buttonBackToExit = true;
        Toast.makeText(this, "Press again to exit the app", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                buttonBackToExit = false;
            }
        }, 2000);
    }
}
