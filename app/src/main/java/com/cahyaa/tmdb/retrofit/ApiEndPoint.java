package com.cahyaa.tmdb.retrofit;

import com.cahyaa.tmdb.model.Movies;
import com.cahyaa.tmdb.model.NowPlaying;
import com.cahyaa.tmdb.model.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoint {

    @GET("movie/{movie_id}")
    Call<Movies> getMovieById(
            @Path("movie_id") String movieId,
            @Query("api_key") String apiKey
    );

    @GET("movie/now_playing")
    Call<NowPlaying> getNowPlaying(
            @Query("api_key") String apiKey
    );

    @GET("search/movie")
    Call<Search> getMovieResult(
            @Query("api_key") String apiKey,
            @Query("query") String query
    );
}
