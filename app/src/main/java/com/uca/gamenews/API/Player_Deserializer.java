package com.uca.gamenews.API;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.uca.gamenews.Tablas.Player;

import java.lang.reflect.Type;

public class Player_Deserializer implements JsonDeserializer<Player> {
    @Override
    public Player deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Player player = new Player();


        JsonObject jsonplayer = new JsonObject();


        if (jsonplayer.get("_id")!=null){
            player.set_id(jsonplayer.get("_id").getAsInt());

        }else{
            player.set_id(Integer.parseInt(""));

        }

        if (jsonplayer.get("name")!=null){
            player.setName(jsonplayer.get("name").getAsString());

        }else{
            player.setName("");

        }

        if (jsonplayer.get("biografia")!=null){
            player.setBiografia(jsonplayer.get("biografia").getAsString());

        }else{
            player.setBiografia("");

        }
        if(jsonplayer.get("avatar")!=null){
            player.setAvatar(jsonplayer.get("avatear").getAsString());

        }else{
            player.setAvatar("");
        }
        if(jsonplayer.get("game")!=null){
            player.setGame(jsonplayer.get("game").getAsString());

        }else{
            player.setGame("");
        }


        return player;
    }
}
