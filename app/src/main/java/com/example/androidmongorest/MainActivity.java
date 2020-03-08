package com.example.androidmongorest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.view.ViewStructure;
import retrofit2.Retrofit;
import com.google.gson.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

public class MainActivity extends AppCompatActivity {

    public com.example.androidmongorest.RetroFit RetroFit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getAll(View view){
        RetroFit = RetroFit.retro.create(RetroFit.class);

        Call<JsonArray> call = this.RetroFit.getAll();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, retrofit2.Response<JsonArray> response) {
                Log.d("GETALL", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("GETALL", "FAILED");
            }
        });

    }

    public void getCollection(View view){
        RetroFit = RetroFit.retro.create(RetroFit.class);

        //String json = "Restaurants";
        //JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonObject json = new JsonObject();
        json.addProperty("name", "getCollection");

        Call<JsonArray> call = this.RetroFit.getCollection(json);
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, retrofit2.Response<JsonArray> response) {
                Log.d("GETCOLLECTION", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("GETCOLLECTION", "FAILED");
                t.printStackTrace();
            }
        });
    }

    public void insertToCollection(View view){
        RetroFit = RetroFit.retro.create(RetroFit.class);

        JsonObject json = new JsonObject();
        json.addProperty("name", "NewData");

        Call<JsonObject> call = this.RetroFit.insertToCollection(json);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                Log.d("INSERTTOCOLLECTION", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("INSERTTOCOLLECTION", "FAILED");
            }
        });

    }

    public void createCollection(View view){
        RetroFit = RetroFit.retro.create(RetroFit.class);

        JsonObject json = new JsonObject();
        json.addProperty("name", "TestCollection");

        Call<JsonObject> call = this.RetroFit.createCollection(json);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                Log.d("CREATECOLLECTION", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("CREATECOLLECTION", "FAILED");
                t.printStackTrace();

            }
        });
    }




}
