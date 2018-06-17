package com.uca.gamenews;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.uca.gamenews.Daos.New_Dao;
import com.uca.gamenews.Daos.Player_Dao;
import com.uca.gamenews.Entitys.New_Entity;
import com.uca.gamenews.Entitys.Player_Entity;
import com.uca.gamenews.Entitys.User_Entity;


@Database(entities = {New_Entity.class, Player_Entity.class, User_Entity.class},exportSchema = false, version = 1)

public abstract class GN_DB extends RoomDatabase {

    public static volatile GN_DB gn_db;
    public static final String DB_NAME = "GN_DB.db";

    public static GN_DB getDB(Context context){
        if(gn_db ==null) {
            synchronized (GN_DB.class) {
                if (gn_db == null) {
                    gn_db = Room.databaseBuilder(context,GN_DB.class,DB_NAME).build();

                }
            }
        }
        return gn_db;
    }

    public abstract New_Dao new_dao();

    public abstract Player_Dao player_dao();




}
