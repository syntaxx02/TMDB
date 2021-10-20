package com.cahyaa.tmdb.repositories;

import androidx.lifecycle.MutableLiveData;

import com.cahyaa.tmdb.helper.Const;
import com.cahyaa.tmdb.model.Movies;
import com.cahyaa.tmdb.model.NowPlaying;
import com.cahyaa.tmdb.model.Search;
import com.cahyaa.tmdb.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository repository;

    private MovieRepository() {
    }

    public static MovieRepository getInstance() {
        if (repository == null) {
            repository = new MovieRepository();
        }
        return repository;
    }

    public MutableLiveData<Movies> getMovieData(String movieId) {
        final MutableLiveData<Movies> result = new MutableLiveData<>();

        ApiService.endPoint().getMovieById(movieId, Const.API_KEY).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });

        return result;
    }

    public MutableLiveData<NowPlaying> getNowPlayingData() {
        final MutableLiveData<NowPlaying> result = new MutableLiveData<>();

        ApiService.endPoint().getNowPlaying(Const.API_KEY).enqueue(new Callback<NowPlaying>() {
            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {

            }
        });

        return result;
    }

    public MutableLiveData<Search> getSearchData(String query) {
        final MutableLiveData<Search> result = new MutableLiveData<>();

        ApiService.endPoint().getMovieResult(Const.API_KEY, query).enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {

            }
        });

        return result;
    }
}
