package com.uca.gamenews.Daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.uca.gamenews.Entitys.Player_Entity;
import com.uca.gamenews.Tablas.Player;

import java.util.List;

@Dao
public interface Player_Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Player_Entity play);


   // @Update
    //void update(Player_Entity play);

    @Query("SELECT * FROM player_entity WHERE game =game")
    LiveData<List<Player>> getPlayers();





}
