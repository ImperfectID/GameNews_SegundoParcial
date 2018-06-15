package com.uca.gamenews.API;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.uca.gamenews.Tablas.New;

import java.lang.reflect.Type;

public class New_Deserializer implements JsonDeserializer<New> {
    @Override
    public New deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        New news = new New();

        JsonObject jsonnews = json.getAsJsonObject();

        if(jsonnews.get("_id")!=null){
            news.set_id(jsonnews.get("_id").getAsInt());

        }else {
            news.set_id(Integer.parseInt(""));

        }
        if(jsonnews.get("title")!=null) {
            news.setTitle(jsonnews.get("title").getAsString());

        }else {

            news.setTitle("");
        }

        if(jsonnews.get("coverImage")!=null) {
            news.setCoverImage(jsonnews.get("coverImage").getAsString());
        }else{
            news.setCoverImage("");

        }

        if(jsonnews.get("created_date")!=null){
            news.setCreated_date(jsonnews.get("crated_date").getAsString());

        }else{

            news.setCoverImage("");
        }

        if(jsonnews.get("description")!=null){
            news.setDescription(jsonnews.get("description").getAsString());


        }else{
            news.setDescription("");

        }

        if (jsonnews.get("body")!=null){
            news.setBody(jsonnews.get("body").getAsString());
        }else{
            news.setBody("");

        }

        if (jsonnews.get("game")!=null){
            news.setGame(jsonnews.get("game").getAsString());

        }else{
            news.setGame("");


        }


        return news;
    }
}
