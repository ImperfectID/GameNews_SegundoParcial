package com.uca.gamenews.API;


import com.uca.gamenews.Tablas.New;
import com.uca.gamenews.Tablas.Player;
import com.uca.gamenews.Tablas.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface API_GN {


    String ENDPOINT = "http://gamenewsuca.herokuapp.com";


    @FormUrlEncoded
    @POST("/login")
    Call<String> token(@Field("user") String username, @Field("password") String password);


    @GET("/users")
    Call<List<User>> get_Users(@Header("Authorization") String usuario);

    @GET("/news")
    Call<List<New>> getNews(@Header("Authorization") String noticia);


    @GET("/players")
    Call<List<Player>> getPlayer(@Header("Authorization") String player);




}
