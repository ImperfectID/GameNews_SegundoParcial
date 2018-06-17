package com.uca.gamenews.Entitys;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity
public class User_Entity {

    @NonNull
    @PrimaryKey

    private String _id;
    private  String user;
    private String password;



    public User_Entity(String _id, String user, String password) {
        this._id = _id;
        this.user = user;
        this.password = password;

    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
