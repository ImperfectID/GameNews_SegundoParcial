package com.uca.gamenews.Models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uca.gamenews.Entitys.New_Entity;
import com.uca.gamenews.Repository.New_Repository;
import com.uca.gamenews.Tablas.New;

import java.util.List;

public class New_View_Model  extends AndroidViewModel{


    private New_Repository new_repository;

    public New_View_Model(@NonNull Application application) {
        super(application);
        new_repository = new New_Repository(application);
    }

    public void insert(New_Entity new_entity){
        new_repository.insert(new_entity);
    }
    public void update(New_Entity new_entity){
        new_repository.update(new_entity);
    }
    public LiveData<List<New>> GetAllNews(){
        return new_repository.getNews();
    }
}
