package com.recyclerview_list.network;

import com.recyclerview_list.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ramesh on 10/21/16.
 */

public interface HumOsStaging {

    @GET("/api/v3/messages")
    Call<Response> getMessageList();
}
