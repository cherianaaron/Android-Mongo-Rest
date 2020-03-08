package com.example.androidmongorest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface RetroFit {
    @GET("getAll")
    Call<JsonArray> getAll();

    @POST("createCollection")
    Call<JsonObject> createCollection(@Body JsonObject collectionName);

    @POST("getCollection")
    Call<JsonArray> getCollection(@Body JsonObject collectionName);

    @POST("insertToCollection")
    Call<JsonObject> insertToCollection(@Body JsonObject object);

    //The below can be done outside the class.
    public static final Retrofit retro = new Retrofit.Builder()
            .baseUrl("http://[2607:ea00:200:500:c5e7:e046:48b5:f2ab]:42000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}


