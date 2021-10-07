package com.cahyaa.tmdb.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cahyaa.tmdb.R;
import com.cahyaa.tmdb.model.Movies;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    Context context;
    List<Movies> movies;

    public MoviesAdapter(Context context, List<Movies> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movies, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
