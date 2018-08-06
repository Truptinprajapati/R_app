package com.example.trupti.tpretrofitdemo;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lenovo on 30-07-2018.
 */

public interface RequestInterface {

    @GET("more_apps")
    Call<Json_Response> getJson();

}
