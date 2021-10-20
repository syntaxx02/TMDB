package com.cahyaa.tmdb.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cahyaa.tmdb.model.Movies;
import com.cahyaa.tmdb.model.NowPlaying;
import com.cahyaa.tmdb.model.Search;
import com.cahyaa.tmdb.repositories.MovieRepository;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository repository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository = MovieRepository.getInstance();
    }

    //*Begin of ViewModel getMovieById
    private MutableLiveData<Movies> resultGetMovieById = new MutableLiveData<>();

    public void getMovieById(String movieId) {
        resultGetMovieById = repository.getMovieData(movieId);
    }

    public LiveData<Movies> getResultGetMovieById() {
        return resultGetMovieById;
    }
    //End of ViewModel getMovieById

    //*Begin of ViewModel getNowPlaying
    private MutableLiveData<NowPlaying> resultGetNowPlaying = new MutableLiveData<>();

    public void getNowPlaying() {
        resultGetNowPlaying = repository.getNowPlayingData();
    }

    public LiveData<NowPlaying> getResultGetNowPlaying() {
        return resultGetNowPlaying;
    }
    //End of ViewModel getNowPlaying

    //*Begin of ViewModel getMovieResult
    private MutableLiveData<Search> resultGetMovieResult = new MutableLiveData<>();

    public void getMovieResult(String query) {
        resultGetMovieResult = repository.getSearchData(query);
    }

    public LiveData<Search> getResultGetMovieResult() {
        return resultGetMovieResult;
    }
    //End of ViewModel getMovieResult
}
