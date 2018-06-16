package com.uca.gamenews.Entitys;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity
public class Player_Entity {

    @PrimaryKey
    @NonNull
    private int _id;
    private String name;
    private String biogrfia;
    private String avatar;
    private String game;

    public Player_Entity(int _id, String name, String biogrfia, String avatar, String game) {
        this._id = _id;
        this.name = name;
        this.biogrfia = biogrfia;
        this.avatar = avatar;
        this.game = game;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiogrfia() {
        return biogrfia;
    }

    public void setBiogrfia(String biogrfia) {
        this.biogrfia = biogrfia;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
