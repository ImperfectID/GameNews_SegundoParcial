package com.uca.gamenews.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uca.gamenews.API.API_GN;
import com.uca.gamenews.API.New_Deserializer;
import com.uca.gamenews.Daos.New_Dao;
import com.uca.gamenews.Entitys.New_Entity;
import com.uca.gamenews.GN_DB;
import com.uca.gamenews.Tablas.New;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class New_Repository {

    private New_Dao new_dao;
    private LiveData<List<New>> news;
    private API_GN api_gn;

    public New_Repository(Application application) {
        GN_DB db = GN_DB.getDB(application);
        new_dao = db.new_dao();

    }

    public LiveData<List<New>> getNews(){
        return new_dao.getAllnews();
    }
    public void insert(New_Entity new_entity){
        new instertAsyncTask(new_dao).execute(new_entity);
    }
    public void update(New_Entity new_entity){
        new updateAsyncTask(new_dao).execute(new_entity);
    }





    private void CreateApi(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request builder = request.newBuilder().header("Authorization","name").build();
                        return chain.proceed(builder);
                    }
                }).build();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .registerTypeAdapter(New.class, new New_Deserializer()).create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_GN.ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api_gn=retrofit.create(API_GN.class);

        Call<List<New>> getNews = api_gn.getNews("Beared");
        getNews.enqueue(new Callback<List<New>>() {
            @Override
            public void onResponse(Call<List<New>> call, retrofit2.Response<List<New>> response) {
                List<New> news = response.body();

            }

            @Override
            public void onFailure(Call<List<New>> call, Throwable t) {

            }
        });



    }


    private static class instertAsyncTask extends AsyncTask<New_Entity,Void,Void>{

        private New_Dao AsyncDao;
        instertAsyncTask(New_Dao dao){
            AsyncDao = dao;

        }

        @Override
        protected Void doInBackground(New_Entity... new_entities) {
            AsyncDao.insert(new_entities[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<New_Entity, Void, Void>{


        private New_Dao AsyncDao;
        updateAsyncTask(New_Dao dao){
            AsyncDao = dao;
        }

        @Override
        protected Void doInBackground(New_Entity... new_entities) {
            AsyncDao.insert(new_entities[0]);
            return null;
        }
    }

}
