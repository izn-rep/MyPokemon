package com.example.mypokemon.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mypokemon.DetailActivity;
import com.example.mypokemon.MainActivity;
import com.example.mypokemon.R;
import com.example.mypokemon.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class ListPokemonAdapter extends RecyclerView.Adapter<ListPokemonAdapter.ListViewHolder> {
    private ArrayList<Pokemon> listPokemon;
    private OnItemClickCallback onItemClickCallback;
    private Context context;

    ListPokemonAdapter(Context context){
        this.context = context;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListPokemonAdapter(ArrayList<Pokemon> list){
        this.listPokemon = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_pokemon,viewGroup,false);
        return new ListViewHolder(view);
    }

    public interface OnItemClickCallback{
        void onItemClicked(Pokemon data);
    }

    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Pokemon pokemon = listPokemon.get(position);

        Glide.with(holder.itemView.getContext()).load(pokemon.getPhoto()).apply(new RequestOptions().override(55,55)).into(holder.imgPhoto);

        holder.tvName.setText(pokemon.getName());
        holder.tvDetail.setText(pokemon.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listPokemon.get(holder.getAdapterPosition()));
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                startActivity(intent);
//                final Intent intent;
//                intent = new Intent(context, DetailActivity.class);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName,tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
