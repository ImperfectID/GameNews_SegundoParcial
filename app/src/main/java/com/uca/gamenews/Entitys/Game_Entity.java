package com.uca.gamenews.Entitys;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Game_Entity {

   @PrimaryKey
    @NonNull
    private String Game_Entity;

    public Game_Entity(@NonNull String game_Entity) {
        Game_Entity = game_Entity;
    }

    @NonNull
    public String getGame_Entity() {
        return Game_Entity;
    }

    public void setGame_Entity(@NonNull String game_Entity) {
        Game_Entity = game_Entity;
    }
}
