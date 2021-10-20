package com.cahyaa.tmdb.view.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.cahyaa.tmdb.databinding.FragmentNowPlayingMoviesBinding;
import com.cahyaa.tmdb.model.NowPlaying;
import com.cahyaa.tmdb.view.adapter.NowPlayingAdapter;
import com.cahyaa.tmdb.viewmodel.MovieViewModel;

public class NowPlayingMoviesFragment extends Fragment {

    private FragmentNowPlayingMoviesBinding binding;

    private MovieViewModel view_model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNowPlayingMoviesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        view_model = new ViewModelProvider(getActivity()).get(MovieViewModel.class);
        view_model.getNowPlaying();
        view_model.getResultGetNowPlaying().observe(getActivity(), showNowPlaying);

        return view;
    }

    private Observer<NowPlaying> showNowPlaying = new Observer<NowPlaying>() {
        @Override
        public void onChanged(NowPlaying nowPlaying) {
            binding.rvNowPlayingFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
            NowPlayingAdapter adapter = new NowPlayingAdapter(getActivity(), nowPlaying.getResults());
            binding.rvNowPlayingFragment.setAdapter(adapter);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}