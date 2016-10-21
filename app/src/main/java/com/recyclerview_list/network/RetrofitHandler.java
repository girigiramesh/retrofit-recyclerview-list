package com.recyclerview_list.network;

import com.recyclerview_list.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ramesh on 10/21/16.
 */
public class RetrofitHandler {
    private static RetrofitHandler ourInstance = new RetrofitHandler();

    public static RetrofitHandler getInstance() {
        return ourInstance;
    }

    private Retrofit ipApiService = new Retrofit.Builder()
            .baseUrl("http://humos-staging.mybluemix.net")
            .addConverterFactory(StringConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private HumOsStaging service = ipApiService.create(HumOsStaging.class);

    private RetrofitHandler() {
    }

    public  Call<List<Response>> getMessageList() {
        return service.getMessageList();
    }
}
