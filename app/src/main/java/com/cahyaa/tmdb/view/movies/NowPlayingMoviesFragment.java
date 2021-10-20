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
import com.cahyaa.tmdb.model.Search;
import com.cahyaa.tmdb.view.adapter.NowPlayingAdapter;
import com.cahyaa.tmdb.viewmodel.MovieViewModel;

import java.util.ArrayList;

public class NowPlayingMoviesFragment extends Fragment {

    private FragmentNowPlayingMoviesBinding binding;

    private MovieViewModel view_model;

    private NowPlayingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNowPlayingMoviesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        view_model = new ViewModelProvider(getActivity()).get(MovieViewModel.class);
        view_model.getNowPlaying();
        view_model.getResultGetNowPlaying().observe(getActivity(), showNowPlaying);
        view_model.getResultGetMovieResult().observe(getActivity(), showSearchResult);

        return view;
    }

    private Observer<NowPlaying> showNowPlaying = new Observer<NowPlaying>() {
        @Override
        public void onChanged(NowPlaying nowPlaying) {
            binding.rvNowPlayingFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new NowPlayingAdapter(getActivity(), nowPlaying.getResults());
            binding.rvNowPlayingFragment.setAdapter(adapter);
        }
    };

    private Observer<Search> showSearchResult = new Observer<Search>() {
        @Override
        public void onChanged(Search search) {
            adapter.updateList(convertToNowPlayingResult(search));
        }
    };

    public ArrayList<NowPlaying.Results> convertToNowPlayingResult(Search search) {
        ArrayList<NowPlaying.Results> nowPlayingResults = new ArrayList<NowPlaying.Results>();
        for (Search.Results searchResult : search.getResults()) {
            NowPlaying.Results nowPlaying = new NowPlaying.Results();
            nowPlaying.setBackdrop_path(searchResult.getBackdrop_path());
            nowPlaying.setTitle(searchResult.getTitle());
            nowPlaying.setRelease_date(searchResult.getRelease_date());
            nowPlaying.setVote_average(searchResult.getVote_count());
            nowPlaying.setPopularity(searchResult.getPopularity());
            nowPlayingResults.add(nowPlaying);
        }
        return nowPlayingResults;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}