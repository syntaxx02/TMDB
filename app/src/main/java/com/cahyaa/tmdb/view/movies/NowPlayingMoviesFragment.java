package com.cahyaa.tmdb.view.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.cahyaa.tmdb.R;
import com.cahyaa.tmdb.model.Movies;

import java.util.ArrayList;
import java.util.List;

public class NowPlayingMoviesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_now_playing_movies, container, false);
    }

    public void showMovies(){
        List<Movies> movies = new ArrayList<>();
        movies.add(new Movies());
    }
}