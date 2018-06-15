package com.uca.gamenews.API;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.uca.gamenews.Tablas.New;
import com.uca.gamenews.Tablas.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class User_Deserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        User user = new User();
        JsonObject jsonuser = new JsonObject();

       user.set_id(jsonuser.get("_id").getAsInt());
       user.setUser(jsonuser.get("user").getAsString());
       user.setPassword(jsonuser.get("password").getAsString());


       JsonElement elementnews = jsonuser.get("favoriteNews");
       JsonArray arraynews = elementnews.getAsJsonArray();
       user.setFavoriteNews(getfavorite(arraynews));





        return user;
    }



    private List<New> getfavorite(JsonArray jsonArray){
        List<New> newList = new ArrayList<>();
        for(JsonElement json: jsonArray){
            New news = new New();
            news.set_id(jsonArray.getAsJsonObject().get("_id").getAsInt());
            news.setTitle(jsonArray.getAsJsonObject().get("title").getAsString());
            news.setCoverImage(jsonArray.getAsJsonObject().get("coverImage").getAsString());
            news.setCreated_date(jsonArray.getAsJsonObject().get("created_date").getAsString());
            news.setDescription(jsonArray.getAsJsonObject().get("description").getAsString());
            news.setBody(jsonArray.getAsJsonObject().get("body").getAsString());
            news.setName(jsonArray.getAsJsonObject().get("name").getAsString());
            news.setGame(jsonArray.getAsJsonObject().get("game").getAsString());
            newList.add(news);


        }
    return newList;

    }
}
