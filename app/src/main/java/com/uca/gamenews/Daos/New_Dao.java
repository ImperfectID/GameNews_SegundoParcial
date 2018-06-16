package com.uca.gamenews.Daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.view.LayoutInflater;

import com.uca.gamenews.Entitys.New_Entity;
import com.uca.gamenews.Tablas.New;

import java.util.List;


@Dao
public interface New_Dao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(New_Entity New);

    @Update
    void update(New_Entity New);

    @Query("SELECT * FROM New_Entity ORDER BY create_date ASC")
    LiveData<List<New>> getAllnews();


    //@Query("SELECT * FROM New_Entity WHERE title LIKE searchbar")
    //LiveData<List<New>> getQuery;






}
