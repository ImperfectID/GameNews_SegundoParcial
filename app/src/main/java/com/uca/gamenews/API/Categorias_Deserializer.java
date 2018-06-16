package com.uca.gamenews.API;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Categorias_Deserializer implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        List<String> categorias = new ArrayList<>();
        JsonArray jsonArray = json.getAsJsonArray();
         for (JsonElement jsonElement:jsonArray){
             categorias.add(jsonElement.getAsString());

         }


        return  categorias;
    }
}
