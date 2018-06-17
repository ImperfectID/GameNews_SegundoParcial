package com.uca.gamenews.Daos;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uca.gamenews.Entitys.Game_Entity;

import java.util.List;

@Dao
public interface Game_Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Game_Entity... games);

    @Query("SELECT * FROM Game_Entity")
    LiveData<List<Game_Entity>> getAllGames();

}
