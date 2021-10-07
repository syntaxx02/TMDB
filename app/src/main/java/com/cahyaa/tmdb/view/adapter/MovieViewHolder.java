package com.cahyaa.tmdb.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cahyaa.tmdb.R;
import com.cahyaa.tmdb.model.Movies;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(Movies movies) {
        ImageView imageView_movie_background = itemView.findViewById(R.id.imageView_movie_background);
        TextView textView_movie_title = itemView.findViewById(R.id.textView_movie_title);
        TextView textView_release_date = itemView.findViewById(R.id.textView_release_date);
        TextView textView_rating = itemView.findViewById(R.id.textView_rating);
        TextView textView_popularity = itemView.findViewById(R.id.textView_popularity);

        Glide.with(itemView.getContext()).load(movies.getBackdrop_path()).into(imageView_movie_background);
        textView_movie_title.setText(movies.getTitle());
        textView_release_date.setText(movies.getRelease_date());
        textView_rating.setText(String.valueOf(movies.getVote_count()));
        textView_popularity.setText(String.valueOf(movies.getPopularity()));
    }
}
