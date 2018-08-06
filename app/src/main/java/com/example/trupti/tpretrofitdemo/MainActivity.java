package com.example.trupti.tpretrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Android_Version_java> data;
    private DataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
       LoadJson();
    }

    private void LoadJson() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://vaksys.com/100_application/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final RequestInterface request=retrofit.create(RequestInterface.class);
        Call<Json_Response> call =request.getJson();
        call.enqueue(new Callback<Json_Response>() {
            @Override
            public void onResponse(Call<Json_Response> call, Response<Json_Response> response) {

                Json_Response json_response=response.body();
                data=new ArrayList<>(Arrays.asList(json_response.getRow()));
                adapter=new DataAdapter(data,getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Json_Response> call, Throwable t) {

            }
        });
    }
}










