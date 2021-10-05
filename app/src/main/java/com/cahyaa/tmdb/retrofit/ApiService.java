package com.cahyaa.tmdb.retrofit;

import com.cahyaa.tmdb.helper.Const;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static Retrofit retrofit;

    public static com.cahyaa.tmdb.retrofit.ApiEndPoint endPoint(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(com.cahyaa.tmdb.retrofit.ApiEndPoint.class);
    }

}
